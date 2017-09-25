package com.giroux.kevin.dofustuff.object.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giroux.kevin.dofustuff.object.dto.Item;
import com.giroux.kevin.dofustuff.object.persistence.ItemPersistence;

@Service
public class ItemServiceImpl implements com.giroux.kevin.dofustuff.object.services.ItemService {

	@Autowired
	private ItemPersistence itemPersistence;
	
	public List<Item> retrieveListObjectByLevel(int level) {
		// TODO Auto-generated method stub
		return new ArrayList<Item>();

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
		// TODO Auto-generated method stub
		this.itemPersistence.saveItem(dto);
	}

}
