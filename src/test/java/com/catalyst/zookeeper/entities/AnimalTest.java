package com.catalyst.zookeeper.entities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class AnimalTest {
	private Animal animal = new Animal();
	
	@Test
	public void testGetSetId() {
		
		int expected = 1;
		
		animal.setId(expected);
		
		int actual = animal.getId();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetName() {
		
		String expected = "test";
		
		animal.setName(expected);
		
		String actual = animal.getName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGeTSeTSpecies() {
		
		Species expected = mock(Species.class);
		
		animal.setSpecies(expected);
		
		Species actual = animal.getSpecies();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetEnclosure() {
		
		Enclosure expected = mock(Enclosure.class);
		
		animal.setEnclosure(expected);
		
		Enclosure actual = animal.getEnclosure();
		
		assertEquals(expected, actual);
	}

}
