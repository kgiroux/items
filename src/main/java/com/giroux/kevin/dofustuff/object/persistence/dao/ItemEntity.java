package com.giroux.kevin.dofustuff.object.persistence.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.giroux.kevin.dofustuff.object.dto.ItemCategory;
@Entity
@Table(name="item", schema="sch_dofustuff")
public class ItemEntity implements Serializable{

	/**
	 *  serialVersionUID : 
	 */
	private static final long serialVersionUID = -4809179029597024020L;
	
	@Id
	@Column(columnDefinition="text")
	private String id;
	
	@Column
	private String name;
	
	@Column(columnDefinition="text")
	private String description;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ItemCategory category;
	
	@Column
	private int level;
	@Column
	private String panoplieName = "none";
	
	@Column(nullable=true)
	private Integer imageId;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public ItemCategory getCategory() {
		return category;
	}
	/**
	 * @param type the type to set
	 */
	public void setCategory(ItemCategory type) {
		this.category = type;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the panoplieName
	 */
	public String getPanoplieName() {
		return panoplieName;
	}
	/**
	 * @param panoplieName the panoplieName to set
	 */
	public void setPanoplieName(String panoplieName) {
		this.panoplieName = panoplieName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the imageId
	 */
	public Integer getImageId() {
		return imageId;
	}
	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	
	
}
