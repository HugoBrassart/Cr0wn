package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class DashboardController implements Initializable {


    private Connection connectDB;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet queryResult;

    private Image image;

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private DatePicker addStudents_birth;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private TableView<studentData> addStudents_tableView;

    @FXML
    private TableColumn<studentData, String> addStudents_col_birth;

    @FXML
    private TableColumn<studentData, String> addStudents_col_course;

    @FXML
    private TableColumn<studentData, String> addStudents_col_firstName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_gender;

    @FXML
    private TableColumn<studentData, String> addStudents_col_lastName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_status;

    @FXML
    private TableColumn<studentData, String> addStudents_col_studentNum;

    @FXML
    private TableColumn<studentData, String> addStudents_col_year;

    @FXML
    private ComboBox<?> addStudents_course;

    @FXML
    private Button addStudents_deleteBtn;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private ComboBox<?> addStudents_gender;

    @FXML
    private ImageView addStudents_imageView;

    @FXML
    private Button addStudents_insertBtn;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private TextField addStudents_search;

    @FXML
    private ComboBox<?> addStudents_status;

    @FXML
    private TextField addStudents_studentNum;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private ComboBox<?> addStudents_year;

    @FXML
    private Button availableCourse_addBtn;

    @FXML
    private Button availableCourse_btn;

    @FXML
    private Button availableCourse_clearBtn;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_course;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_degree;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_description;

    @FXML
    private TextField availableCourse_course;

    @FXML
    private TextField availableCourse_degree;

    @FXML
    private Button availableCourse_deleteBtn;

    @FXML
    private TextField availableCourse_description;

    @FXML
    private AnchorPane availableCourse_form;

    @FXML
    private TableView<courseData> availableCourse_tableView;

    @FXML
    private Button availableCourse_updateBtn;

    @FXML
    private Button close;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private Label home_totalFemale;

    @FXML
    private BarChart<?, ?> home_totalFemaleChart;

    @FXML
    private Label home_totalMale;

    @FXML
    private BarChart<?, ?> home_totalMaleChart;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TableColumn<?, ?> studentGrade_col_course;

    @FXML
    private TableColumn<?, ?> studentGrade_col_final;

    @FXML
    private TableColumn<?, ?> studentGrade_col_firstSem;

    @FXML
    private TableColumn<?, ?> studentGrade_col_secondSem;

    @FXML
    private TableColumn<?, ?> studentGrade_col_studentNum;

    @FXML
    private TableColumn<?, ?> studentGrade_col_year;

    @FXML
    private Label studentGrade_course;

    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private AnchorPane studentGrade_form;

    @FXML
    private TextField studentGrade_search;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private TextField studentGrade_studentNum;

    @FXML
    private TableView<?> studentGrade_tableView;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private Label studentGrade_year;

    @FXML
    private Label username;

    public ObservableList<studentData> addStudentsListData() {

        ObservableList<studentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student";

        DatabaseConnection connectNow = new DatabaseConnection();
        connectDB =connectNow.getConnection();

        try {
            studentData studentD;

            preparedStatement = connectDB.prepareStatement(sql);
            queryResult = preparedStatement.executeQuery();

            while (queryResult.next()) {
                studentD = new studentData(queryResult.getInt("studentNum"),
                        queryResult.getString("year"),
                        queryResult.getString("course"),
                        queryResult.getString("firstName"),
                        queryResult.getString("lastName"),
                        queryResult.getString("gender"),
                        queryResult.getDate("birth"),
                        queryResult.getString("status"),
                        queryResult.getString("image"));

                listStudents.add(studentD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }
    private ObservableList<studentData> addStudentsListD;

    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        addStudents_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        addStudents_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudents_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudents_col_birth.setCellValueFactory(new PropertyValueFactory<>("birth"));
        addStudents_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addStudents_tableView.setItems(addStudentsListD);

    }

    public void addStudentsSelect() {

        studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addStudents_studentNum.setText(String.valueOf(studentD.getStudentNum()));
        addStudents_firstName.setText(studentD.getFirstName());
        addStudents_lastName.setText(studentD.getLastName());
        addStudents_birth.setValue(LocalDate.parse(String.valueOf(studentD.getBirth())));

        String uri = "file:" + studentD.getImage();

        image = new Image(uri, 124, 144, false, true);
        addStudents_imageView.setImage(image);



    }
    private String[] yearList = {"Première année", "Seconde année", "Licence"};

    public void addStudentsYearList() {

        List<String> yearL = new ArrayList<>();

        for (String data : yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        addStudents_year.setItems(ObList);

    }

    private String[] genderList = {"Masculin", "Féminin"};

    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudents_gender.setItems(ObList);
    }

    private String[] statusList = {"Accepté", "Refusé", "En cours"};

    public void addStudentsStatusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : statusList) {
            statusL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(statusL);
        addStudents_status.setItems(ObList);
    }

    public void availableCourseAdd() {

        String insertData = "INSERT INTO course (course,description,degree) VALUES(?,?,?)";

        DatabaseConnection connectNow = new DatabaseConnection();
        connectDB = connectNow.getConnection();

        try {
            Alert alert;

            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_description.getText().isEmpty()
                    || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous devez remplir tous les champs vides");
                alert.showAndWait();
            } else {
                String checkData = "SELECT course FROM course WHERE course = '"
                        + availableCourse_course.getText() + "'";

                statement = connectDB.createStatement();
                queryResult = statement.executeQuery(checkData);

                if (queryResult.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Le cours : " + availableCourse_course.getText() + " existe déjà");
                    alert.showAndWait();
                } else {
                    preparedStatement = connectDB.prepareStatement(insertData);
                    preparedStatement.setString(1, availableCourse_course.getText());
                    preparedStatement.setString(2, availableCourse_description.getText());
                    preparedStatement.setString(3, availableCourse_degree.getText());

                    preparedStatement.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Le cours a été ajouté");
                    alert.showAndWait();

                    availableCourseShowListData();

                    availableCourseClear();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void availableCourseUpdate() {

        String updateData = "UPDATE course SET description = '"
                + availableCourse_description.getText() + "', degree = '"
                + availableCourse_degree.getText() + "' WHERE course = '"
                + availableCourse_course.getText() + "'";

        DatabaseConnection connectNow = new DatabaseConnection();
        connectDB = connectNow.getConnection();

        try {
            Alert alert;

            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_description.getText().isEmpty()
                    || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous devez remplir tous les champs vides");
                alert.showAndWait();
            } else {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous voulez modifier le cours : " + availableCourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connectDB.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cours modifié");
                    alert.showAndWait();

                    availableCourseShowListData();
                    availableCourseClear();

                } else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCourseDelete() {

        String deleteData = "DELETE FROM course WHERE course = '"
                + availableCourse_course.getText() + "'";
        
        DatabaseConnection connectNow = new DatabaseConnection();
        connectDB = connectNow.getConnection();

        try {
            Alert alert;

            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_description.getText().isEmpty()
                    || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous devez remplir tous les champs vides");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Vous voulez supprimer le cours : " + availableCourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connectDB.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cours supprimé");
                    alert.showAndWait();


                    availableCourseShowListData();
                    availableCourseClear();

                } else {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void availableCourseClear() {
        availableCourse_course.setText("");
        availableCourse_description.setText("");
        availableCourse_degree.setText("");
    }

    public ObservableList<courseData> availableCourseListData() {

        ObservableList<courseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course";

        DatabaseConnection connectNow = new DatabaseConnection();
        connectDB =connectNow.getConnection();

        try {
            courseData courseD;
            preparedStatement = connectDB.prepareStatement(sql);
            queryResult = preparedStatement.executeQuery();

            while (queryResult.next()) {
                courseD = new courseData(queryResult.getString("course"),
                        queryResult.getString("description"),
                        queryResult.getString("degree"));

                listData.add(courseD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<courseData> availableCourseList;

    public void availableCourseShowListData() {
        availableCourseList = availableCourseListData();

        availableCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        availableCourse_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        availableCourse_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));

        availableCourse_tableView.setItems(availableCourseList);

    }

    public void availableCourseSelect() {
        courseData courseD = availableCourse_tableView.getSelectionModel().getSelectedItem();
        int num = availableCourse_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        availableCourse_course.setText(courseD.getCourse());
        availableCourse_description.setText(courseD.getDescription());
        availableCourse_degree.setText(courseD.getDegree());

    }

    public void logout() {

        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message de confirmation ");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment vous deconnecter ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                Stage stage = new Stage();
                Scene scene = new Scene(root);


                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);




        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(true);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);

            addStudentsShowListData();
            addStudentsYearList();
            addStudentsGenderList();
            addStudentsStatusList();


        } else if (event.getSource() == availableCourse_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(true);
            studentGrade_form.setVisible(false);

            availableCourseShowListData();

        } else if (event.getSource() == studentGrade_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(true);


        }
    }

    public void close(){
        System.exit(0);
    }
    public void minimize(){
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources){
        addStudentsShowListData();
        addStudentsYearList();
        addStudentsGenderList();
        addStudentsStatusList();

        availableCourseShowListData();
    }


}
