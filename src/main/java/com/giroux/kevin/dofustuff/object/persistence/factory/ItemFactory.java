package com.giroux.kevin.dofustuff.object.persistence.factory;

import com.giroux.kevin.dofustuff.commons.item.Item;
import com.giroux.kevin.dofustuff.commons.utils.Factory;
import com.giroux.kevin.dofustuff.object.persistence.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ItemFactory implements Factory<ItemEntity, Item> {

	@Autowired
	private EffectFactory effectFactory;

	@Autowired
	private PropertyFactory propertyFactory;

	public Item entityToDto(ItemEntity entity) {
		Item item = new Item();
		item.setCategory(entity.getCategory());
		item.setCloth(entity.getPanoplieName());
		item.setDescription(entity.getDescription());
		item.setImageId(entity.getImageId());
		item.setLevel(entity.getLevel());
		item.setName(entity.getName());

		item.setProperty(propertyFactory.entityToDto(entity.getProperties()));
		item.setEffects(entity.getEffectEntityList().stream().map(effectFactory::entityToDto).collect(Collectors.toList()));

		return item;
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

		itemEntity.setProperties(propertyFactory.dtoToEntity(dto.getProperty()));
		itemEntity.setEffectEntityList(dto.getEffects().stream().map(effectFactory::dtoToEntity).collect(Collectors.toList()));
		return itemEntity;
	}

}
