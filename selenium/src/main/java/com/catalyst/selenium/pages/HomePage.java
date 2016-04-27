package com.catalyst.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.catalyst.selenium.framework.PageObject;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver) {
		super(driver);
		url = "http://localhost:8080/#/home";
		goTo(url);
	}

	
}
