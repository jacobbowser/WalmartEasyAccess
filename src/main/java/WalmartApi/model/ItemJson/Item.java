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
	private String stock;
	private boolean availableOnline;

	private String checkPriceFormat() {
		String price;

		int dotIndex = salePrice.indexOf('.');
		String cents = salePrice.substring(dotIndex + 1);

		if (cents.length() < 2) {
			cents += '0';
			price = salePrice.substring(0, dotIndex + 1) + cents;
		} else {
			price = salePrice;
		}

		return price;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return itemId;
	}

	public String getPrice() {
		return "$" + checkPriceFormat();
	}

	public String getImageUrl() {
		return thumbnailImage;
	}

	public String getAddToCartUrl() {
		return addToCartUrl;
	}

	public String getStock() {
		return stock;
	}

	public boolean getAvailableOnline() {
		return availableOnline;
	}
}
