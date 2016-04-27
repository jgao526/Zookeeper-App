package com.catalyst.selenium.pages;

import static org.junit.Assert.*;

import org.junit.Test;

import com.catalyst.selenium.framework.PageObjectTest;

public class AnimalPageTest extends PageObjectTest {

	private AnimalPage animalPage = new AnimalPage(getDriver());

	@Test
	public void amIOnTheCorrectPageTest() {
		
		String expectedUrl = "http://localhost:8080/#/animal";
		
		String actualUrl = animalPage.getUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}

	@Test
	public void createNewAnimalTest() {
		
		
		animalPage.openForm();
		
		animalPage.fillNewAnimalFormInput("name");
		
		assertFalse(animalPage.isSubmitEnable());
		
		
		animalPage.cancelForm();
		
		animalPage.openForm();
		
		animalPage.fillNewAnimalForm("name", 1, 1);
		
		assertTrue(animalPage.isSubmitEnable());
		
		animalPage.submitForm();
		
		assertEquals("New Animal Has Been Added", animalPage.getToasterText());

	}

	@Test
	public void sortByNameTest(){
		
		String oldList = animalPage.getListRowText();
		
		animalPage.sortByName();
		
		String newList = animalPage.getListRowText();
		
		assertTrue(oldList.equals(newList));
		
	}

	@Test
	public void sortBySpeciesTest(){
		
		String oldList = animalPage.getListRowText();
		
		animalPage.sortBySpecies();
		
		String newList = animalPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}

	@Test
	public void sortByFavoriteFoodTest(){
		
		String oldList = animalPage.getListRowText();
		
		animalPage.sortByFavoriteFood();
		
		String newList = animalPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}
	
	@Test
	public void sortByEnclosureTest(){
		
		String oldList = animalPage.getListRowText();
		
		animalPage.sortByEnclosure();
		
		String newList = animalPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}
	

	@Test
	public void updateAnimalTest() {
		
		animalPage.sortByName();
		
		animalPage.openHeader();
		
		animalPage.openUpdate();
		
		animalPage.fillUpdateForm("", 1, 1);
		
		animalPage.saveUpdate();
		
		String actualText = animalPage.getToasterText();
		
		String expectedText = "Snowball's Status Has Been Updated";
		
		assertTrue(actualText.equals(expectedText));
	}

}
