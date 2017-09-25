package com.giroux.kevin.dofustuff.object.persistence;

import java.util.List;

import com.giroux.kevin.dofustuff.object.dto.Item;

public interface ItemPersistence {
	/**
	 * Retrieve list of Object with param
	 * @param type
	 * @return
	 */
	List<Item> retrieveListObjectByLevel(final int level);
	/**
	 * Retrieve list of Object with param
	 * @param type
	 * @return
	 */
	List<Item> retrieveListObjectByType(final String type);
	/**
	 * Retrieve list of Object with params
	 * @param level
	 * @param type
	 * @return
	 */
	List<Item> retrieveListObjectByTypeAndLevel(final int level, final String type);
	
	/**
	 * Save an item into database
	 * @param item
	 */
	void saveItem(final Item item);
}
