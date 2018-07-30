package com.HRM.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class JobCategoriesPage extends TestBase{
	
	@FindBy(xpath="//*[@id='search-results']//h1")
	WebElement page_header;
	
	@FindBy(id="btnAdd")
	WebElement btn_add;
	
	@FindBy(id="btnDelete")
	WebElement btn_delete;
	
	@FindBy(id="btnSave")
	WebElement btnSave;
	
	@FindBy(id="btnCancel")
	WebElement btnCancel;
	
	
	
	public JobCategoriesPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String JobCategoriesPageHeader(){
		String header = page_header.getText();
		return header;
	}
	
	public String AddJobCategory(String jobCategory_name){
		
		String message = null;
		btn_add.click();
		
		WebElement add_header = driver.findElement(By.id("jobCategoryHeading"));
		
		if (add_header.isDisplayed()) {
		
			WebElement label = driver.findElement(By.xpath("//*[@id='frmJobCategory']//label"));
			label.isDisplayed();
			
			driver.findElement(By.id("jobCategory_name")).sendKeys(jobCategory_name);
			btnSave.click();
			
			if(jobCategory_name.isEmpty()){
				message = driver.findElement(By.xpath("//form[@id='frmJobCategory']//li//span")).getText();
			}
			else {
				message = driver.findElement(By.xpath("//div[@class='message success fadable']")).getText();	
			}
		} 
		return message;
	}
	
	
	
	
	public String DeleteJobCategory(String empStatus, String validation){
		
		String message = null;
		
		List<WebElement> Titles = driver.findElements(By.xpath("//td[@class='left']//a"));
		
		for (int i = 0; i < Titles.size(); i++) {
			
			String text = Titles.get(i).getText();
			
			if (text.equals(empStatus)) {
					driver.findElement(By.xpath("//a[contains(text(),'"+ text +"')]//parent::td[@class='left']//preceding-sibling::td//input")).click();
					btn_delete.click();
					
					if (validation.equals("TRUE")) {
						driver.findElement(By.xpath("//*[@id='deleteConfModal']//*[@class='modal-footer']//input[@value='Ok']")).click();
						
						message = driver.findElement(By.xpath("//div[@class='message success fadable']")).getText();	
						
					} else {
						driver.findElement(By.xpath("//*[@id='deleteConfModal']//*[@class='modal-footer']//input[@value='Cancel']")).click();
					}
			}
		}
		
		return message;	
		
	}


}
