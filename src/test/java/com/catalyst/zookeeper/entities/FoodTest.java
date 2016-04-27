package com.catalyst.zookeeper.entities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class FoodTest {

	private Food food = new Food();
	
	@Test
	public void testGetSetId() {
		
		int expected = 1;
		
		food.setId(expected);
		
		int actual = food.getId();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetName() {
		
		String expected = "test";
		
		food.setName(expected);
		
		String actual = food.getName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetVendor() {
		
		String expected = "test";
		
		food.setVendor(expected);
		
		String actual = food.getVendor();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSetFoodCategory() {
		
		FoodCategory expected = mock(FoodCategory.class);
		
		food.setFoodCategory(expected);
		
		FoodCategory actual = food.getFoodCategory();
		
		assertEquals(expected, actual);
	}
}
