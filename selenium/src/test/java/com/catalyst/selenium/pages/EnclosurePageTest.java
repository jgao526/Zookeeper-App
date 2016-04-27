package com.catalyst.selenium.pages;

import static org.junit.Assert.*;

import org.junit.Test;

import com.catalyst.selenium.framework.PageObjectTest;

public class EnclosurePageTest extends PageObjectTest {

	private EnclosurePage enclosurePage = new EnclosurePage(getDriver());

	@Test
	public void amIOnTheCorrectPageTest() {
		
		String expectedUrl = "http://localhost:8080/#/enclosure";
		
		String actualUrl = enclosurePage.getUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}

	@Test
	public void createNewEnclosureTest() {
		
		
		enclosurePage.openForm();
		
		enclosurePage.fillNewEnclosureFormInput("name", "condtion");
		
		assertFalse(enclosurePage.isSubmitEnable());
		
		
		enclosurePage.cancelForm();
		
		enclosurePage.openForm();
		
		enclosurePage.fillNewEnclosureForm("name", "condition", "2", "6");
		
		assertTrue(enclosurePage.isSubmitEnable());
		
		enclosurePage.submitForm();
		
		assertEquals("New Enclosure Has Been Added", enclosurePage.getToasterText());

	}

	@Test
	public void sortByNameTest(){
		
		String oldList = enclosurePage.getListRowText();
		
		enclosurePage.sortByName();
		
		String newList = enclosurePage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}

	@Test
	public void sortByAnimalTotalTest(){
		
		String oldList = enclosurePage.getListRowText();
		
		enclosurePage.sortByAnimalTotal();
		
		String newList = enclosurePage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}

	
	@Test
	public void sortByConditionTest(){
		
		String oldList = enclosurePage.getListRowText();
		
		enclosurePage.sortByCondition();
		
		String newList = enclosurePage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}

}
