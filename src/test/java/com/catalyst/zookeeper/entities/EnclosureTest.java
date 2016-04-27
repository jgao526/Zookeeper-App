package com.catalyst.zookeeper.entities;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class EnclosureTest {
	
	private Enclosure enclosure = new Enclosure();
	
	@Test
	public void testGetSetId() {
		
		int expected = 1;
		
		enclosure.setId(expected);
		
		int actual = enclosure.getId();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetName() {
		
		String expected = "test";
		
		enclosure.setName(expected);
		
		String actual = enclosure.getName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetAnimalTotal() {
		
		int expected = 1;
		
		enclosure.setAnimalTotal(expected);
		
		int actual = enclosure.getAnimalTotal();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetSetStartFeedTime() {
		
		Date expected = new Date();
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime((Date) expected.clone());
		
		cal.set(2016, 0, 1);
		
		Date expectedClone = cal.getTime();
		
		enclosure.setStartFeedTime(expectedClone);
		
		Date actual = enclosure.getStartFeedTime();
		
		assertEquals(expectedClone, actual);
	}
	
	@Test
	public void testGetSetEndFeedTime() {
		
		Date expected = new Date();
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(expected);
		
		cal.set(2016,  0, 1);
		
		Date expectedClone = cal.getTime();
		
		enclosure.setEndFeedTime(expectedClone);
		
		Date actual = enclosure.getEndFeedTime();
		
		assertEquals(expectedClone, actual);
	}
	
	@Test
	public void testGetSetCondition() {
		
		String expected = "test";
		
		enclosure.setCondition(expected);
		
		String actual = enclosure.getCondition();
		
		assertEquals(expected, actual);
	}


}
