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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class ProductDao extends GenericDao {
    private int userId;

	private ProductDao() { }

	public ProductDao(int uderId) {
		this.userId = userId;
	}

    public List<String> getList() throws SQLException {
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
    
    public void addProduct (String productId) {
		try {
			String SQL = "SELECT id FROM product WHERE productId = '" + productId + "'";
			ResultSet rs = db.getStmt().executeQuery(SQL);
			
			if (!rs.next()) {
				System.out.println("Test");
				SQL = "INSERT INTO userProduct (productId, userId) VALUES ('" +
						productId + "', '" + userId + "')";
				
				db.getStmt().executeQuery(SQL);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
		}

    }
}
