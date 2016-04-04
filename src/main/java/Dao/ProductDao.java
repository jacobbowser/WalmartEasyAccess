/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.GenericDao;
import WalmartApi.WalmartApi;
import WalmartApi.model.ItemJson.Item;
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

	public ProductDao(int userId) {
		this.userId = userId;
	}

    public List<Item> getList() {
        try {
            String SQL = "SELECT walmartId FROM product JOIN userProduct ON userId " +
                    "WHERE userId = '" + userId + "' and productId = product.id";

            List<Item> productList = new ArrayList<>();
            ResultSet rs = db.getStmt().executeQuery(SQL);
            while(rs.next())
            {
                String walmartId = rs.getString("walmartId");
                productList.add(WalmartApi.lookUp(walmartId));
            }
            
            return productList;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }   
    
    public void addProduct (String walmartId) {
		try {
                        int productId = 0;
			String SQL = "SELECT id FROM product WHERE walmartId = '" + walmartId + "'";
			ResultSet rs = db.getStmt().executeQuery(SQL);
                        if(rs.next()) {
                           productId = rs.getInt("id");
                        }
			else {
                                SQL = "INSERT INTO product (walmartId) VALUES ('" + walmartId + "')";
                                db.getStmt().executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
                                ResultSet key = db.getStmt().getGeneratedKeys();
                                if (key.next()){
                                    productId = key.getInt(1);
                                }
                        }
                        SQL = "SELECT productId FROM userProduct WHERE userId = '" + userId +
                                "' AND productId = '" + productId + "'";
                        rs = db.getStmt().executeQuery(SQL);
                        if(!rs.next()) {
			SQL = "INSERT INTO userProduct (productId, userId) VALUES ('" +
				productId + "', '" + userId + "')";
			db.getStmt().executeUpdate(SQL);
                        }
		} catch (SQLException ex) {
			Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
}
