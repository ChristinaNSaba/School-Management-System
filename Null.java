package Application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.awt.*;
import java.util.ArrayList;

public class Null {
    public static boolean isNull(TextField x) {
        if (x == null)
            return false;
        return x.getText() == null || x.getText().trim().isEmpty();
    }

    public static void showAlert(String err, String type) { //show alert

        Alert error = null;
        if (type.matches("error")) {
            error = new Alert(AlertType.ERROR);
            error.setContentText(err + " is Required !");
            error.setTitle(err);
            error.setHeaderText(err + "  can't be null !");
        }
        if (type.matches("info")) {
            error = new Alert(AlertType.INFORMATION);
            error.setContentText(err);
            error.setTitle(err);
            error.setHeaderText(err);
            Toolkit.getDefaultToolkit().beep();
            error.show();
            Stage s = (Stage) error.getDialogPane().getScene().getWindow();
            Image icon = new Image("Controller/icon.png");
            s.getIcons().add(icon);
        }
    }

    public static void showSqlError(String err) {
        Alert al;
        al = new Alert(AlertType.ERROR);
        al.setTitle("SQL ERROR");
        al.setHeaderText("An Error Occured when Excecuting Sql Statement");
        al.setContentText(err);
        Toolkit.getDefaultToolkit().beep();
        al.show();
    }

    public static void showConformation(String table) { ///show after successfull add
        Alert error = new Alert(null);
        error.setAlertType(AlertType.INFORMATION);
        error.setContentText("Success !");
        error.setTitle("Successfully Added !");
        error.setHeaderText(table + " Successfully Added !");
        Toolkit.getDefaultToolkit().beep();
        error.show();
        Stage s = (Stage) error.getDialogPane().getScene().getWindow();
        Image icon = new Image("Controller/icon.png");
        s.getIcons().add(icon);
    }

    public static void reset(ArrayList<TextField> t) { //make text field null
        for (int i = 0; i < t.size(); i++)
            t.get(i).setText("");
    }

}
