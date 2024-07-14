
package Application;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.security.KeyStore;
import java.util.*;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane mainLayout;
    private BorderPane mainLayout2;
    private Scene scene3;
    private static final String[] COURSES = {"Mathematics", "Science", "English"};
    private static final Map<String, Double> COURSE_GRADES = new HashMap<>();

    static {
        COURSE_GRADES.put("Mathematics", 85.0);
        COURSE_GRADES.put("Science", 92.5);
        COURSE_GRADES.put("English", 78.0);
    }

    private ComboBox<String> languageComboBox;
    private Button translateButton;
    private Label titleLabel;

    //Tables:
    private TableView<Course> courseTable;

    //Data:
    private ObservableList<Student> studentData;
    private ObservableList<Teacher> teacherData;
    private ObservableList<Employee> employeeData;
    private ObservableList<SchoolClass> classData;
    private ObservableList<Course> courseData;

    @Override
    public void start(Stage primaryStage) {


        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("School Management System");

        initializeData();

        // Create the main layout
        mainLayout = new BorderPane();
        mainLayout2 = new BorderPane();

        // Create the top toolbar
        HBox toolbar = createToolbar();
        mainLayout.setTop(toolbar);

        // Create the main menu
        VBox mainMenu = createMainMenu();
        mainLayout.setCenter(mainMenu);


        // Create the top toolbar
        HBox toolbar1 = createToolbar1();
        mainLayout2.setTop(toolbar1);

        // Create the main menu
        VBox mainMenu1 = createMainMenu1();
        mainLayout2.setCenter(mainMenu1);

        //add an image
        Image menuImage = new Image(getClass().getResourceAsStream("school1.png"));
        Image menuImage2 = new Image(getClass().getResourceAsStream("school1.png"));

        VBox infoSection = createInfoSection();
        infoSection.setLayoutX(450);
        infoSection.setLayoutY(555);

        VBox infoSection1 = createInfoSection();
        VBox infoSectionWork = createInfoSection();
        infoSection1.setLayoutX(450);
        infoSection1.setLayoutY(500);



        // Create an ImageView with the loaded image
        ImageView imageView = new ImageView(menuImage);
        ImageView imageView2 = new ImageView(menuImage2);

        BorderPane frame = createFrame();
        BorderPane frame1 = createFrame();
        frame.setLayoutX(350);
        frame.setLayoutY(105);
        frame1.setLayoutX(350);
        frame1.setLayoutY(105);


        // Set the image properties
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        imageView.setLayoutX(425);
        imageView.setLayoutY(210);
        imageView.setScaleX(1.75);
        imageView.setScaleY(1.75);
        imageView.setStyle("-fx-border-color: black; -fx-border-width: 6px;");

        imageView2.setFitWidth(200);
        imageView2.setPreserveRatio(true);
        imageView2.setLayoutX(425);
        imageView2.setLayoutY(210);
        imageView2.setScaleX(1.75);
        imageView2.setScaleY(1.75);
        imageView2.setStyle("-fx-border-color: black; -fx-border-width: 6px;");


        mainLayout.getChildren().add(imageView);
        mainLayout.getChildren().add(frame);
        mainLayout.getChildren().add(infoSection);
        mainLayout.getChildren().add(translateButton);

        mainLayout2.getChildren().add(imageView2);
        mainLayout2.getChildren().add(frame1);
        mainLayout2.getChildren().add(infoSection1);
        mainLayout2.getChildren().add(translateButton);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #F8F8F8");
        // Create a VBox for the content
        VBox vbox = new VBox();
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(80));
        vbox.setAlignment(Pos.CENTER);

        // Create the administrative button
        Button adminButton = createButton("Administrative");
        adminButton.getStyleClass().add("menu-button");
        adminButton.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
        adminButton.setOnAction(e -> {
            // Handle button click for the administrative section

            Scene scene3 = new Scene(mainLayout2, 800, 620);
            scene3.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setScene(scene3);
            primaryStage.show();
        });

        // Create the academic button
        Button academicButton = createButton("Academic");
        academicButton.getStyleClass().add("main-menu-button");
        academicButton.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
        academicButton.setOnAction(e -> {
            // Handle button click for the academic section
            System.out.println("Academic button clicked");
            // Create the initial scene
            Scene scene3 = new Scene(mainLayout, 800, 620);
            scene3.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setScene(scene3);
            primaryStage.show();
        });

        // Create the contact information section
        Label contact1 = createInfoLabel("Contact Us:", " ");
        Label schoolLabel1 = createInfoLabel("School's Number:", "022956567");

        Label principalLabel1 = createInfoLabel("Principle's Name:", "Iyad Abdallah Rafidi");
        Label phoneLabel1 = createInfoLabel("Phone Number:", "0599390622");
        Label emailLabel1 = createInfoLabel("Email Address:", "irafidi@hotmail.com");
        schoolLabel1.getStyleClass().add("menu-info");
        principalLabel1.getStyleClass().add("menu-info");
        phoneLabel1.getStyleClass().add("menu-info");
        emailLabel1.getStyleClass().add("menu-info");
        contact1.setMinSize(800, 20);
        schoolLabel1.setMinSize(800, 20);
        principalLabel1.setMinSize(800, 20);
        phoneLabel1.setMinSize(800, 20);
        emailLabel1.setMinSize(800, 20);

        Image mainMenuImage = new Image(getClass().getResourceAsStream("download1.png"));
        ImageView imageView1 = new ImageView(mainMenuImage);
        imageView1.setScaleX(0.8);
        imageView1.setScaleY(0.8);
        imageView1.setFitWidth(200);
        imageView1.setPreserveRatio(true);
        imageView1.setLayoutX(425);
        imageView1.setLayoutY(210);



        // Add the buttons and contact information to the VBox layout
        vbox.getChildren().addAll(imageView1, adminButton, academicButton);
        // Add the VBox layout to the StackPane
        root.getChildren().addAll(vbox);
        Scene scene1 = new Scene(root, 500, 500);
        primaryStage.setScene(scene1);
        primaryStage.show();


    }

    private HBox createToolbar() {
        Button studentButton = new Button("Classes");
        studentButton.setOnAction(e -> showStudentSection());

        Button teacherButton = new Button("Parents");
        teacherButton.setOnAction(e -> showTeacherSection());

        Button employeeButton = new Button("Employees");
        employeeButton.setOnAction(e -> showEmployeeSection());

        Button classButton = new Button("Students");
        classButton.setOnAction(e -> showClassSection());

        Button courseButton = new Button("Courses");
        courseButton.setOnAction(e -> showCourseSection());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> System.exit(0));

        Button returnButton = new Button("Back");
        returnButton.setOnAction(event -> showMainMenu());

        // Set button styles
        studentButton.getStyleClass().add("menu-button");
        teacherButton.getStyleClass().add("menu-button");
        employeeButton.getStyleClass().add("menu-button");
        classButton.getStyleClass().add("menu-button");
        courseButton.getStyleClass().add("menu-button");
        exitButton.getStyleClass().add("menu-button");
        returnButton.getStyleClass().add("menu-button");

        languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("English", "Arabic");
        languageComboBox.setValue("English");
        translateButton = new Button("Translate");

        translate();

        // Handle translate button action
        // translateButton.setOnAction(e -> translate());

        HBox toolbar = new HBox(10, studentButton, teacherButton, employeeButton, classButton, courseButton, exitButton, returnButton);
        toolbar.setPadding(new Insets(10));
        toolbar.getStyleClass().add("toolbar");
        return toolbar;
    }

    private HBox createToolbar1() {

        Label studentButton = new Label("Select by:");

        Button teacherButton = new Button("Major");
        teacherButton.setOnAction(e -> showTeacherSection());

        Button employeeButton = new Button("ID");
        employeeButton.setOnAction(e -> showEmployeeSection());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> System.exit(0));

        Button returnButton = new Button("Main Menu");
        returnButton.setOnAction(event -> showMainMenu());

        // Set button styles
        studentButton.getStyleClass().add("menu-button");
        teacherButton.getStyleClass().add("menu-button");
        employeeButton.getStyleClass().add("menu-button");
        exitButton.getStyleClass().add("menu-button");
        returnButton.getStyleClass().add("menu-button");

        languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("English", "Arabic");
        languageComboBox.setValue("English");
        translateButton = new Button("Translate");

        translate();

        // Handle translate button action
        // translateButton.setOnAction(e -> translate());

        HBox toolbar = new HBox(10, studentButton, teacherButton, employeeButton, exitButton, returnButton);
        toolbar.setPadding(new Insets(10));
        toolbar.getStyleClass().add("toolbar");
        return toolbar;
    }

    //student section
    private void showStudentSection() {
        String [] classLabels = Sql.getTableLabels("student");
        String[][] results = Sql.getResultsTable("student");
        TableDesign t = new TableDesign(results, classLabels, "student");
        TableView<ObservableList<String>> tableView = t.createTableView();
        mainLayout.setCenter(tableView);
    }

    private void showTeacherSection() {
        String [] classLabels = Sql.getTableLabels("parent");
        String[][] results = Sql.getResultsTable("parent");
        TableDesign t = new TableDesign(results, classLabels, "parent");
        TableView<ObservableList<String>> tableView = t.createTableView();
        mainLayout.setCenter(tableView);
    }

    private void showEmployeeSection() {
        String [] classLabels = Sql.getTableLabels("employee");
        String[][] results = Sql.getResultsTable("employee");
        TableDesign t = new TableDesign(results, classLabels, "employee");
        TableView<ObservableList<String>> tableView = t.createTableView();
        mainLayout.setCenter(tableView);
    }

    private void showClassSection() {
        String [] classLabels = Sql.getTableLabels("schoolclass");
        String[][] results = Sql.getResultsTable("schoolclass");
        TableDesign t = new TableDesign(results, classLabels, "schoolclass");
        TableView<ObservableList<String>> tableView = t.createTableView();
        mainLayout.setCenter(tableView);
    }

    private void showCourseSection() {
        String [] classLabels = Sql.getTableLabels("subject");
        String[][] results = Sql.getResultsTable("subject");
        TableDesign t = new TableDesign(results, classLabels, "subject");
        TableView<ObservableList<String>> tableView = t.createTableView();
        mainLayout.setCenter(tableView);
    }

    private void initializeData() {
        // Initialize student data (dummy data for demonstration)
        studentData = FXCollections.observableArrayList();
        studentData.add(new Student("Pierre Backleh", "8/9/2002", "male", "Ramallah", "Christian", "65235", "unkown", true, 1950, "graduated"));
        studentData.add(new Student("Pierre Backleh", "8/9/2002", "male", "Ramallah", "Christian", "65235", "unkown", true, 1950, "graduated"));
        studentData.add(new Student("Pierre Backleh", "8/9/2002", "male", "Ramallah", "Christian", "65235", "unkown", true, 1950, "graduated"));
        studentData.add(new Student("Pierre Backleh", "8/9/2002", "male", "Ramallah", "Christian", "65235", "unkown", true, 1950, "graduated"));
        studentData.add(new Student("Pierre Backleh", "8/9/2002", "male", "Ramallah", "Christian", "65235", "unkown", true, 1950, "graduated"));
        studentData.add(new Student("Pierre Backleh", "8/9/2002", "male", "Ramallah", "Christian", "65235", "unkown", true, 1950, "graduated"));
        studentData.add(new Student("Pierre Backleh", "8/9/2002", "male", "Ramallah", "Christian", "65235", "unkown", true, 1950, "graduated"));

        // Initialize teacher data (dummy data for demonstration)
//        teacherData = FXCollections.observableArrayList();
//        teacherData.add(new Teacher("Lara Rafidi", "Math"));
//        teacherData.add(new Teacher("Christina Halteh", "English"));
//
//        // Initialize employee data (dummy data for demonstration)
//        employeeData = FXCollections.observableArrayList();
//        employeeData.add(new Employee("Katia", "Finance"));
//        employeeData.add(new Employee("Sawsan", "Finance"));

        // Initialize class data (dummy data for demonstration)
        classData = FXCollections.observableArrayList();

        // Initialize course data (dummy data for demonstration)
        courseData = FXCollections.observableArrayList();
        courseData.add(new Course("Mathematics"));
        courseData.add(new Course("Science"));
        courseData.add(new Course("Arabic"));
        courseData.add(new Course("English"));
        courseData.add(new Course("Physics"));
        courseData.add(new Course("Chemistry"));
        courseData.add(new Course("Biology"));
        courseData.add(new Course("Religious Studies"));
    }


    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(200);
        button.setPrefHeight(40);
        button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        button.getStyleClass().add("main-menu-button");
        button.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");
        return button;
    }


    private VBox createMainMenu() {
        Button studentButton = new Button("Manage Students");
        Button teacherButton = new Button("Manage Teachers");
        Button employeeButton = new Button("Manage Employees");
        Button classButton = new Button("Manage Classes");
        Button courseButton = new Button("Manage Courses");

        classButton.setOnAction(e -> {

            createToolbarClass();


        });

        studentButton.setPrefWidth(222);

        studentButton.setOnAction(e ->{
            createToolbar2();

        });

        teacherButton.setOnAction(e->{
            createToolbarTeacher();
        });

        employeeButton.setOnAction(e->{
            createToolbarEmployee();
        });

        courseButton.setOnAction(e->{
            createToolbarCourses();
        });

        teacherButton.setPrefWidth(222);
        employeeButton.setPrefWidth(222);
        classButton.setPrefWidth(222);
        courseButton.setPrefWidth(222);


        // Set button styles
        studentButton.getStyleClass().add("main-menu-button");
        teacherButton.getStyleClass().add("main-menu-button");
        employeeButton.getStyleClass().add("main-menu-button");
        classButton.getStyleClass().add("main-menu-button");
        courseButton.getStyleClass().add("main-menu-button");


        VBox mainMenu = new VBox(20, studentButton, teacherButton, employeeButton, classButton, courseButton);


        // Create the main menu container (VBox)
        mainMenu.setAlignment(Pos.TOP_LEFT);
        mainMenu.setPadding(new Insets(50));
        return mainMenu;
    }

    private VBox createMainMenu1() {
        Button studentButton = new Button("Add Worker");
        Button teacherButton = new Button("Delete Worker");
        Button employeeButton = new Button("Update Worker");
        Button classButton = new Button("Show all workers");

        classButton.setOnAction(e -> {

            createToolbarClass();


        });

        studentButton.setPrefWidth(222);

        studentButton.setOnAction(e ->{
            createToolbar2();

        });

        teacherButton.setOnAction(e->{
            createToolbarTeacher();
        });

        employeeButton.setOnAction(e->{
            createToolbarEmployee();
        });

        teacherButton.setPrefWidth(222);
        employeeButton.setPrefWidth(222);
        classButton.setPrefWidth(222);


        // Set button styles
        studentButton.getStyleClass().add("main-menu-button");
        teacherButton.getStyleClass().add("main-menu-button");
        employeeButton.getStyleClass().add("main-menu-button");
        classButton.getStyleClass().add("main-menu-button");


        VBox mainMenu = new VBox(20, studentButton, teacherButton, employeeButton, classButton);


        // Create the main menu container (VBox)
        mainMenu.setAlignment(Pos.TOP_LEFT);
        mainMenu.setPadding(new Insets(50));
        return mainMenu;
    }

    private BorderPane createFrame() {
        BorderPane frame = new BorderPane();

        // Create the label
        Label label = new Label("The Arab Evangelical School");
        label.setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        label.setTextFill(Color.MAROON);
        label.setStyle("-fx-background-color: #F5F5DC; -fx-padding: 10px; -fx-border-color: maroon; -fx-border-width: 8px;");

        // Set the label in the frame
        frame.setTop(label);
        frame.setMinSize(330, 200);
        BorderPane.setAlignment(label, Pos.CENTER);

        return frame;
    }

    private VBox createInfoSection() {
        VBox infoSection = new VBox();
        infoSection.setAlignment(Pos.CENTER);
        infoSection.setSpacing(3);

        // Create labels for school and principal information
        Label contact = createInfoLabel("Contact Us:", " ");
        Label schoolLabel = createInfoLabel("School's Number:", "022956567");

        Label principalLabel = createInfoLabel("Principle's Name:", "Iyad Abdallah Rafidi");
        Label phoneLabel = createInfoLabel("Phone Number:", "0599390622");
        Label emailLabel = createInfoLabel("Email Address:", "irafidi@hotmail.com");
        schoolLabel.getStyleClass().add("menu-info");
        principalLabel.getStyleClass().add("menu-info");
        phoneLabel.getStyleClass().add("menu-info");
        emailLabel.getStyleClass().add("menu-info");
        contact.setMinSize(800, 20);
        schoolLabel.setMinSize(800, 20);
        principalLabel.setMinSize(800, 20);
        phoneLabel.setMinSize(800, 20);
        emailLabel.setMinSize(800, 20);


        // Add the labels to the info section
        infoSection.getChildren().addAll(contact, schoolLabel, principalLabel, phoneLabel, emailLabel);

        return infoSection;
    }

    private void translate() {
        String selectedLanguage = languageComboBox.getValue();

        if (selectedLanguage.equals("Arabic")) {
            // Perform translation to Arabic
            titleLabel.setText("Ù†Ø¸Ø§Ù… Ø¥Ø¯Ø§Ø±Ø© Ø§Ù„Ù…Ø¯Ø±Ø³Ø©");

            translateButton.setText("ØªØ±Ø¬Ù…Ø©");
            // Translate other labels and components as needed
        } else {
            // Perform translation to English
            //titleLabel.setText("School Management System");
            translateButton.setText("Translate");
            // Translate other labels and components as needed
        }
    }

    private Label createInfoLabel(String title, String value) {
        Label label = new Label(title + " " + value);
        label.setFont(Font.font("Roboto", FontWeight.BOLD, 16));

        return label;
    }


    private void showMainMenu() {
        Stage primaryStage = new Stage();
        start(primaryStage);
    }
    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        return label;
    }

    private void showAddClassForm() {
        VBox classInfoBox = new VBox();
        classInfoBox.setSpacing(10);
        classInfoBox.setAlignment(Pos.CENTER);

        // Create labels and text fields for each class attribute
        Label idLabel = createLabel("Class ID:");
        TextField idField = createTextFieldWithPrompt("Enter class ID");
        //idField.setPrefWidth(100);
        idField.setMaxWidth(200);

        Label subLabel = createLabel("Subjects:");
        TextField subField = createTextFieldWithPrompt("Enter subjects");
        subField.setMaxWidth(200);

        Label numLabel = createLabel("Number Of Subjects:");
        TextField numField = createTextFieldWithPrompt("Enter number of subjects");
        numField.setMaxWidth(200);

        Label sectionLabel = createLabel("Section:");
        TextField sectionField = createTextFieldWithPrompt("Enter section");
        sectionField.setMaxWidth(200);

        Label locationLabel = createLabel("Location:");
        TextField locationField = createTextFieldWithPrompt("Enter location");
        locationField.setMaxWidth(200);

        // Add the labels and text fields to the class information box
        classInfoBox.getChildren().addAll(
                idLabel, idField,
                subLabel, subField,
                numLabel, numField,
                sectionLabel, sectionField,
                locationLabel, locationField
        );

        // Create a button for submitting the class information
        Button submitButton = createButton("Submit");
        submitButton.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
        submitButton.setOnAction(e -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Confirm Submission");
            confirmation.setContentText("Are you sure you want to submit the class information?");

            // Get the result of the confirmation dialog
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                String id = idField.getText();
                String subjects = subField.getText();
                String numOfSubjects = numField.getText();
                String section = sectionField.getText();
                String location = locationField.getText();

                // Perform validation on the input fields
                if (id.isEmpty() || subjects.isEmpty() || numOfSubjects.isEmpty() || section.isEmpty() || location.isEmpty()) {
                    // Display an error message if any field is empty
                    showAlert(Alert.AlertType.ERROR, "Error", "Missing Information", "Please fill in all fields.");
                } else {
                    // Create a new SchoolClass object and set the attributes
                    SchoolClass newClass = new SchoolClass();
                    newClass.setClassId(id);
                    newClass.setSubjects(subjects);
                    newClass.setNumberOfSubjects(numOfSubjects);
                    newClass.setSection(section);
                    newClass.setLocation(location);

                    // Insert the class data into the database
                    newClass.insertSql();

                    // Display a success message
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Class Added", "The class has been successfully added.");

                    // Close the Add Class form
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                }
            }

        });

        // Add the submit button to the class information box
        classInfoBox.getChildren().add(submitButton);

        // Create a new scene for the class information form
        Scene classFormScene = new Scene(classInfoBox, 600, 400);

        // Create a new stage for the class information form
        Stage classFormStage = new Stage();
        classFormStage.setTitle("Add Class");
        classFormStage.setScene(classFormScene);
        classFormStage.show();
    }

    private void showRemoveClassForm() {
        String [] classLabels = Sql.getTableLabels("schoolclass");
        String[][] results = Sql.getResultsTable("schoolclass");
        TableDesign t = new TableDesign(results, classLabels, "schoolclass");
        TableView<ObservableList<String>> tableView = t.createTableView();
        mainLayout.setCenter(tableView);

        VBox classInfoBox = new VBox();
        classInfoBox.setSpacing(10);
        classInfoBox.setAlignment(Pos.CENTER);

        // Create labels and text fields for each class attribute
        Label idLabel = createLabel("Class ID:");
        TextField idField = createTextFieldWithPrompt("Enter class ID");
        //idField.setPrefWidth(100);
        idField.setMaxWidth(200);


        // Add the labels and text fields to the class information box
        classInfoBox.getChildren().addAll(
                idLabel, idField
        );

        // Create a button for submitting the class information
        Button submitButton = createButton("Delete");
        submitButton.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
        submitButton.setOnAction(e -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Confirm Submission");
            confirmation.setContentText("Are you sure you want to delete the class ?");

            // Get the result of the confirmation dialog
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                String id = idField.getText();


                // Perform validation on the input fields
                if (id.isEmpty() ) {
                    // Display an error message if any field is empty
                    showAlert(Alert.AlertType.ERROR, "Error", "Missing Information", "Please fill in all fields.");
                } else {
                    // Create a new SchoolClass object and set the attributes
                    Sql.delete("schoolclass","id",idField.getText());

                    // Insert the class data into the database


                    // Display a success message
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Class deleted", "The class has been successfully deleted.");

                    // Close the Add Class form
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                }
            }

        });

        // Add the submit button to the class information box
        classInfoBox.getChildren().add(submitButton);

        // Create a new scene for the class information form
        Scene classFormScene = new Scene(classInfoBox, 600, 400);

        // Create a new stage for the class information form
        // Create a new stage for the class information form
        Stage classFormStage = new Stage();
        classFormStage.setTitle("Add Class");
        classFormStage.setScene(classFormScene);
        classFormStage.show();
    }
    private void showUpdateClassForm() {
        String [] classLabels = Sql.getTableLabels("schoolclass");
        String[][] results = Sql.getResultsTable("schoolclass");
        TableDesign2 t = new TableDesign2(results, classLabels, "schoolclass");
        TableView<ObservableList<String>> tableView = t.createTableView();
        mainLayout.setCenter(tableView);

        VBox classInfoBox = new VBox();
        classInfoBox.setSpacing(10);
        classInfoBox.setAlignment(Pos.CENTER);

        // Create labels and text fields for each class attribute
        Label idLabel = createLabel(" press the field  to update it \n  \t \t OR ");
        //idField.setPrefWidth(100);


        // Add the labels and text fields to the class information box
        classInfoBox.getChildren().addAll(
                idLabel
        );
        Button submitButton = createButton("Search Class");
        submitButton.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
        submitButton.setOnAction(e -> {
            showSearchClassForm();

        });
        classInfoBox.getChildren().add(submitButton);

        Scene classFormScene = new Scene(classInfoBox, 600, 400);

        // Create a new stage for the class information form
        Stage classFormStage = new Stage();
        classFormStage.setTitle("update Class");
        classFormStage.setScene(classFormScene);
        classFormStage.show();


            }
            private void  showSearchClassForm(){

                VBox classInfoBox = new VBox();
                classInfoBox.setSpacing(10);
                classInfoBox.setAlignment(Pos.CENTER);

                // Create labels and text fields for each class attribute

                String [] classLabels = Sql.getTableLabels("schoolclass");
                ObservableList<String> options = FXCollections.observableArrayList(classLabels);


                final ComboBox comboBox = new ComboBox(options);
                // Add the labels and text fields to the class information box
                Label idLabel = createLabel("enter value: ");
                TextField idField = createTextFieldWithPrompt("Enter keyword");
                idField.setMaxWidth(200);
                String[][] results = Sql.getResultsTable("schoolclass");
                TableDesign t = new TableDesign(results, classLabels, "schoolclass");
                TableView<ObservableList<String>> tableView = t.createTableView();
                mainLayout.setCenter(tableView);

                classInfoBox.getChildren().addAll(
                        comboBox ,idLabel,idField
                );
                Button submitButton = createButton("Search");
                submitButton.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
                submitButton.setOnAction(e -> {
                    String[][] searchResults = Sql.complexSqlQuery("schoolclass", comboBox.getValue().toString(), idField.getText().toString());
                   String []labels = Sql.getComplexLabels("schoolclass",comboBox.getValue().toString(), idField.getText());
                    if (searchResults != null) {
                        TablePopulate tablePopulate = null;
                        tablePopulate = new TablePopulate(searchResults, labels, "schoolclass");
                        TableView tableViewResult = tablePopulate.createTableView();
                        mainLayout.setCenter(tableViewResult);
                    }
                });
                classInfoBox.getChildren().add(submitButton);

                Scene classFormScene = new Scene(classInfoBox, 600, 400);

                // Create a new stage for the class information form
                Stage classFormStage = new Stage();
                classFormStage.setTitle("Search Class");
                classFormStage.setScene(classFormScene);
                classFormStage.show();
            }




    private void showAddTeacherForm() {
        VBox classInfoBox = new VBox();
        classInfoBox.setSpacing(10);
        classInfoBox.setAlignment(Pos.CENTER);

        // Create labels and text fields for each class attribute
        Label idLabel = createLabel("Teacher ID:");
        TextField idField = createTextFieldWithPrompt("Enter Teacher ID");
        //idField.setPrefWidth(100);
        idField.setMaxWidth(200);

        Label subLabel = createLabel("Subjects:");
        TextField subField = createTextFieldWithPrompt("Enter subjects");
        subField.setMaxWidth(200);

        Label numLabel = createLabel("Number Of Subjects:");
        TextField numField = createTextFieldWithPrompt("Enter number of subjects");
        numField.setMaxWidth(200);

        Label sectionLabel = createLabel("Section:");
        TextField sectionField = createTextFieldWithPrompt("Enter section");
        sectionField.setMaxWidth(200);

        Label locationLabel = createLabel("Location:");
        TextField locationField = createTextFieldWithPrompt("Enter location");
        locationField.setMaxWidth(200);

        // Add the labels and text fields to the class information box
        classInfoBox.getChildren().addAll(
                idLabel, idField,
                subLabel, subField,
                numLabel, numField,
                sectionLabel, sectionField,
                locationLabel, locationField
        );

        // Create a button for submitting the class information
        Button submitButton = createButton("Submit");
        submitButton.setStyle("-fx-background-color: #800000; -fx-text-fill: white;");
        submitButton.setOnAction(e -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Confirm Submission");
            confirmation.setContentText("Are you sure you want to submit the class information?");

            // Get the result of the confirmation dialog
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                String id = idField.getText();
                String subjects = subField.getText();
                String numOfSubjects = numField.getText();
                String section = sectionField.getText();
                String location = locationField.getText();

                // Perform validation on the input fields
                if (id.isEmpty() || subjects.isEmpty() || numOfSubjects.isEmpty() || section.isEmpty() || location.isEmpty()) {
                    // Display an error message if any field is empty
                    showAlert(Alert.AlertType.ERROR, "Error", "Missing Information", "Please fill in all fields.");
                } else {
                    // Create a new SchoolClass object and set the attributes
                    SchoolClass newClass = new SchoolClass();
                    newClass.setClassId(id);
                    newClass.setSubjects(subjects);
                    newClass.setNumberOfSubjects(numOfSubjects);
                    newClass.setSection(section);
                    newClass.setLocation(location);

                    // Insert the class data into the database
                    newClass.insertSql();

                    // Display a success message
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Class Added", "The class has been successfully added.");

                    // Close the Add Class form
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                }
            }

        });

        // Add the submit button to the class information box
        classInfoBox.getChildren().add(submitButton);

        // Create a new scene for the class information form
        Scene classFormScene = new Scene(classInfoBox, 600, 400);

        // Create a new stage for the class information form
        Stage classFormStage = new Stage();
        classFormStage.setTitle("Add Class");
        classFormStage.setScene(classFormScene);
        classFormStage.show();
    }


    private void showAddStudentForm() {
        // TODO Auto-generated method stub
        VBox StudentInfoBox = new VBox();
        StudentInfoBox.setSpacing(10);
        StudentInfoBox.setAlignment(Pos.CENTER);

        Button b = new Button("Back");
        Image menuImage = new Image(getClass().getResourceAsStream("93634.png"));
        ImageView backLogo = new ImageView(menuImage);
        backLogo.setFitWidth(16);
        backLogo.setFitHeight(16);
        b.setGraphic(backLogo);
        b.setOnAction(e->{
            primaryStage.setScene(scene3);
            primaryStage.show();
        });

        b.setLayoutX(10);
        b.setLayoutY(10);

        // Create labels and text fields for each student attribute
        Label nameLabel = createLabel("Student Name:");
        TextField idField = createTextFieldWithPrompt("Enter student name");
        idField.setMaxWidth(200);

        Label subLabel = createLabel("Date of Birth:");
        TextField subField = createTextFieldWithPrompt("Enter date of birth");
        subField.setMaxWidth(200);

        Label numLabel = createLabel("Gender:");
        TextField numField = createTextFieldWithPrompt("Enter gender");
        numField.setMaxWidth(200);

        Label sectionLabel = createLabel("Address:");
        TextField sectionField = createTextFieldWithPrompt("Enter Address");
        sectionField.setMaxWidth(200);

        Label locationLabel = createLabel("Religion:");
        TextField locationField = createTextFieldWithPrompt("Enter Religion");
        locationField.setMaxWidth(200);

        Label locationLabel1 = createLabel("Student Id:");
        TextField locationField1 = createTextFieldWithPrompt("Enter student ID");
        locationField1.setMaxWidth(200);

        Label locationLabel2 = createLabel("Nationality:");
        TextField locationField2 = createTextFieldWithPrompt("Enter Nationality");
        locationField2.setMaxWidth(200);

        CheckBox insuranceCheckbox = new CheckBox("Has Insurance?");
        insuranceCheckbox.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label locationLabel4 = createLabel("Payments:");
        TextField locationField4 = createTextFieldWithPrompt("Enter Payments");
        locationField4.setMaxWidth(200);

        Label locationLabel5 = createLabel("Status:");
        TextField locationField5 = createTextFieldWithPrompt("Enter Status");
        locationField5.setMaxWidth(200);



        // Add the labels and text fields to the student information box
        StudentInfoBox.getChildren().addAll(
                nameLabel, idField,
                subLabel, subField,
                numLabel, numField,
                sectionLabel, sectionField,
                locationLabel, locationField,
                locationLabel1, locationField1,
                locationLabel2, locationField2,
                insuranceCheckbox,
                locationLabel4, locationField4,
                locationLabel5, locationField5
        );

        // Create a button for submitting the student information
        Button submitButton = createButton("Submit");
        submitButton.setOnAction(e -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Confirm Submission");
            confirmation.setContentText("Are you sure you want to submit the student information?");

            // Get the result of the confirmation dialog
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                // Perform validation on the input fields
                if (idField.getText().isEmpty() || subField.getText().isEmpty() || numField.getText().isEmpty() || sectionField.getText().isEmpty() || locationField.getText().isEmpty() || locationField1.getText().isEmpty() || locationField2.getText().isEmpty() ) {
                    // Display an error message if any field is empty
                    showAlert(Alert.AlertType.ERROR, "Error", "Missing Information", "Please fill in all fields.");
                } else {
                    // Create a new SchoolClass object and set the attributes
                    Student s= new Student();
                    s.setName(idField.getText());
                    s.setDateOfBirth((subField.getText()));
                    s.setGender((numField.getText()));
                    s.setAddress(sectionField.getText());
                    s.setReligion((locationField.getText()));
                    s.setId((locationField1.getText()));
                    s.setNationality((locationField2.getText()));
                    s.setHasInsurance(insuranceCheckbox.isSelected());

                    // Insert the class data into the database
                    //newClass.insertSql();

                    // Display a success message
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Class Added", "The class has been successfully added.");

                    // Close the Add Class form
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                }
            }


            //s.insertSql();

        });

        // Add the submit button to the student information box
        StudentInfoBox.getChildren().addAll(submitButton, b);

        // Create a new scene for the student information form
        Scene ClassFormScene = new Scene(StudentInfoBox, 600, 700);

        // Create a new stage for the student information form
        Stage ClassFormStage = new Stage();
        ClassFormStage.setTitle("Add Student");
        ClassFormStage.setScene(ClassFormScene);
        ClassFormStage.show();

    }

    private void showAddEmployeeForm() {
        // TODO Auto-generated method stub
        VBox StudentInfoBox = new VBox();
        StudentInfoBox.setSpacing(10);
        StudentInfoBox.setAlignment(Pos.CENTER);

        Button b = new Button("Back");
        Image menuImage = new Image(getClass().getResourceAsStream("93634.png"));
        ImageView backLogo = new ImageView(menuImage);
        backLogo.setFitWidth(16);
        backLogo.setFitHeight(16);
        b.setGraphic(backLogo);
        b.setOnAction(e->{
            primaryStage.setScene(scene3);
            primaryStage.show();
        });

        b.setLayoutX(10);
        b.setLayoutY(10);

        // Create labels and text fields for each student attribute
        Label nameLabel = createLabel("Employee ID:");
        TextField idField = createTextFieldWithPrompt("Enter student name");
        idField.setMaxWidth(200);

        Label subLabel = createLabel("Date of Birth:");
        TextField subField = createTextFieldWithPrompt("Enter date of birth");
        subField.setMaxWidth(200);

        Label numLabel = createLabel("Gender:");
        TextField numField = createTextFieldWithPrompt("Enter gender");
        numField.setMaxWidth(200);

        Label sectionLabel = createLabel("Address:");
        TextField sectionField = createTextFieldWithPrompt("Enter Address");
        sectionField.setMaxWidth(200);

        Label locationLabel = createLabel("Religion:");
        TextField locationField = createTextFieldWithPrompt("Enter Religion");
        locationField.setMaxWidth(200);

        Label locationLabel1 = createLabel("Student Id:");
        TextField locationField1 = createTextFieldWithPrompt("Enter student ID");
        locationField1.setMaxWidth(200);

        Label locationLabel2 = createLabel("Nationality:");
        TextField locationField2 = createTextFieldWithPrompt("Enter Nationality");
        locationField2.setMaxWidth(200);

        CheckBox insuranceCheckbox = new CheckBox("Has Insurance?");
        insuranceCheckbox.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        Label locationLabel4 = createLabel("Payments:");
        TextField locationField4 = createTextFieldWithPrompt("Enter Payments");
        locationField4.setMaxWidth(200);

        Label locationLabel5 = createLabel("Status:");
        TextField locationField5 = createTextFieldWithPrompt("Enter Status");
        locationField5.setMaxWidth(200);



        // Add the labels and text fields to the student information box
        StudentInfoBox.getChildren().addAll(
                nameLabel, idField,
                subLabel, subField,
                numLabel, numField,
                sectionLabel, sectionField,
                locationLabel, locationField,
                locationLabel1, locationField1,
                locationLabel2, locationField2,
                insuranceCheckbox,
                locationLabel4, locationField4,
                locationLabel5, locationField5
        );

        // Create a button for submitting the student information
        Button submitButton = createButton("Submit");
        submitButton.setOnAction(e -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Confirm Submission");
            confirmation.setContentText("Are you sure you want to submit the student information?");

            // Get the result of the confirmation dialog
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                // Perform validation on the input fields
                if (idField.getText().isEmpty() || subField.getText().isEmpty() || numField.getText().isEmpty() || sectionField.getText().isEmpty() || locationField.getText().isEmpty() || locationField1.getText().isEmpty() || locationField2.getText().isEmpty() ) {
                    // Display an error message if any field is empty
                    showAlert(Alert.AlertType.ERROR, "Error", "Missing Information", "Please fill in all fields.");
                } else {
                    // Create a new SchoolClass object and set the attributes
                    Student s= new Student();
                    s.setName(idField.getText());
                    s.setDateOfBirth((subField.getText()));
                    s.setGender((numField.getText()));
                    s.setAddress(sectionField.getText());
                    s.setReligion((locationField.getText()));
                    s.setId((locationField1.getText()));
                    s.setNationality((locationField2.getText()));
                    s.setHasInsurance(insuranceCheckbox.isSelected());

                    // Insert the class data into the database
                    //newClass.insertSql();

                    // Display a success message
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Class Added", "The class has been successfully added.");

                    // Close the Add Class form
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                }
            }


            //s.insertSql();

        });

        // Add the submit button to the student information box
        StudentInfoBox.getChildren().addAll(submitButton, b);

        // Create a new scene for the student information form
        Scene ClassFormScene = new Scene(StudentInfoBox, 600, 700);

        // Create a new stage for the student information form
        Stage ClassFormStage = new Stage();
        ClassFormStage.setTitle("Add Student");
        ClassFormStage.setScene(ClassFormScene);
        ClassFormStage.show();

    }

    private void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Stage stage = null;
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.initOwner(stage); // Replace 'stage' with your primary stage object
        alert.showAndWait();
    }

    private TextField createTextFieldWithPrompt(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        return textField;
    }

    public static void main(String[] args) {

        Sql.connect(new KeyStore.PasswordProtection("1201123".toCharArray()));
        launch(args);
    }

    private void createToolbar2() {
        // Create toolbar
        ToolBar toolbar = new ToolBar();

        // Create buttons
        Button addStudentButton = new Button("Add Student");
        addStudentButton.getStyleClass().add("menu-button");
        Button deleteStudentButton = new Button("Delete Student");
        deleteStudentButton.getStyleClass().add("menu-button");
        Button updateStudentButton = new Button("Update Student");
        updateStudentButton.getStyleClass().add("menu-button");
        Button searchStudentButton = new Button("Search Student");
        searchStudentButton.getStyleClass().add("menu-button");

        // Add button click event handlers
        addStudentButton.setOnAction(e -> {
            // Handle add student button click
            showAddStudentForm();
        });

        deleteStudentButton.setOnAction(e -> {
            showDeleteStudentForm();
        });

        updateStudentButton.setOnAction(e -> {
            //samuel here
        });

        searchStudentButton.setOnAction(e -> {

        });
        Button closeButton = new Button("close");
        closeButton.getStyleClass().add("menu-button");
        closeButton.setOnAction(e -> {
            // Handle close button click
            toolbar.setVisible(false);
            HBox toolbar3 = createToolbar();
            mainLayout.setTop(toolbar3);
        });

        // Add buttons to toolbar
        toolbar.getItems().addAll(addStudentButton, deleteStudentButton, updateStudentButton, searchStudentButton, closeButton);
        toolbar.getStyleClass().add("toolbar");
        // Add toolbar to the main layout
        // (Assuming you have a main layout such as BorderPane or VBox)

        mainLayout.setTop(toolbar);
    }

    private void createToolbarClass() {
        // Create toolbar
        ToolBar toolbar = new ToolBar();


        // Create buttons
        Button addStudentButton = new Button("Add new class");
        addStudentButton.getStyleClass().add("menu-button");
        Button deleteStudentButton = new Button("Delete class");
        deleteStudentButton.getStyleClass().add("menu-button");
        Button updateStudentButton = new Button("Update class");
        updateStudentButton.getStyleClass().add("menu-button");
        Button searchStudentButton = new Button("Search class");
        searchStudentButton.getStyleClass().add("menu-button");

        // Add button click event handlers
        addStudentButton.setOnAction(e -> {
            // Handle add student button click
            showAddClassForm();
        });

        deleteStudentButton.setOnAction(e -> {
            showRemoveClassForm();
        });

        updateStudentButton.setOnAction(e -> {
            showUpdateClassForm();
        });

        searchStudentButton.setOnAction(e -> {
            showSearchClassForm();
        });
        Button closeButton = new Button("close");
        closeButton.getStyleClass().add("menu-button");
        closeButton.setOnAction(e -> {
            // Handle close button click
            toolbar.setVisible(false);
            HBox toolbar1 = createToolbar();
            mainLayout.setTop(toolbar1);

        });

        // Add buttons to toolbar
        toolbar.getItems().addAll(addStudentButton, deleteStudentButton, updateStudentButton, searchStudentButton, closeButton);
        toolbar.getStyleClass().add("toolbar");
        // Add toolbar to the main layout
        // (Assuming you have a main layout such as BorderPane or VBox)

        mainLayout.setTop(toolbar);
    }

    private void createToolbarEmployee() {
        // Create toolbar
        ToolBar toolbar = new ToolBar();

        // Create buttons
        Button addStudentButton = new Button("Add new Employee");
        addStudentButton.getStyleClass().add("menu-button");
        Button deleteStudentButton = new Button("Delete Employee");
        deleteStudentButton.getStyleClass().add("menu-button");
        Button updateStudentButton = new Button("Update Employee");
        updateStudentButton.getStyleClass().add("menu-button");
        Button searchStudentButton = new Button("Search Employee");
        searchStudentButton.getStyleClass().add("menu-button");

        // Add button click event handlers
        addStudentButton.setOnAction(e -> {
            // Handle add student button click
            showAddClassForm();
        });

        deleteStudentButton.setOnAction(e -> {
            showRemoveClassForm();
        });

        updateStudentButton.setOnAction(e -> {

        });

        searchStudentButton.setOnAction(e -> {

        });
        Button closeButton = new Button("close");
        closeButton.getStyleClass().add("menu-button");
        closeButton.setOnAction(e -> {
            // Handle close button click
            toolbar.setVisible(false);
            HBox toolbar1 = createToolbar();
            mainLayout.setTop(toolbar1);

        });

        // Add buttons to toolbar
        toolbar.getItems().addAll(addStudentButton, deleteStudentButton, updateStudentButton, searchStudentButton, closeButton);
        toolbar.getStyleClass().add("toolbar");
        // Add toolbar to the main layout
        // (Assuming you have a main layout such as BorderPane or VBox)

        mainLayout.setTop(toolbar);
    }

    private void createToolbarCourses() {
        // Create toolbar
        ToolBar toolbar = new ToolBar();

        // Create buttons
        Button addStudentButton = new Button("Add new Course");
        addStudentButton.getStyleClass().add("menu-button");
        Button deleteStudentButton = new Button("Delete Course");
        deleteStudentButton.getStyleClass().add("menu-button");
        Button updateStudentButton = new Button("Update Course");
        updateStudentButton.getStyleClass().add("menu-button");
        Button searchStudentButton = new Button("Search Course");
        searchStudentButton.getStyleClass().add("menu-button");

        // Add button click event handlers
        addStudentButton.setOnAction(e -> {
            // Handle add student button click
            showAddClassForm();
        });

        deleteStudentButton.setOnAction(e -> {
            showRemoveClassForm();
        });

        updateStudentButton.setOnAction(e -> {

        });

        searchStudentButton.setOnAction(e -> {

        });
        Button closeButton = new Button("close");
        closeButton.getStyleClass().add("menu-button");
        closeButton.setOnAction(e -> {
            // Handle close button click
            toolbar.setVisible(false);
            HBox toolbar1 = createToolbar();
            mainLayout.setTop(toolbar1);

        });

        // Add buttons to toolbar
        toolbar.getItems().addAll(addStudentButton, deleteStudentButton, updateStudentButton, searchStudentButton, closeButton);
        toolbar.getStyleClass().add("toolbar");
        // Add toolbar to the main layout
        // (Assuming you have a main layout such as BorderPane or VBox)

        mainLayout.setTop(toolbar);
    }

    private void
    createToolbarTeacher() {
        // Create toolbar
        ToolBar toolbar = new ToolBar();

        // Create buttons
        Button addStudentButton = new Button("Add Teacher");
        addStudentButton.getStyleClass().add("menu-button");
        Button deleteStudentButton = new Button("Delete Teacher");
        deleteStudentButton.getStyleClass().add("menu-button");
        Button updateStudentButton = new Button("Update Teacher");
        updateStudentButton.getStyleClass().add("menu-button");
        Button searchStudentButton = new Button("Search Teacher");
        searchStudentButton.getStyleClass().add("menu-button");

        // Add button click event handlers
        addStudentButton.setOnAction(e -> {
            // Handle add student button click
            showAddTeacherForm();
        });

        deleteStudentButton.setOnAction(e -> {
            showRemoveClassForm();
        });

        updateStudentButton.setOnAction(e -> {

        });

        searchStudentButton.setOnAction(e -> {

        });
        Button closeButton = new Button("close");
        closeButton.getStyleClass().add("menu-button");
        closeButton.setOnAction(e -> {
            // Handle close button click
            toolbar.setVisible(false);
            HBox toolbar1 = createToolbar();
            mainLayout.setTop(toolbar1);

        });

        // Add buttons to toolbar
        toolbar.getItems().addAll(addStudentButton, deleteStudentButton, updateStudentButton, searchStudentButton, closeButton);
        toolbar.getStyleClass().add("toolbar");
        // Add toolbar to the main layout
        // (Assuming you have a main layout such as BorderPane or VBox)

        mainLayout.setTop(toolbar);
    }


    private void Certificate() {
        StackPane root = new StackPane();
        root.setPadding(new Insets(20));

        // Create a Button for presenting the certificate
        Button presentButton = new Button("Present Certificate");
        presentButton.getStyleClass().add("certificate-button");
        presentButton.setOnAction(e->{
            presentCertificate();
        });

        // Add the Button to the StackPane
        root.getChildren().add(presentButton);

        // Create a Scene and add the StackPane to it
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("certificate-style.css").toExternalForm());

        // Set the Scene to the Stage and show the Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Certificate Presentation");
        primaryStage.show();
    }

    private void showDeleteStudentForm() {
        VBox StudentInfoBox = new VBox();
        StudentInfoBox.setSpacing(10);
        StudentInfoBox.setAlignment(Pos.CENTER);

        Button b = new Button("Back");
        Image menuImage = new Image(getClass().getResourceAsStream("93634.png"));
        ImageView backLogo = new ImageView(menuImage);
        backLogo.setFitWidth(16);
        backLogo.setFitHeight(16);
        b.setGraphic(backLogo);
        b.setOnAction(e->{
            primaryStage.setScene(scene3);
            primaryStage.show();
        });

        b.setLayoutX(10);
        b.setLayoutY(10);

        // Create labels and text fields for each student attribute
        Label nameLabel = createLabel("Student ID:");
        TextField idField = createTextFieldWithPrompt("Enter student name");
        idField.setMaxWidth(200);


        // Add the labels and text fields to the student information box
        StudentInfoBox.getChildren().addAll(
                nameLabel, idField        );

        // Create a button for submitting the student information
        Button submitButton = createButton("Submit");
        submitButton.setOnAction(e -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation");
            confirmation.setHeaderText("Confirm Submission");
            confirmation.setContentText("Are you sure you want to submit the student information?");

            // Get the result of the confirmation dialog
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                // Perform validation on the input fields
                if (idField.getText().isEmpty() ) {
                    // Display an error message if any field is empty
                    showAlert(Alert.AlertType.ERROR, "Error", "Missing Information", "Please fill in all fields.");
                } else {
                    //samuel here


                    // Display a success message
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Class Added", "The class has been successfully added.");

                    // Close the Add Class form
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                }
            }


            //s.insertSql();

        });

        // Add the submit button to the student information box
        StudentInfoBox.getChildren().addAll(submitButton, b);

        // Create a new scene for the student information form
        Scene ClassFormScene = new Scene(StudentInfoBox, 600, 700);

        // Create a new stage for the student information form
        Stage ClassFormStage = new Stage();
        ClassFormStage.setTitle("Add Student");
        ClassFormStage.setScene(ClassFormScene);
        ClassFormStage.show();
    }


    private void presentCertificate() {
        // Create a new Stage for the certificate dialog
        Stage certificateStage = new Stage();
        certificateStage.initModality(Modality.APPLICATION_MODAL);
        certificateStage.setTitle("Certificate");

        // Create a VBox to hold the certificate content
        VBox certificateBox = new VBox(10);
        certificateBox.setPadding(new Insets(20));

        // Create a Label for the certificate title
        Label titleLabel = new Label("Certificate:");
        titleLabel.getStyleClass().add("certificate-title");

        // Create a TableView for the course grades
        TableView<CourseGrade> tableView = new TableView<>();
        tableView.getStyleClass().add("certificate-table");

        // Create TableColumns for course name and grade
        TableColumn<CourseGrade, String> courseColumn = new TableColumn<>("Course");
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        TableColumn<CourseGrade, Double> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.getColumns().addAll(courseColumn, gradeColumn);

        // Create an ObservableList of CourseGrade objects
        ObservableList<CourseGrade> courseGrades = FXCollections.observableArrayList();
        for (String course : COURSES) {
            courseGrades.add(new CourseGrade(course, COURSE_GRADES.get(course)));
        }

        // Add the course grades to the TableView
        tableView.setItems(courseGrades);

        // Calculate the final grade
        double totalGrades = COURSE_GRADES.values().stream().mapToDouble(Double::doubleValue).sum();
        double finalGrade = totalGrades / COURSE_GRADES.size();

        // Create a Label for the final grade
        Label finalGradeLabel = new Label("Final Grade: " + finalGrade);
        finalGradeLabel.getStyleClass().add("certificate-label");

        // Add the Labels and TableView to the certificate VBox
        certificateBox.getChildren().addAll(titleLabel, tableView, finalGradeLabel);

        // Create a Scene for the certificate dialog and add the VBox to it
        Scene certificateScene = new Scene(certificateBox, 600, 400);
        certificateScene.getStylesheets().add(getClass().getResource("certificate-style.css").toExternalForm());

        // Set the Scene to the Stage and show the Stage
        certificateStage.setScene(certificateScene);
        certificateStage.show();
    }

}


