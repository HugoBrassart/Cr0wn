package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
    @FXML
    private Button cancelButton;
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

    public void cancelButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB =connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("BONSOIR");
                }   else {
                    loginMessageLabel.setText("MAUVAIS LOGINS");
                    }
            }

        } catch (Exception e) {
 e.printStackTrace();
        }
    }

}