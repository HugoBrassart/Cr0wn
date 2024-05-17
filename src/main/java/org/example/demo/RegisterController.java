package org.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;



public class RegisterController {
@FXML
    public Button registerButton;
    @FXML
private Button cancelButton;
@FXML
private Label registrationMessageLabel;
@FXML
private PasswordField setPasswordField;
@FXML
private PasswordField confirmPasswordField;
@FXML
private Label confirmPasswordLabel;
@FXML
private TextField firstnameTextField;
@FXML
private TextField lastnameTextField;
@FXML
private TextField usernameTextField;



    public void registerButtonOnAction(javafx.event.ActionEvent actionEvent){
        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            confirmPasswordLabel.setText("");
            registerUser();
        } else {
            confirmPasswordLabel.setText("Le mot de passe ne correspond pas");
        }

}
    public void cancelButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void registerUser(){
    DatabaseConnection connectNow = new DatabaseConnection();
        try (Connection connectDB = connectNow.getConnection();
             Statement statement = connectDB.createStatement()) {

            String firstname = firstnameTextField.getText();
            String lastname = lastnameTextField.getText();
            String username = usernameTextField.getText();
            String password = setPasswordField.getText();

            String insertFields = "INSERT INTO user_accounts(firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connectDB.prepareStatement(insertFields);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();

            registrationMessageLabel.setText("Vos informations ont bien été enregistrées");

        } catch (Exception e){
    e.printStackTrace();
    e.getCause();
}
}

}
