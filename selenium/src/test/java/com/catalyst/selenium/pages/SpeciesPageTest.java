package com.catalyst.selenium.pages;

import static org.junit.Assert.*;

import org.junit.Test;

import com.catalyst.selenium.framework.PageObjectTest;

public class SpeciesPageTest extends PageObjectTest{

	private SpeciesPage speciesPage = new SpeciesPage(getDriver());

	@Test
	public void amIOnTheCorrectPageTest() {
		
		String expectedUrl = "http://localhost:8080/#/species";
		
		String actualUrl = speciesPage.getUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}

	@Test
	public void createNewSpeciesTest() {
		
		
		speciesPage.openForm();
		
		speciesPage.fillNewSpeciesFormInput("name", "scientificName", "testLink");
		
		assertFalse(speciesPage.isSubmitEnable());
		
		
		speciesPage.cancelForm();
		
		speciesPage.openForm();
		
		speciesPage.fillNewSpeciesForm("name", "scientificName", "testLink", 1);
		
		assertTrue(speciesPage.isSubmitEnable());
		
		speciesPage.submitForm();
		
		assertEquals("New Species Has Been Added", speciesPage.getToasterText());

	}

	@Test
	public void sortByCommonNameTest(){
		
		String oldList = speciesPage.getListRowText();
		
		speciesPage.sortByCommonName();
		
		String newList = speciesPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}

	@Test
	public void sortByScientificNameTest(){
		
		String oldList = speciesPage.getListRowText();
		
		speciesPage.sortByScientific();
		
		String newList = speciesPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}

	@Test
	public void sortByFavoriteFoodTest(){
		
		String oldList = speciesPage.getListRowText();
		
		speciesPage.sortByFavFood();
		
		String newList = speciesPage.getListRowText();
		
		assertTrue(oldList.equals(newList));
		
	}
	
	

	@Test
	public void updateSpeciesTest() {
		
		speciesPage.sortByCommonName();
		
		speciesPage.openHeader();
		
		speciesPage.openUpdate();
		
		speciesPage.fillUpdateForm("", "", "", 2);
		
		speciesPage.saveUpdate();
		
		String actualText = speciesPage.getToasterText();
		
		String expectedText = "Selected Species Has Been Updated";
		
		assertTrue(actualText.equals(expectedText));
	}


}
