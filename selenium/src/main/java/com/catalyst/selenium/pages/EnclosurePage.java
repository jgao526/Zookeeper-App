package com.catalyst.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.catalyst.selenium.framework.PageObject;
import com.catalyst.selenium.helper.Helper;

public class EnclosurePage extends PageObject {
	private static final By NEW_ENCLOSURE_BTN = By.id("newBtn");
	private static final By NEW_ENCLOSURE_NAME_FIELD = By.id("enclosureName");
	private static final By NEW_ENCLOSURE_CONDITION_FIELD = By.id("enclosureCondition");
	private static final By NEW_ENCLOSURE_EFT_HOUR = By.xpath("(//td[@class='form-group uib-time hours']/input[@class='form-control text-center ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength'])[1]");
	private static final By NEW_ENCLOSURE_lFT_HOUR = By.xpath("(//td[@class='form-group uib-time hours']/input[@class='form-control text-center ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength'])[1]");
	private static final By SUBMIT_BTN = By.id("submitBtn");
	private static final By CANCEL_BTN = By.id("cancelBtn");
	private static final By TOASTER = By.xpath("//div[@class='ng-binding toast-title']");
	private static final By ENCLOSURE_LIST_ROW = By.xpath("//div[@class='row rowHeader ng-scope']");
	private static final By NAME_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='name']/a/span[@class='glyphicon glyphicon-sort']");
	private static final By ANIMAL_TOTAL_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='animalTotal']/a/span[@class='glyphicon glyphicon-sort']");
	private static final By CONDITION_SORT_ICON = By.xpath("//div[@class='row tableHeader ng-scope']/div[@id='condition']/a/span[@class='glyphicon glyphicon-sort']");
	
	public EnclosurePage(WebDriver driver) {
		super(driver);
		url="http://localhost:8080/#/enclosure";
		goTo(url);
		sleep(2000);
	}
	
	
	
	public void fillNewEnclosureFormInput(String name, String condition){
		Helper.highLightInput(driver, NEW_ENCLOSURE_NAME_FIELD.findElement(driver));
		sendKeys(NEW_ENCLOSURE_NAME_FIELD, name);
		Helper.highLightInput(driver, NEW_ENCLOSURE_CONDITION_FIELD.findElement(driver));
		sendKeys(NEW_ENCLOSURE_CONDITION_FIELD, condition);
		sleep(2000);
	}
	
	
	public void fillNewEnclosureForm(String name, String condition, String eft, String lft){
		Helper.highLightInput(driver, NEW_ENCLOSURE_NAME_FIELD.findElement(driver));
		sendKeys(NEW_ENCLOSURE_NAME_FIELD, name);
		Helper.highLightInput(driver, NEW_ENCLOSURE_CONDITION_FIELD.findElement(driver));
		sendKeys(NEW_ENCLOSURE_CONDITION_FIELD, condition);
		Helper.highLightInput(driver, NEW_ENCLOSURE_EFT_HOUR.findElement(driver));
		sendKeys(NEW_ENCLOSURE_EFT_HOUR, eft);
		Helper.highLightInput(driver, NEW_ENCLOSURE_lFT_HOUR.findElement(driver));
		sendKeys(NEW_ENCLOSURE_lFT_HOUR, lft);
		sleep(2000);
	}
	
	public EnclosurePage submitForm() {
		Helper.highLightBtn(driver, SUBMIT_BTN.findElement(driver));
		click(SUBMIT_BTN);
		sleep(2000);
		return new EnclosurePage(driver);
	}
	
	public void openForm(){
		Helper.highLightBtn(driver, NEW_ENCLOSURE_BTN.findElement(driver));
		click(NEW_ENCLOSURE_BTN);
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
	
	public void sortByAnimalTotal() {
		Helper.highLightBtn(driver, ANIMAL_TOTAL_SORT_ICON.findElement(driver));
		click(ANIMAL_TOTAL_SORT_ICON);
		sleep(2000);
	}
	
	public void sortByCondition() {
		Helper.highLightBtn(driver, CONDITION_SORT_ICON.findElement(driver));
		click(CONDITION_SORT_ICON);
		sleep(2000);
	}
	
	public String getListRowText() {
		return getText(ENCLOSURE_LIST_ROW);
	}
	


}
