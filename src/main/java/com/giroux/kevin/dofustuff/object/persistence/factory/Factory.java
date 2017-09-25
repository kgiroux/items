package com.giroux.kevin.dofustuff.object.persistence.factory;
/**
 * 
 * Copyright notice
 * Factory.java
 * 
 * @Version v1
 * @author Kevin Giroux
 * 24 sept. 2017
 */
public interface Factory<T,K> {
	/**
	 *  Convert a entity to a DTO
	 * @param entity
	 * @return
	 */
	K entityToDto(T entity);
	/**
	 * Convert a DTO to entity
	 * @param dto
	 * @return
	 */
	T dtoToEntity(K dto);
}
