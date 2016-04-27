package com.catalyst.zookeeper.daos.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catalyst.zookeeper.entities.Food;
import com.catalyst.zookeeper.entities.FoodCategory;

public class FoodDAOImplTest {

	private FoodDAOImpl dao = new FoodDAOImpl();
	
	@Mock
	private EntityManager mockEm;
	
	@Mock
	private TypedQuery<Food> mockFoodQuery;
	
	@Mock
	private TypedQuery<FoodCategory> mockFoodCategoryQuery;
	
	@Mock
	private Food food;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		dao.setEm(mockEm);
	}
	
	@Test
	public void testAddFood() {
		
		dao.addFood(food);
		
		verify(mockEm).persist(food);
	}
	
	@Test
	public void testUpadateFood(){
		
		dao.updateFood(food);
		
		verify(mockEm).merge(food);
	}

	@Test
	public void testGetFoodById() {
		
		when(mockEm.createQuery("SELECT f FROM Food f where f.id = :id", Food.class)).thenReturn(mockFoodQuery);
		
		when(mockFoodQuery.setParameter("id", 1)).thenReturn(mockFoodQuery);
		
		when(mockFoodQuery.getSingleResult()).thenReturn(food);
		
		assertEquals(food, dao.getFoodById(1));
	}
	
	@Test
	public void testGetFoodList(){
		
		List<Food> foodList = new ArrayList<Food>();
		
		when(mockEm.createQuery("SELECT f FROM Food f ORDER BY f.id DESC", Food.class)).thenReturn(mockFoodQuery);
		
		when(mockFoodQuery.getResultList()).thenReturn(foodList);
		
		assertEquals(foodList, dao.getFoodList());
	}
	
	@Test
	public void testGetFoodCategory() {
		
		List<FoodCategory> category = new ArrayList<FoodCategory>();
		
		when(mockEm.createQuery("SELECT c FROM FoodCategory c", FoodCategory.class)).thenReturn(mockFoodCategoryQuery);
		
		when(mockFoodCategoryQuery.getResultList()).thenReturn(category);
		
		assertEquals(category, dao.getFoodCategory());
	}

}
