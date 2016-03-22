/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WalmartApi;

import WalmartApi.model.ApiKey;
import WalmartApi.model.ItemJson.Item;
import WalmartApi.model.ItemJson.ItemList;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quade
 */
public class WalmartApi {
	private static final String API_KEY = ApiKey.asString();
	private static final String API_URL = "http://api.walmartlabs.com/v1/";

	private WalmartApi() {
	}

	public static List<Item> search(String query) {
		String url = API_URL + "search?query=" + query + "&format=json&apiKey=" + API_KEY;
		String json = getJsonFromUrl(url);

		Gson gson = new Gson();
		ItemList list = gson.fromJson(json, ItemList.class);
		return list.getItems();
	}

	public static Item lookUp(String id) {
		String url = API_URL + "items/" + id + "?format=json&apiKey=" + API_KEY;
		String json = getJsonFromUrl(url);

		Gson gson = new Gson();
		return gson.fromJson(json, Item.class);
	}

	private static String getJsonFromUrl(String stringUrl) {
		BufferedReader reader = null;
		try {
			URL url = new URL(stringUrl);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
			
			return buffer.toString();
		} catch (IOException ex) {
			Logger.getLogger(WalmartApi.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException ex) {
					Logger.getLogger(WalmartApi.class.getName()).log(Level.SEVERE, null, ex);
				}
		}

		return null;
	}
}
