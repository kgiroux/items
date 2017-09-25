package com.giroux.kevin.dofustuff.object.persistence.factory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.giroux.kevin.dofustuff.object.dto.Item;
import com.giroux.kevin.dofustuff.object.persistence.dao.ItemEntity;

@Component
public class ItemFactory implements Factory<ItemEntity, Item>{

	public Item entityToDto(ItemEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemEntity dtoToEntity(Item dto) {
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(String.valueOf(UUID.randomUUID()));
		itemEntity.setLevel(dto.getLevel());
		itemEntity.setName(dto.getName());
		itemEntity.setPanoplieName(dto.getCloth());
		itemEntity.setDescription(dto.getDescription());
		itemEntity.setCategory(dto.getCategory());
		itemEntity.setImageId(dto.getImageId());
		return itemEntity;
	}

}
