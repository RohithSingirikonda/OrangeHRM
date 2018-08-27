package com.HRM.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRM.base.TestBase;

public class LicensesPage extends TestBase{
	
	public static String message;
	
	@FindBy(xpath="//div[@id='recordsListDiv']//h1")
	WebElement page_header;
	
	@FindBy(id="saveFormHeading")
	WebElement addLicenses_header;
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	@FindBy(id="btnDel")
	WebElement delbtn;
	
	@FindBy(id="license_name")
	WebElement license_name;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	@FindBy(id="btnCancel")
	WebElement cancelbtn;
	
	@FindBy(xpath="//*[@class='validation-error']")
	WebElement validation_error;
	
	public LicensesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String LicensesPageHeader(){
		return page_header.getText();
	}
		
	public String AddLicensesPageHeader(){
		addbtn.click();
		return addLicenses_header.getText();
	}
	
	public String AddLicense(String license){

		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		

		addbtn.click();
		license_name.sendKeys(license);
		savebtn.click();
		
			if (license.isEmpty()) {
				message = validation_error.getText();
			}
			else if(iterator_list.contains(license)){
				message = driver.findElement(By.xpath("//div[contains(@class, 'message warning fadable')]")).getText();
			}
			else {
				message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
			}
			
		
		return message;
	}
	
	
	public String DeleteLicense(String license){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a"));
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		 
			if (iterator_list.contains(license)) {
				WebElement education_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+license+"']//parent::td//preceding-sibling::td"));
				education_selected.click();
				delbtn.click();
				message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
			} else {
				boolean disable = delbtn.isEnabled();
				Assert.assertFalse(disable);
			}
		
		return message;
	}
	
	
public String EditLicense(String existing_license, String updated_license){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		
		 	if (iterator_list.contains(existing_license)) {
				WebElement skill_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+existing_license+"']"));
				skill_selected.click();
				license_name.clear();
				license_name.sendKeys(updated_license);
				savebtn.click();
				
				if (!updated_license.isEmpty()){
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				}
				else {
					message = validation_error.getText();	
				}
		}
		return message;
	}
	
	
	

}
