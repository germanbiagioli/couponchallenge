/**
 * 
 */
package com.meli.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author German Biagioli
 * 
 *
 */
@Entity
@Table(name="items")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "iditem",nullable = false,length = 10)
	private String id;
	
	
	@Column(name="favourite")
	private Integer favourite=0;
	
	@Column(name="price", columnDefinition="Decimal(10,2)")
	private Double price=0.0;
	
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String itemId) {
		this.id = itemId;
	}
	public Integer getFavourite() {
		return favourite;
	}
	public void setFavourite(Integer favourite) {
		this.favourite = favourite;
	}
	

}
