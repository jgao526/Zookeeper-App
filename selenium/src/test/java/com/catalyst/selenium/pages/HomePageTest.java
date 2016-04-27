package com.catalyst.selenium.pages;

import static org.junit.Assert.*;

import org.junit.Test;

import com.catalyst.selenium.framework.PageObjectTest;
import com.catalyst.selenium.pages.HomePage;


public class HomePageTest extends PageObjectTest{
	
	private HomePage homePage = new HomePage(getDriver());
	
	@Test
	public void AmIOnTheCorrectPageTest(){
		
		String expectedUrl = "http://localhost:8080/#/home";
	    
		String actualUrl = homePage.getUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}
}
