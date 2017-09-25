package com.giroux.kevin.dofustuff.object.dto;

public class Item {

    private String name;
    private String description;
    private int level;
    private String cloth;
    private Integer imageId;
    private ItemCategory category;

    public Item() {
    		this.cloth = "NONE";
    }
    
    public String getCloth() {
		return cloth;
	}

	public void setCloth(String cloth) {
		this.cloth = cloth;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

	/**
	 * @return the category
	 */
	public ItemCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(ItemCategory category) {
		this.category = category;
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
