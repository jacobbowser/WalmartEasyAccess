/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WalmartApi.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Quade
 */
public class ApiKey {
	private static String key;

	public static String asString() {
		if (key == null) {
			Properties prop = new Properties();
			
			try {
				prop.load(ApiKey.class.getResourceAsStream("config.properties"));
				key = prop.getProperty("apiKey");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return key;
	}

}
