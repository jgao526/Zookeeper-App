package com.catalyst.zookeeper.entities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class SpeciesTest {

	private Species species = new Species();
	
	@Test
	public void testGetSetId() {
		
		int expected = 1;
		
		species.setId(expected);
		
		int actual = species.getId();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSetCommonName() {
		
		String expected = "test";
		
		species.setCommonName(expected);
		
		String actual = species.getCommonName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetScientificName() {
		
		String expected = "test";
		
		species.setScientificName(expected);
		
		String actual = species.getScientificName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetInfoLink() {
		
		String expected = "test";
		
		species.setInfoLink(expected);
		
		String actual = species.getInfoLink();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetFood() {
		
		Food expected = mock(Food.class);
		
		species.setFood(expected);
		
		Food actual = species.getFood();
		
		assertEquals(expected, actual);
	}
}
