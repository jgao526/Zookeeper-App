package com.catalyst.selenium.pages;

import static org.junit.Assert.*;

import org.junit.Test;

import com.catalyst.selenium.framework.PageObjectTest;
import com.catalyst.selenium.pages.FoodPage;

public class FoodPageTest extends PageObjectTest{
	
	private FoodPage foodPage = new FoodPage(getDriver());
	
	@Test
	public void amIOnTheCorrectPageTest() {
		
		String expectedUrl = "http://localhost:8080/#/foods";
		
		String actualUrl = foodPage.getUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	public void createNewFoodTest() {
		
		foodPage.openForm();
		
		foodPage.fillNewFoodFormInput("", "vendor");
		
		assertFalse(foodPage.isSubmitEnable());
		
		
		foodPage.cancelForm();
		
		foodPage.openForm();
		
		foodPage.fillNewFoodForm("name", "", 1);
		
		assertFalse(foodPage.isSubmitEnable());
		
		
		foodPage.cancelForm();
		
		foodPage.openForm();
		
		foodPage.fillNewFoodFormInput("name", "vendor");
		
		assertFalse(foodPage.isSubmitEnable());
		
		
		foodPage.cancelForm();
		
		foodPage.openForm();
		
		foodPage.fillNewFoodForm("name", "vendor", 1);
		
		assertTrue(foodPage.isSubmitEnable());
		
		foodPage.submitForm();
		
		assertEquals("New Food Has Been Added", foodPage.getToasterText());

	}

	
	@Test
	public void sortByNameTest(){
		
		String oldList = foodPage.getListRowText();
		
		foodPage.sortByName();
		
		String newList = foodPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}
	
	@Test
	public void sortByVendorTest(){
		
		String oldList = foodPage.getListRowText();
		
		foodPage.sortByVendor();
		
		String newList = foodPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}
	
	@Test
	public void sortByCategoryTest(){
		
		String oldList = foodPage.getListRowText();
		
		foodPage.sortByCategory();
		
		String newList = foodPage.getListRowText();
		
		assertFalse(oldList.equals(newList));
		
	}
	
	@Test
	public void updateFoodTest() {
		
		foodPage.sortByName();
		
		foodPage.openHeader();
		
		foodPage.openUpdate();
		
		foodPage.fillUpdateForm("", "", 2);
		
		foodPage.saveUpdate();
		
		String actualText = foodPage.getToasterText();
		
		String expectedText = "Selected Food Has Been Updated";
		
		assertTrue(actualText.equals(expectedText));
	}
	

}
