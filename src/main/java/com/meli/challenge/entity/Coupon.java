/**
 * 
 */
package com.meli.challenge.entity;

import java.util.List;

/**
 * @author german
 *
 */
public class Coupon {
	
	private List<String> itemIds;
	private Double amount;
	
	
	
	public Coupon(List<String> items, double amount) {
		this.itemIds=items;
		this.amount=amount;
	}
	public List<String> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
