/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.GenericDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class UserDao extends GenericDao {
    private String username;
    private Integer id;
    
    private UserDao() {
    }
    
    public UserDao(String username) {
        this.username = username;
        this.setId();
    }
    
    private void setId() {
        String SQL = "SELECT id FROM walmartuser WHERE username = '" + this.username  + "'";
        
        try {
            ResultSet rs = db.getStmt().executeQuery(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Integer getId() {
	return id;
    }
	
    public String getUsername() {
	return username;
    }
            
    public boolean validate(String password) {
        String SQL = "SELECT username, id FROM walmartUser WHERE username = '" + username
                + "' AND password = '" + password + "'";
        
        String username = null;
        try {
            ResultSet rs = db.getStmt().executeQuery(SQL);
		if (rs.next()) {
                    username = rs.getString("username");
                    id = rs.getInt("id");
                    System.out.println(id);
		}
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "UserDao", ex);
        }
        
        return username != null;
    }
    
    public void add(String password) {
        String SQL = "INSERT INTO walmartuser (username, password) VALUES ('" 
                + this.username + "', '" + password + "')";  
        
        try {
            db.getStmt().executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
