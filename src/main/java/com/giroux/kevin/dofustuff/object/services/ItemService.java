package com.giroux.kevin.dofustuff.object.services;

import java.util.List;

import com.giroux.kevin.dofustuff.object.dto.Item;

/**
 * 
 * Copyright notice
 * ObjectService.java
 * 
 * @Version v1
 * @author Kevin Giroux
 * 23 sept. 2017
 */
public interface ItemService {
	/**
	 * Retrieve list of object by level
	 * @param level
	 */
	List<Item> retrieveListObjectByLevel(final int level);
	/**
	 * Retrieve list of object by type
	 * @param type
	 */
	List<Item> retrieveListObjectByType(final String type);
	/**
	 * Retrieve list of object by level and type
	 * @param level
	 * @param type
	 */
	List<Item> retrieveListObjectByTypeAndLevel(final int level, final String type);
	
	/**
	 * Save item on the database;
	 * @param dto
	 */
	void saveItem(Item dto);
}
