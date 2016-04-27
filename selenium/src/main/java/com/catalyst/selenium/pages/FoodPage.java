package com.catalyst.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.selenium.framework.PageObject;
import com.catalyst.selenium.helper.Helper;

public class FoodPage extends PageObject{
	
	private static final By NEW_FOOD_BTN = By.id("newBtn");
	private static final By NEW_FOOD_NAME_FIELD = By.id("foodName");
	private static final By NEW_FOOD_VENDOR_FIELD = By.id("foodVendor");
	private static final By NEW_FOOD_CATEGORY = By.id("categoryDropDown");
	private static final By SUBMIT_BTN = By.id("submitBtn");
	private static final By CANCEL_BTN = By.id("cancelBtn");
	private static final By TOASTER = By.xpath("//div[@class='ng-binding toast-title']");
	private static final By FOOD_LIST_ROW = By.xpath("//div[@class='row rowHeader ng-scope']");
	private static final By FOOD_LIST_APPLE_DIV = By.xpath("//div[@class='col-xs-4 ng-binding' and contains(text(),'Pork')]");
	private static final By UPDATE_BTN = By.xpath("(//button[@class='btn btn-success updateBtn ng-scope'])[1]");
	private static final By SAVE_BTN = By.xpath("(//button[@class='btn btn-primary pull-right saveBtn'])[1]");
	private static final By UPDATE_NAME_INPUT = By.xpath("(//input[@name='updateName'])[1]");
	private static final By UPDATE_VENDOR_INPUT = By.xpath("(//input[@name='updateVendor'])[1]");
	private static final By UPDATE_CATEGORY_SELECT = By.xpath("(//select[@name='updateCategory'])[1]");
	private static final By NAME_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='name']/a/span[@class='glyphicon glyphicon-sort']");
	private static final By VENDOR_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='vendor']/a/span[@class='glyphicon glyphicon-sort']");
	private static final By CATEGORY_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='category']/a/span[@class='glyphicon glyphicon-sort']");
	
	public FoodPage(WebDriver driver) {
		super(driver);
		url="http://localhost:8080/#/foods";
		goTo(url);
		sleep(2000);
	}
	
	
	
	public void fillNewFoodFormInput(String name, String vendor){
		Helper.highLightInput(driver, NEW_FOOD_NAME_FIELD.findElement(driver));
		sendKeys(NEW_FOOD_NAME_FIELD, name);
		Helper.highLightInput(driver, NEW_FOOD_VENDOR_FIELD.findElement(driver));
		sendKeys(NEW_FOOD_VENDOR_FIELD, vendor);
		sleep(2000);
	}
	
	
	public void fillNewFoodForm(String name, String vendor, int category){
		Helper.highLightInput(driver, NEW_FOOD_NAME_FIELD.findElement(driver));
		sendKeys(NEW_FOOD_NAME_FIELD, name);
		Helper.highLightInput(driver, NEW_FOOD_VENDOR_FIELD.findElement(driver));
		sendKeys(NEW_FOOD_VENDOR_FIELD, vendor);
		Select select = new Select(NEW_FOOD_CATEGORY.findElement(driver));
		select.selectByIndex(category);
		sleep(2000);
	}
	
	public void submitForm() {
		Helper.highLightBtn(driver, SUBMIT_BTN.findElement(driver));
		click(SUBMIT_BTN);
		sleep(2000);
	}
	
	public void openForm(){
		Helper.highLightBtn(driver, NEW_FOOD_BTN.findElement(driver));
		click(NEW_FOOD_BTN);
		sleep(2000);
	}
	
	public void cancelForm() {
		Helper.highLightBtn(driver, CANCEL_BTN.findElement(driver));
		click(CANCEL_BTN);
		sleep(2000);
	}
	
	
	public Boolean isSubmitEnable(){
		if(SUBMIT_BTN.findElement(driver).isEnabled()){
			Helper.highLightButtonTrue(driver, SUBMIT_BTN.findElement(driver));
			return true;
		}
		Helper.highLightButtonFalse(driver, SUBMIT_BTN.findElement(driver));
		return false;
	}

	public String getToasterText(){
		return getText(TOASTER);
	}
	
	public void sortByName() {
		Helper.highLightBtn(driver, NAME_SORT_ICON.findElement(driver));
		click(NAME_SORT_ICON);
		sleep(2000);
	}
	
	public void sortByVendor() {
		Helper.highLightBtn(driver, VENDOR_SORT_ICON.findElement(driver));
		click(VENDOR_SORT_ICON);
		sleep(2000);
	}
	
	public void sortByCategory() {
		Helper.highLightBtn(driver, CATEGORY_SORT_ICON.findElement(driver));
		click(CATEGORY_SORT_ICON);
		sleep(2000);
	}
	
	public String getListRowText() {
		return getText(FOOD_LIST_ROW);
	}
	
	public void openHeader() {
		click(FOOD_LIST_APPLE_DIV);
		sleep(2000);
	}
	
	public void openUpdate(){
		Helper.highLightBtn(driver, UPDATE_BTN.findElement(driver));
		click(UPDATE_BTN);
		sleep(2000);
	}
	
	public void saveUpdate(){
		Helper.highLightBtn(driver, SAVE_BTN.findElement(driver));
		click(SAVE_BTN);
		sleep(2000);
	}
	
	public void fillUpdateForm(String name, String vendor, int category) {
		Helper.highLightInput(driver, UPDATE_NAME_INPUT.findElement(driver));
		sendKeys(UPDATE_NAME_INPUT, name);
		Helper.highLightInput(driver, UPDATE_VENDOR_INPUT.findElement(driver));
		sendKeys(UPDATE_VENDOR_INPUT, vendor);
		Select select = new Select(UPDATE_CATEGORY_SELECT.findElement(driver));
		select.selectByIndex(1);
		sleep(2000);
		
		
	}
}
