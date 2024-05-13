package org.example.demo;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){

    String databaseUser = "root";
    String databasePassword = "";
    String url = "jdbc:mysql://localhost:3306/demo";

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
    } catch (Exception e){
        e.printStackTrace();
    }
    return databaseLink;
}

}
