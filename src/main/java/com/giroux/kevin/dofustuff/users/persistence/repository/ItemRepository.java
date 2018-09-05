package com.giroux.kevin.dofustuff.object.persistence.repository;

import com.giroux.kevin.dofustuff.commons.item.ItemCategory;
import com.giroux.kevin.dofustuff.object.persistence.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository  extends CrudRepository<ItemEntity, String>{
	/**
	 * Retrieve items from name and level
	 * @param name
	 * @param level
	 * @return
	 */
	List<ItemEntity> findByNameAndLevel(final String name, final int level);

	/**
	 * Retrieve items from level
	 * @param levelmin
	 * @param levelmax
	 * @return
	 */
	List<ItemEntity> findByLevelBetween(final int levelmin, final int levelmax);
	/**
	 * Retrieve items from type
	 * @param category
	 * @return
	 */
	List<ItemEntity> findByCategory(final ItemCategory category);

	/**
	 * Retrieve items from Level and Type
	 * @param level
	 * @param category
	 * @return
	 */
	List<ItemEntity> findByLevelAndCategory(final int level, final ItemCategory category);
}

