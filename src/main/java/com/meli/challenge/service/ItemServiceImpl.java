/**
 * 
 */
package com.meli.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.meli.challenge.entity.Coupon;
import com.meli.challenge.entity.FavouriteItem;
import com.meli.challenge.entity.Item;
import com.meli.challenge.repository.ItemRepository;

/**
 * @author German Biagioli
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	public ItemRepository getRepository() {
		return repository;
	}

	public void setRepository(ItemRepository repository) {
		this.repository = repository;
	}

	/**
	 *
	 */
	@Override
	public Coupon maximum_items(Coupon coupon) throws IllegalArgumentException {
		double sum = 0.0;

		
	
			Assert.notEmpty(coupon.getItemIds(),"Items list must be contains elements");
		    Assert.isTrue(coupon.getAmount() > 0,"Amount value must be greater than 0");
	
		
		
		Page<Item> itemsbyid = this.getRepository().findAllByIdIn(coupon.getItemIds(),
				PageRequest.of(0, coupon.getItemIds().size(), Sort.by(Sort.Order.asc("price"))));
		

		List<String> itemstobuy = new ArrayList<String>();
		for (Item item : itemsbyid) {
			double d = sum + item.getPrice();
			if (d <= coupon.getAmount()) {
				sum = d;
				itemstobuy.add(item.getId());
			}
		}

		Coupon result = new Coupon(itemstobuy, sum);

		return result;

	}

	/**
	 * Servicio que devuelve el top 5 de ítems más “favoriteados”.
	 */
	@Override
	public List<FavouriteItem> favourites() {


		Page<Item> itemsbyid = this.getRepository().findAll(PageRequest.of(0, 5, Sort.by(Sort.Order.desc("favourite"))));

	    List<FavouriteItem> result = itemsbyid.stream().map(new Function<Item, FavouriteItem>() {

			@Override
			public FavouriteItem apply(Item t) {
				
				return new FavouriteItem(t);
			}
		}).collect(Collectors.toList());
		
	
		return result;

	}
}
