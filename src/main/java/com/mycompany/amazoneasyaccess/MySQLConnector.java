/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazoneasyaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class MySQLConnector {
    private static volatile MySQLConnector instance;
    
    private String host;
    private String URL;
    private String user;
    private String pass;
    private Connection conn;
    private Statement stmt;
    private final String DBname = "Walmart";
    
    private MySQLConnector() {
        this.host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        if(this.host == null || this.host == "") {
            this.URL = "jdbc:mysql://localhost/" + DBname;
            this.user = "jacobbowser";
            this.pass = "password";
        }
        else {
            this.URL = "jdbc:mysql://" + host + "/" + DBname;
            this.user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            this.pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        }
        
        this.stmt = null;
        this.conn = null;
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.conn = DriverManager.getConnection(URL, user, pass);
            this.stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    };

    public Statement getStmt() {
        return stmt;
    }
    
    public static MySQLConnector getInstance() {
        if (instance == null) {
            synchronized (MySQLConnector.class) {
                if (instance == null) {
                    instance = new MySQLConnector();
                }
            }
        }
        
        return instance;     
    }
}
