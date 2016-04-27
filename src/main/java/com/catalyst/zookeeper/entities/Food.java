package com.catalyst.zookeeper.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Food entity class
 * @author jgao
 *
 */
@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	private String vendor;
	
	@ManyToOne
	@JoinColumn(name = "foodcategoryid")
	private FoodCategory foodCategory;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the foodCategory
	 */
	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	/**
	 * @param foodCategory the foodCategory to set
	 */
	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}
}
