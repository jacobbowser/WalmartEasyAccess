/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WalmartApi.model.ItemJson;

/**
 *
 * @author Quade
 */
public class Item {
	private String name;
	private String itemId;
	private String salePrice;
	private String thumbnailImage;
	private String addToCartUrl;

	public String getName() {
		return name;
	}

	public String getId() {
		return itemId;
	}

	public String getPrice() {
		return "$" + salePrice;
	}

	public String getImageUrl() {
		return thumbnailImage;
	}

	public String getAddToCartUrl() {
		return addToCartUrl;
	}
}
