/**
 * 
 */
package com.meli.challenge.service;

import java.util.List;

import com.meli.challenge.entity.Coupon;
import com.meli.challenge.entity.FavouriteItem;

/**
 * @author german
 *
 */
public interface ItemService {

	Coupon maximum_items(Coupon coupon);

	List<FavouriteItem> favourites() throws IllegalArgumentException;

}
