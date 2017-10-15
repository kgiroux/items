package com.giroux.kevin.dofustuff.object.services.impl;

import com.giroux.kevin.dofustuff.commons.item.Item;
import com.giroux.kevin.dofustuff.object.persistence.ItemPersistence;
import com.giroux.kevin.dofustuff.object.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemPersistence itemPersistence;
	
	public List<Item> retrieveListObjectByLevel(int level) {
		return itemPersistence.retrieveListObjectByLevel(level);

	}

	public List<Item> retrieveListObjectByType(String type) {
		// TODO Auto-generated method stub
		return new ArrayList<Item>();
	}

	public List<Item> retrieveListObjectByTypeAndLevel(int level, String type) {
		// TODO Auto-generated method stub
		return new ArrayList<Item>();
	}

	@Override
	public void saveItem(Item dto) {
		this.itemPersistence.saveItem(dto);
	}

}
