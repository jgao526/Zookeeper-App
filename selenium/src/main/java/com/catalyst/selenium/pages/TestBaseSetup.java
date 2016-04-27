package com.catalyst.selenium.pages;

import org.openqa.selenium.WebDriver;

public class TestBaseSetup {
	
	private WebDriver driver;
	private String driverPath = "src/main/java/com/catalyst/selenium/drivers/chromedriver.exe";
	
	public WebDriver getDriver(){
		return driver;
	}
	
	private void setDriver(String browserType, String appURL) {
		switch(browserType){
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}
	
	
}
