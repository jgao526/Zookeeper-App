package com.catalyst.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.selenium.framework.PageObject;
import com.catalyst.selenium.helper.Helper;

public class AnimalPage extends PageObject{


		private static final By NEW_ANIMAL_BTN = By.id("newBtn");
		private static final By NEW_ANIMAL_NAME = By.id("animalName");
		private static final By NEW_ANIMAL_SPECIES = By.id("speciesDropDown");
		private static final By NEW_ANIMAL_ENCLOSURE = By.id("enclosureDropDown");
		private static final By SUBMIT_BTN = By.id("submitBtn");
		private static final By CANCEL_BTN = By.id("cancelBtn");
		private static final By TOASTER = By.xpath("//div[@class='ng-binding toast-title']");
		private static final By ANIMAL_LIST_ROW = By.xpath("//div[@class='row rowHeader ng-scope']");
		private static final By ANIMAL_LIST_FIRST_DIV = By.xpath("//div[@class='col-xs-3 ng-binding' and contains(text(),'Snowball')]");
		private static final By UPDATE_BTN = By.xpath("(//button[@class='btn btn-success updateBtn ng-scope'])[1]");
		private static final By SAVE_BTN = By.xpath("(//button[@class='btn btn-primary pull-right saveBtn'])[1]");
		private static final By UPDATE_NAME_INPUT = By.xpath("(//input[@name='updateName'])[1]");
		private static final By UPDATE_SPECIES_SELECT = By.xpath("(//select[@name='updateSpeciesDropDown'])[1]");
		private static final By UPDATE_ENCLOSURE_SELECT = By.xpath("(//select[@name='updateEnclosureDropDown'])[1]");
		private static final By NAME_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='name']/a/span[@class='glyphicon glyphicon-sort']");
		private static final By SPECIES_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='species']/a/span[@class='glyphicon glyphicon-sort']");
		private static final By FAVORITE_FOOD_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='favorFood']/a/span[@class='glyphicon glyphicon-sort']");
		private static final By ENCLCOSURE_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='enclosure']/a/span[@class='glyphicon glyphicon-sort']");
		
		public AnimalPage(WebDriver driver) {
			super(driver);
			url="http://localhost:8080/#/animal";
			goTo(url);
			sleep(2000);
		}
		
		
		
		public void fillNewAnimalFormInput(String name){
			Helper.highLightInput(driver, NEW_ANIMAL_NAME.findElement(driver));
			sendKeys(NEW_ANIMAL_NAME, name);
			sleep(2000);
		}
		
		
		public void fillNewAnimalForm(String name, int species, int enclosure){
			Helper.highLightInput(driver, NEW_ANIMAL_NAME.findElement(driver));
			sendKeys(NEW_ANIMAL_NAME, name);
			Select selectSpecies = new Select(NEW_ANIMAL_SPECIES.findElement(driver));
			selectSpecies.selectByIndex(species);
			Select selectEnclosure = new Select(NEW_ANIMAL_ENCLOSURE.findElement(driver));
			selectEnclosure.selectByIndex(enclosure);
			sleep(2000);
		}
		
		public void submitForm() {
			Helper.highLightBtn(driver, SUBMIT_BTN.findElement(driver));
			click(SUBMIT_BTN);
			sleep(2000);
		}
		
		public void openForm(){
			Helper.highLightBtn(driver, NEW_ANIMAL_BTN.findElement(driver));
			click(NEW_ANIMAL_BTN);
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
		
		public void sortBySpecies() {
			Helper.highLightBtn(driver, SPECIES_SORT_ICON.findElement(driver));
			click(SPECIES_SORT_ICON);
			sleep(2000);
		}
		
		public void sortByFavoriteFood() {
			Helper.highLightBtn(driver, FAVORITE_FOOD_SORT_ICON.findElement(driver));
			click(FAVORITE_FOOD_SORT_ICON);
			sleep(2000);
		}
		
		public void sortByEnclosure() {
			Helper.highLightBtn(driver, ENCLCOSURE_SORT_ICON.findElement(driver));
			click(ENCLCOSURE_SORT_ICON);
			sleep(2000);
		}
		
		public String getListRowText() {
			return getText(ANIMAL_LIST_ROW);
		}
		
		public void openHeader() {
			click(ANIMAL_LIST_FIRST_DIV);
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
		
		public void fillUpdateForm(String name, int species, int enclosure) {
			Helper.highLightInput(driver, UPDATE_NAME_INPUT.findElement(driver));
			sendKeys(UPDATE_NAME_INPUT, name);
			Select selectSpecies = new Select(UPDATE_SPECIES_SELECT.findElement(driver));
			selectSpecies.selectByIndex(species);
			Select selectEnclosure = new Select(UPDATE_ENCLOSURE_SELECT.findElement(driver));
			selectEnclosure.selectByIndex(enclosure);
			sleep(2000);
			
		}
	

}
