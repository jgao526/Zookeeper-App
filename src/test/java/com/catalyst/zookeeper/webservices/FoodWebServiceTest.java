package com.catalyst.zookeeper.webservices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catalyst.zookeeper.daos.FoodDAO;
import com.catalyst.zookeeper.entities.Food;
import com.catalyst.zookeeper.entities.FoodCategory;

public class FoodWebServiceTest {

	private FoodWebService service = new FoodWebService();
	
	@Mock
	private FoodDAO foodDAO;
	
	@Mock
	private Food food;
	
	@Mock
	private List<Food> foodList;
	
	@Mock
	private List<FoodCategory> category;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		service.setFoodDAO(foodDAO);
	}
	
	@Test
	public void testAddFood() {
		
		when(food.getName()).thenReturn("name");
		
		String filteredName = food.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		food.setName(filteredName);
		
		when(food.getVendor()).thenReturn("vendor");
		
		String filteredVendor = food.getVendor().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		food.setVendor(filteredVendor);
		
		service.addFood(food);
		
		verify(foodDAO).addFood(food);
	}
	
	@Test
	public void testUpdateFood() {
		
		when(food.getName()).thenReturn("name");
		
		String filteredName = food.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		food.setName(filteredName);
		
		when(food.getVendor()).thenReturn("vendor");
		
		String filteredVendor = food.getVendor().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		food.setVendor(filteredVendor);
		
		service.updateFood(food);
		
		verify(foodDAO).updateFood(food);
	}
	
	@Test
	public void testGetFoodById() {
		
		Food expected = service.getFoodById(1);
		
		Food actual = service.getFoodById(1);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetFoodList() {
		
		when(service.getFoodList()).thenReturn(foodList);
		
		assertEquals(foodList, foodDAO.getFoodList());
	}

	@Test
	public void testGetFoodCategory() {
		
		when(service.getFoodCategory()).thenReturn(category);
		
		assertEquals(category, foodDAO.getFoodCategory());
	}
}
