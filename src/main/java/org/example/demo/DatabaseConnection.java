package org.example.demo;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
    String databaseName = "demo";
    String databaseUser = "root";
    String databasePassword = "R@e!bW5cOed!REaY";
    String url = "jdbc:sql://localhost/" + databaseName;

    try{
        Class.forName("com.msql.cj.jdbc.Driver");
        databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
    } catch (Exception e){
        e.printStackTrace();
    }
    return databaseLink;
}

}
