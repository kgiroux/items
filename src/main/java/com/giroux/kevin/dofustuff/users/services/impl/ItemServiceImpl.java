package com.giroux.kevin.dofustuff.object.services.impl;

import com.giroux.kevin.dofustuff.commons.item.Item;
import com.giroux.kevin.dofustuff.object.persistence.ItemPersistence;
import com.giroux.kevin.dofustuff.object.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemPersistence itemPersistence;

	@Override
	public List<Item> retrieveListObjectByLevel(int level) {
		return itemPersistence.retrieveListObjectByLevel(level);

	}
	@Override
	public List<Item> retrieveListObjectByType(final String type) {
		return itemPersistence.retrieveListObjectByType(type);
	}
	@Override
	public List<Item> retrieveListObjectByTypeAndLevel(int level, String type) {
		return itemPersistence.retrieveListObjectByTypeAndLevel(level, type);
	}

	@Override
	public void saveItem(Item dto) {
		this.itemPersistence.saveItem(dto);
	}

}
