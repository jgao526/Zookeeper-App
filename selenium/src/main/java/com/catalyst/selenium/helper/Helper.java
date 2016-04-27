package com.catalyst.selenium.helper;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

	
	public static void highLightInput(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','background: white')", element);

	}
	
	public static void highLightButtonFalse(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		
		js.executeScript("arguments[0].setAttribute('style', 'border:none');", element);

	}
	
	public static void highLightButtonTrue(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid green');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		
		js.executeScript("arguments[0].setAttribute('style', 'border:none');", element);

	}
	

	public static void highLightBtn(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		
		js.executeScript("arguments[0].setAttribute('style', 'border:none');", element);

	}
	
	

	
}
