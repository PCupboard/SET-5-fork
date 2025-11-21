package org.route;

import java.sql.*;
import java.sql.Connection;

public class DatabaseConnection {
    final String url = "jdbc:(databemerke vi bruker)://(her skriver vi localhost eller annet som står i databasen)";
    String username = null;
    String password = null;
    Connection connection = null;
    Statement statement = null;


        public DatabaseConnection(String username,String password){
         username ="root";
         password = "skriv passordet for å få tilgang";
        }

        public void connect() throws SQLException,Exception{
            //Class.forName(url);
            System.out.println("Connecting....");
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
        }

        public void closeConnection() throws SQLException , Exception{
             statement.close();
             connection.close();
    }

    public Statement getStatement(){
            return statement;
    }

    public Connection getConnection(){
            return connection;
    }




}
