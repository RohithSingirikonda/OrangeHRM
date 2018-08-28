package com.HRM.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRM.base.TestBase;

public class LanguagePage extends TestBase{
	
	public static String message;
	
	@FindBy(xpath="//div[@id='recordsListDiv']//h1")
	WebElement page_header;
	
	@FindBy(id="saveFormHeading")
	WebElement addLanguage_header;
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	@FindBy(id="btnDel")
	WebElement delbtn;
	
	@FindBy(id="language_name")
	WebElement language_name;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	@FindBy(id="btnCancel")
	WebElement cancelbtn;
	
	@FindBy(xpath="//*[@class='validation-error']")
	WebElement validation_error;
	
	
	public LanguagePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String LanguagePageHeader(){
		return page_header.getText();
	}
		
	public String AddLanguagePageHeader(){
		addbtn.click();
		return addLanguage_header.getText();
	}
	
	public String AddLanguage(String lang){

		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		

		addbtn.click();
		language_name.sendKeys(lang);
		savebtn.click();
		
			if (lang.isEmpty()) {
				message = validation_error.getText();
			}
			else if(iterator_list.contains(lang)){
				message = driver.findElement(By.xpath("//div[contains(@class, 'message warning fadable')]")).getText();
			}
			else {
				message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
			}
			
		
		return message;
	}

	public String DeleteLanguage(String lang){
			
			List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a"));
			List<String> iterator_list = new ArrayList<>();
			 
			 for(int i=0; i<totalList.size(); i++){
				 iterator_list.add(totalList.get(i).getText());
			    }
			 
				if (iterator_list.contains(lang)) {
					WebElement education_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+lang+"']//parent::td//preceding-sibling::td"));
					education_selected.click();
					delbtn.click();
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				} else {
					boolean disable = delbtn.isEnabled();
					Assert.assertFalse(disable);
				}
			
			return message;
		}


	public String EditLanguage(String existing_language, String updated_language){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		
		 	if (iterator_list.contains(existing_language)) {
				WebElement skill_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+existing_language+"']"));
				skill_selected.click();
				language_name.clear();
				language_name.sendKeys(updated_language);
				savebtn.click();
				
				if (!updated_language.isEmpty()){
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				}
				else {
					message = validation_error.getText();	
				}
		}
		return message;
	}

}

