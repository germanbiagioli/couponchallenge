/**
 * 
 */
package com.meli.challenge.entity;

/**
 * @author german
 *
 */
public class FavouriteItem {
	
	private String id;
	private Integer quantity;
	public FavouriteItem(Item t) {
		this.id=t.getId();
		this.quantity=t.getFavourite();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
