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
import org.mindrot.jbcrypt.BCrypt;

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
        String SQL = "SELECT id FROM walmartUser WHERE username = '" + this.username  + "'";
        
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
        String SQL = "SELECT username, id, password FROM walmartUser WHERE username = '" + username + "'";
        
        String username = null;
        try {
            ResultSet rs = db.getStmt().executeQuery(SQL);
		if (rs.next()) {
                    if(BCrypt.checkpw(password, rs.getString("password"))) {
                    username = rs.getString("username");
                    id = rs.getInt("id");
                    }
		}
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "UserDao", ex);
        }
        
        return username != null;
    }
    
    public void add(String password) {
        String SQL = "INSERT INTO walmartUser (username, password) VALUES ('" 
                + this.username + "', '" + password + "')";  
        
        try {
            db.getStmt().executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
