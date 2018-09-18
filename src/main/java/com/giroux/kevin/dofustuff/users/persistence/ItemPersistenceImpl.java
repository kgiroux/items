package com.giroux.kevin.dofustuff.users.persistence;

import com.giroux.kevin.dofustuff.commons.item.Item;
import com.giroux.kevin.dofustuff.commons.item.ItemCategory;
import com.giroux.kevin.dofustuff.users.persistence.entity.ItemEntity;
import com.giroux.kevin.dofustuff.users.persistence.factory.ItemFactory;
import com.giroux.kevin.dofustuff.users.persistence.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;
@Repository("itemPersistenceImpl")
public class ItemPersistenceImpl implements ItemPersistence {

	@Autowired 
	private ItemFactory itemFactory;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> retrieveListObjectByLevel(int level) {
		List<ItemEntity> returnList = itemRepository.findByLevelBetween(level -10, level +10 );
		return returnList.stream().map(itemFactory::entityToDto).collect(Collectors.toList());
	}

	@Override
	public List<Item> retrieveListObjectByType(String type) {
		List<ItemEntity> returnList = itemRepository.findByCategory(ItemCategory.findByCategory(type));
		return returnList.stream().map(itemFactory::entityToDto).collect(Collectors.toList());
	}

	@Override
	public List<Item> retrieveListObjectByTypeAndLevel(int level, String type) {
		List<ItemEntity> returnList = itemRepository.findByLevelAndCategory(level, ItemCategory.findByCategory(type));
		return returnList.stream().map(itemFactory::entityToDto).collect(Collectors.toList());

	}

	@Override
	public void saveItem(Item item) {
		List<ItemEntity> result = itemRepository.findByNameAndLevel(item.getName(), item.getLevel());
		if(CollectionUtils.isEmpty(result)) {
			ItemEntity itemEntity = itemFactory.dtoToEntity(item);
			itemEntity.getEffectEntityList().forEach(effectEntity -> effectEntity.setItem(itemEntity));
			itemRepository.save(itemEntity);   
		}
		
	}

	
	
}
