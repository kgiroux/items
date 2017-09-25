package com.giroux.kevin.dofustuff.object.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giroux.kevin.dofustuff.object.persistence.dao.ItemEntity;


@Repository
public interface ItemRepository  extends CrudRepository<ItemEntity, String>{

	List<ItemEntity> findByNameAndLevel(final String name, final int level);
}

