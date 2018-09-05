package com.giroux.kevin.dofustuff.object.services;

import com.giroux.kevin.dofustuff.commons.item.Item;

import java.util.List;


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
	 * @param level level de l'objet
	 * @param type type de l'objet
	 * @return list des objets qui correspond aux critères
	 */
	List<Item> retrieveListObjectByTypeAndLevel(final int level, final String type);
	
	/**
	 * Save item on the database;
	 * @param dto l'objet à sauvegarder
	 */
	void saveItem(Item dto);
}
