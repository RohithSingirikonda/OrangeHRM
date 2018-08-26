package com.HRM.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.HRM.base.TestBase;
import com.HRM.util.TestUtil;

public class EducationPage extends TestBase{

	public static String message;

	
	@FindBy(xpath="//div[@id='recordsListDiv']//h1")
	WebElement page_header;
	
	@FindBy(id="saveFormHeading")
	WebElement addEducation_header;
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	@FindBy(id="btnDel")
	WebElement delbtn;
	
	@FindBy(id="education_name")
	WebElement edu_name;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	@FindBy(id="btnCancel")
	WebElement cancelbtn;
	
	@FindBy(xpath="//*[@class='validation-error']")
	WebElement validation_error;
	
	
	public EducationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String EducationPageHeader(){
		return page_header.getText();
	}
		
	public String AddEducationPageHeader(){
		addbtn.click();
		return addEducation_header.getText();
	}
	
	
	public String AddEducation(String education){
		
		addbtn.click();
		edu_name.sendKeys(education);
		savebtn.click();
		
		try {

			if (education.isEmpty()) {
					message = validation_error.getText();
			}else {
				
				List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]")); 
				List<String> temp_data = new ArrayList<>();
				 
				 for(int i=0; i<totalList.size(); i++){
				        temp_data.add(totalList.get(i).getText());
				    }

					if(temp_data.contains(education)){
						WebDriverWait wait = new WebDriverWait(driver, 5);
						WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'message warning fadable')]")));
						message = warning.getText();
					}
					else
						throw new NoSuchElementException();
			}
			
		} catch (NoSuchElementException e) {
			message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
		}
		
		return message;
	}
	
	
	public String DeleteEducation(String education){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]")); 
		List<String> temp_data = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
		        temp_data.add(totalList.get(i).getText());
		    }
		
			if (temp_data.contains(education)) {
				WebElement education_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+education+"']//parent::td//preceding-sibling::td"));
				education_selected.click();
				delbtn.click();
				message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
			} else {
				boolean disable = delbtn.isEnabled();
				Assert.assertFalse(disable);
			}
		
		return message;
	}
	
	
	public String EditEducation(String existing_Education, String updated_Education){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]")); 
		List<String> temp_data = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
		        temp_data.add(totalList.get(i).getText());
		    }
		 
		if (temp_data.contains(existing_Education)) {
				WebElement skill_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+existing_Education+"']"));
				skill_selected.click();
				edu_name.clear();
				edu_name.sendKeys(updated_Education);
				savebtn.click();
				
				if (!updated_Education.isEmpty()){
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				}
				else {
					message = validation_error.getText();	
				}
		}
		return message;
	}
	
	
	
	
}
