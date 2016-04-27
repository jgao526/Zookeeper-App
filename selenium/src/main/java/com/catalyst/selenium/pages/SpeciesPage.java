package com.catalyst.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.selenium.framework.PageObject;
import com.catalyst.selenium.helper.Helper;

public class SpeciesPage extends PageObject{

	private static final By NEW_SPECIES_BTN = By.id("newBtn");
	private static final By NEW_SPECIES_COMMON_NAME = By.id("speciesCommonName");
	private static final By NEW_SPECIES_SCIENTIFIC_NAME = By.id("speciesScientificName");
	private static final By NEW_SPECIES_INFO_LINK = By.id("speciesInfoLink");
	private static final By NEW_SPECIES_FOOD_CATEGORY = By.id("foodDropDown");
	private static final By SUBMIT_BTN = By.id("submitBtn");
	private static final By CANCEL_BTN = By.id("cancelBtn");
	private static final By TOASTER = By.xpath("//div[@class='ng-binding toast-title']");
	private static final By SPECIES_LIST_ROW = By.xpath("//div[@class='row rowHeader ng-scope']");
	private static final By SPECIES_LIST_FIRST_DIV = By.xpath("//div[@class='col-xs-4 ng-binding' and contains(text(),'White Rhino')]");
	private static final By UPDATE_BTN = By.xpath("(//button[@class='btn btn-success updateBtn'])[1]");
	private static final By SAVE_BTN = By.xpath("(//button[@class='btn btn-primary pull-right saveBtn'])[1]");
	private static final By UPDATE_COMMON_NAME_INPUT = By.xpath("(//input[@name='updateCommonName'])[1]");
	private static final By UPDATE_SCIENTIFIC_NAME_INPUT = By.xpath("(//input[@name='updateScientificName'])[1]");
	private static final By UPDATE_INFO_LINK = By.xpath("(//input[@name='updateInfoLink'])[1]");
	private static final By UPDATE_FAVORITE_FOOD = By.xpath("(//select[@name='updateFavFoodDropDown'])[1]");
	private static final By COMMON_NAME_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='commonName']/a/span[@class='glyphicon glyphicon-sort']");
	private static final By SCIENTIFIC_COMMON_NAME_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='scientificName']/a/span[@class='glyphicon glyphicon-sort']");
	private static final By FAVORITE_FOOD_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='favorFood']/a/span[@class='glyphicon glyphicon-sort']");
	
	public SpeciesPage(WebDriver driver) {
		super(driver);
		url="http://localhost:8080/#/species";
		goTo(url);
		sleep(2000);
	}
	
	
	
	public void fillNewSpeciesFormInput(String commonName, String scientificName, String infoLink){
		Helper.highLightInput(driver, NEW_SPECIES_COMMON_NAME.findElement(driver));
		sendKeys(NEW_SPECIES_COMMON_NAME, commonName);
		Helper.highLightInput(driver, NEW_SPECIES_SCIENTIFIC_NAME.findElement(driver));
		sendKeys(NEW_SPECIES_SCIENTIFIC_NAME, scientificName);
		Helper.highLightInput(driver, NEW_SPECIES_INFO_LINK.findElement(driver));
		sendKeys(NEW_SPECIES_INFO_LINK, infoLink);
		sleep(2000);
	}
	
	
	public void fillNewSpeciesForm(String commonName, String scientificName, String infoLink, int favFood){
		Helper.highLightInput(driver, NEW_SPECIES_COMMON_NAME.findElement(driver));
		sendKeys(NEW_SPECIES_COMMON_NAME, commonName);
		Helper.highLightInput(driver, NEW_SPECIES_SCIENTIFIC_NAME.findElement(driver));
		sendKeys(NEW_SPECIES_SCIENTIFIC_NAME, scientificName);
		Helper.highLightInput(driver, NEW_SPECIES_INFO_LINK.findElement(driver));
		sendKeys(NEW_SPECIES_INFO_LINK, infoLink);
		Select select = new Select(NEW_SPECIES_FOOD_CATEGORY.findElement(driver));
		select.selectByIndex(favFood);
		sleep(2000);
	}
	
	public void submitForm() {
		Helper.highLightBtn(driver, SUBMIT_BTN.findElement(driver));
		click(SUBMIT_BTN);
		sleep(2000);
	}
	
	public SpeciesPage openForm(){
		waitForElementToExist(NEW_SPECIES_BTN);
		Helper.highLightBtn(driver, NEW_SPECIES_BTN.findElement(driver));
		click(NEW_SPECIES_BTN);
		return this;
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
	
	public void sortByCommonName() {
		Helper.highLightBtn(driver, COMMON_NAME_SORT_ICON.findElement(driver));
		click(COMMON_NAME_SORT_ICON);
		sleep(2000);
	}
	
	public void sortByScientific() {
		Helper.highLightBtn(driver, SCIENTIFIC_COMMON_NAME_SORT_ICON.findElement(driver));
		click(SCIENTIFIC_COMMON_NAME_SORT_ICON);
		sleep(2000);
	}
	
	public void sortByFavFood() {
		Helper.highLightBtn(driver, FAVORITE_FOOD_SORT_ICON.findElement(driver));
		click(FAVORITE_FOOD_SORT_ICON);
		sleep(2000);
	}
	
	public String getListRowText() {
		return getText(SPECIES_LIST_ROW);
	}
	
	public void openHeader() {
		click(SPECIES_LIST_FIRST_DIV);
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
	
	public void fillUpdateForm(String commonName, String scientificName, String infoLink, int favFood) {
		Helper.highLightInput(driver, UPDATE_COMMON_NAME_INPUT.findElement(driver));
		sendKeys(UPDATE_COMMON_NAME_INPUT, commonName);
		Helper.highLightInput(driver, UPDATE_SCIENTIFIC_NAME_INPUT.findElement(driver));
		sendKeys(UPDATE_SCIENTIFIC_NAME_INPUT, scientificName);
		Helper.highLightInput(driver, UPDATE_INFO_LINK.findElement(driver));
		sendKeys(UPDATE_INFO_LINK, infoLink);
		Select select = new Select(UPDATE_FAVORITE_FOOD.findElement(driver));
		select.selectByIndex(favFood);
		sleep(2000);
		
		
	}

	
}
