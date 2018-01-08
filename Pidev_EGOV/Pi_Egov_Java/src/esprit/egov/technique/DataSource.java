/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.technique;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author macbookpro
 */
public class DataSource {
     private String url="jdbc:mysql://localhost:8889/Egov";
    private String login="root";
    private String password="root";
    private Connection connection;
    private static DataSource instance;

    private DataSource() {
        try {
           
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        
        return connection;
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }
    
}
