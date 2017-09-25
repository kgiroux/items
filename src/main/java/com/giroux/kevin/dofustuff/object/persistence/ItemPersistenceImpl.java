package com.giroux.kevin.dofustuff.object.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.giroux.kevin.dofustuff.object.dto.Item;
import com.giroux.kevin.dofustuff.object.persistence.dao.ItemEntity;
import com.giroux.kevin.dofustuff.object.persistence.factory.ItemFactory;
import com.giroux.kevin.dofustuff.object.persistence.repository.ItemRepository;
@Repository("itemPersistenceImpl")
public class ItemPersistenceImpl implements ItemPersistence {

	@Autowired 
	private ItemFactory itemFactory;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> retrieveListObjectByLevel(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> retrieveListObjectByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> retrieveListObjectByTypeAndLevel(int level, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveItem(Item item) {
		List<ItemEntity> result = itemRepository.findByNameAndLevel(item.getName(), item.getLevel());
		if(CollectionUtils.isEmpty(result)) {
			ItemEntity itemEntity = itemFactory.dtoToEntity(item);
			itemRepository.save(itemEntity);   
		}
		
	}

	
	
}
