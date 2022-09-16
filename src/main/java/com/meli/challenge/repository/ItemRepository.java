/**
 * 
 */
package com.meli.challenge.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.meli.challenge.entity.Item;

/**
 * @author german
 *
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, String> {

	Page<Item> findAllByIdIn(List<String> itemIds, PageRequest page);



}
