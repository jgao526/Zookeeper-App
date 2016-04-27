package com.catalyst.zookeeper.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoodCategoryTest {

	private FoodCategory category = new FoodCategory();
	
	@Test
	public void testGetSetId() {
		
		int expected = 1;
		
		category.setId(expected);
		
		int actual = category.getId();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetCategoryName() {
		
		String expected = "test";
		
		category.setCategoryName(expected);
		
		String actual = category.getCategoryName();
		
		assertEquals(expected, actual);
	}

}
