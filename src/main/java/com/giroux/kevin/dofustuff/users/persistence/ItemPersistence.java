package com.giroux.kevin.dofustuff.users.persistence;

import com.giroux.kevin.dofustuff.commons.item.Item;

import java.util.List;

public interface ItemPersistence {
	/**
	 * Retrieve list of Object with param
	 * @param level
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
