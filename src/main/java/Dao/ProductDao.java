/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.GenericDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jacob
 */
public class ProductDao extends GenericDao {
                
    public List<String> getList(int userId) throws SQLException {
        String SQL = "SELECT walmartProductId FROM product WHERE userId = " + userId;
        ResultSet rs = db.getStmt().executeQuery(SQL);
        List<String> productList = new ArrayList<>();
        while(rs.next())
        {
            String productId = rs.getString("walmartProductId");
            productList.add(productId);
        }
        return productList;
    }   
    
    public void addProduct (int product, int userId) throws SQLException{
        String SQL = "INSERT INTO product (productId, userId) VALUES (" + product 
                + ", " + userId + ")";
        ResultSet rs = db.getStmt().executeQuery(SQL);
    }
}
