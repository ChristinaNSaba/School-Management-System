package Application;


import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TableDesign {
    public String[][] res; // table data
    public String[] lab; // columns labels
    ObservableList<ObservableList<String>> data;
    TableView<ObservableList<String>> tableView = new TableView<>();
    int index;
    // table for data
    String table;

    public TableDesign(String[][] res, String[] lab, String table) {
        super();
        this.res = res;
        this.lab = lab;
        this.table = table;
    }

    public void deleteRow(TableView<ObservableList<String>> t, int rowNo) {
        ObservableList<TableColumn<ObservableList<String>, ?>> cols = t.getColumns();
        // ObservableList<ObservableList<String>>
        // row=t.getSelectionModel().getSelectedItems().
        // ObservableList<String> id=row.get(idIndex);
    }

    public ObservableList<ObservableList<String>> buildData(String[][] dataArray) {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        for (String[] row : dataArray) {
            data.add(FXCollections.observableArrayList(row));
        }

        return data;
    }

    public TableView<ObservableList<String>> createTableView() {
        index = Sql.getColumnIndex(lab, "id") - 1;
        tableView.setEditable(true);
        TableColumn<ObservableList<String>, Number> indexColumn = new TableColumn<ObservableList<String>, Number>("#");
        indexColumn.setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<Number>(tableView.getItems().indexOf(column.getValue())));
        indexColumn.setPrefWidth(10);
        tableView.getColumns().add(indexColumn);

        if(res.length > 0 && res[0].length > 0) {
            for (int i = 0; i < res[0].length; i++) {
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(lab[i]);
                final int j = i;
                column.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(j)));
                if (j != index)
                    column.setCellFactory(TextFieldTableCell.forTableColumn());
                //column.prefWidthProperty().bind(tableView.widthProperty().divide(lab.length));
                column.setPrefWidth(100);
                /// update sql
                column.setOnEditCommit(t -> {
                    update(t, column);
                });
                tableView.getColumns().add(column);
            }

        }
        indexColumn.setCellValueFactory(
                column -> new ReadOnlyObjectWrapper<Number>(tableView.getItems().indexOf(column.getValue())));
        data = buildData(res);
        tableView.setItems(data);
        tableView.setPrefWidth(917);
        tableView.setPrefHeight(327);
        tableView.setTableMenuButtonVisible(true);
        // delete button
        TableColumn col_action = new TableColumn<>("Action");
        tableView.getColumns().add(col_action);
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ObservableList<String>, Boolean>, ObservableValue<Boolean>>() {
                    @Override
                    public ObservableValue<Boolean> call(
                            TableColumn.CellDataFeatures<ObservableList<String>, Boolean> p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });

        // Adding the Button to the cell
        col_action.setCellFactory(
                new Callback<TableColumn<ObservableList<String>, Boolean>, TableCell<ObservableList<String>, Boolean>>() {

                    @Override
                    public TableCell<ObservableList<String>, Boolean> call(
                            TableColumn<ObservableList<String>, Boolean> p) {
                        try {
                            return new ButtonCell();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                });

        return tableView;
    }

    private void update(CellEditEvent<ObservableList<String>, String> t,
                        TableColumn<ObservableList<String>, String> column) {
        // TODO Auto-generated method stub
        int indexToChange = t.getTablePosition().getColumn();
        int idRow = t.getTablePosition().getRow();
        String idValue = t.getTableView().getItems().get(idRow).get(index);
        String attChange = lab[indexToChange - 1];
        Sql.update(table, attChange, t.getNewValue(), idValue, "id");
    }

    // Define the button cell
    private class ButtonCell extends TableCell<ObservableList<String>, Boolean> {
        Button cellButton = new Button("Delete");

        ButtonCell() throws FileNotFoundException {
            cellButton.setOnAction(e -> {

                // get Selected Item
                ObservableList<String> currentRow = ButtonCell.this.getTableView().getItems()
                        .get(ButtonCell.this.getIndex());
                // remove from sql
                int idIndex = -2;
                idIndex = Sql.getColumnIndex(lab, "id");
                Sql.delete(table, "id", currentRow.get(idIndex - 1));
                data.remove(currentRow);

            });
            Image image = new Image(new FileInputStream("C:\\Users\\Lenovo\\Desktop\\SchoolMan2\\src\\application\\delete.png"));
            cellButton.setGraphic(new ImageView(image));
        }

        // Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellButton);
            }
        }
    }
}
