/**
 * 
 */
package com.meli.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meli.challenge.entity.Coupon;
import com.meli.challenge.entity.FavouriteItem;
import com.meli.challenge.exception.InvalidRequestException;
import com.meli.challenge.service.ItemService;

/**
 * @author German biagioli
 *
 */
@RestController
@RequestMapping("coupon")
public class ItemController {

	@Autowired
	private ItemService service;

	

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Coupon> maximum_items(@RequestBody Coupon coupon) {

		try {
			Coupon maximum_items = this.getService().maximum_items(coupon);
			return new ResponseEntity<Coupon>(maximum_items, HttpStatus.OK);

		} catch (IllegalArgumentException e) {

			throw new InvalidRequestException(e.getMessage());
		}

	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FavouriteItem>> favourites() {

		List<FavouriteItem> favourites = this.getService().favourites();

		return new ResponseEntity<List<FavouriteItem>>(favourites, HttpStatus.OK);

	}

	public ItemService getService() {
		return service;
	}

	public void setService(ItemService service) {
		this.service = service;
	}

}
