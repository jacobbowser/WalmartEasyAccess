/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.GenericDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class UserDao extends GenericDao {
    String username;
    String password;
    
    private UserDao() {
    }
    
    public UserDao(String username, String password) {
        this.username = username;
        this.password = password;
    }
            
    public boolean validate() {
        String SQL = "SELECT username FROM walmartUser WHERE username = '" + username
                + "' AND password = '" + password + "'";
        
        String username = null;
        try {
            ResultSet rs = db.getStmt().executeQuery(SQL);
			if (rs.next()) {
				username = rs.getString("username");
			}
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "UserDao", ex);
        }
        
        return username != null;
    }
}
