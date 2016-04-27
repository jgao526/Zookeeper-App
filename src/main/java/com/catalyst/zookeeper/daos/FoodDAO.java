package com.catalyst.zookeeper.daos;

import java.util.List;

import com.catalyst.zookeeper.entities.Food;
import com.catalyst.zookeeper.entities.FoodCategory;

/**
 * FoodDAO interface class
 * @author jGao
 *
 */
public interface FoodDAO {

	/**
	 * use this to add new food 
	 * @param food
	 */
	void addFood(Food food);
	
	/**
	 * use this to update a specific food
	 * @param food
	 */
	void updateFood(Food food);
	
	/**
	 * use this to get a specific food based on food's id
	 * @param id
	 * @return Food
	 */
	Food getFoodById(int id);
	
	/**
	 * use this to get a list of food
	 * @return List<Food>
	 */
	List<Food> getFoodList();

	
	/**
	 * use this to get a list of all the food category
	 * @return List<FoodCategory>
	 */
	List<FoodCategory> getFoodCategory();
}
