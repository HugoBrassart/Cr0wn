package org.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class LoginController {
    @FXML
    public Button loginButton;
    @FXML
    private Button closeButton;
    @FXML
private Label loginMessageLabel;
    @FXML
private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;



    public void loginButtonOnAction(javafx.event.ActionEvent actionEvent){


 if (!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()){
     validateLogin();
 }else {
     loginMessageLabel.setText("VOUS DEVEZ ENTRER UN IDENTIFIANT ET UN MOT DE PASSE ");
 }
    }

    public void closeButtonOnAction(javafx.event.ActionEvent actionEvent){
        Stage stage = (Stage)closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB =connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_accounts WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1) == 1) {
                   // loginMessageLabel.setText("BONSOIR");
                    createDashboard();
                }   else {
                    loginMessageLabel.setText("MAUVAIS LOGINS");
                    }
            }

        } catch (Exception e) {
 e.printStackTrace();
 e.getCause();
        }
    }

    public void createDashboard(){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
            Stage registerstage = new Stage();
            registerstage.initStyle(StageStyle.UNDECORATED);
            registerstage.setScene(new Scene(root, 900, 600));
            registerstage.show();
            loginButton.getScene().getWindow().hide();
        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}