package com.catalyst.zookeeper.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.zookeeper.daos.FoodDAO;
import com.catalyst.zookeeper.entities.Food;
import com.catalyst.zookeeper.entities.FoodCategory;

/**
 * this class is used to set end point related to Food
 * @author jGao
 *
 */

@RestController
public class FoodWebService {
	
	@Autowired
	private FoodDAO foodDAO;
	
	/**
	 * sets the food dao
	 * @param foodDAO
	 */
	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}
	
	/**
	 * use this to add new food
	 * @param food
	 */
	@RequestMapping(value="/foods", method = RequestMethod.POST)
	public void addFood(@RequestBody Food food) {
		String filteredName = food.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredVendor = food.getVendor().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		food.setName(StringUtils.capitalize(filteredName));
		food.setVendor(StringUtils.capitalize(filteredVendor));
		foodDAO.addFood(food);
	}
	
	/**
	 * use this to update a specific food
	 * @param food
	 */
	@RequestMapping(value="/foods", method = RequestMethod.PUT)
	public void updateFood(@RequestBody Food food) {
		String filteredName = food.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredVendor = food.getVendor().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		food.setName(StringUtils.capitalize(filteredName));
		food.setVendor(StringUtils.capitalize(filteredVendor));
		foodDAO.updateFood(food);
	}
	
	/**
	 * use this to get a specific food based on food's id
	 * @param id
	 * @return Food
	 */
	@RequestMapping(value="/foods/{id}", method = RequestMethod.GET)
	public Food getFoodById(@PathVariable Integer id) {
		return foodDAO.getFoodById(id);
	}
	
	/**
	 * use this to get a list of all the foods
	 * @return List<Food>
	 */
	@RequestMapping(value="/foods", method = RequestMethod.GET)
	public List<Food> getFoodList(){
		return foodDAO.getFoodList();
	}
	
	/**
	 * use this to get a list of all the food category
	 * @return List<FoodCategory>
	 */
	@RequestMapping(value="/foods/category", method = RequestMethod.GET)
	public List<FoodCategory> getFoodCategory(){
		return foodDAO.getFoodCategory();
	}
}
