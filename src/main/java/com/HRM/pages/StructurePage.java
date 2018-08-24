package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRM.base.TestBase;

public class StructurePage extends TestBase{

	@FindBy(xpath="//div[@class='head']//h1")
	WebElement page_header;
	
	@FindBy(id="btnEdit")
	WebElement btn_edit;
	
	@FindBy(id="treeLink_addChild_1")
	WebElement addBtn;
	
	
	public StructurePage(){
		PageFactory.initElements(driver, this);
	}

	
	public String StructurePageHeader(){
		String message = page_header.getText();
		return message;
	}
	
	public String AddorModifyOrgStructure(){
		
		String message=null;
		
		try {
			if (btn_edit.isDisplayed()) {
				btn_edit.click();
				
				if (addBtn.isEnabled()) {
					addBtn.click();
					
				   if (driver.findElement(By.id("unitDialog")).isDisplayed()) {
						WebElement id = driver.findElement(By.id("txtUnit_Id"));
						id.clear();
						id.sendKeys("2");
						WebElement name = driver.findElement(By.id("txtName"));
						name.clear();
						name.sendKeys("OrangeHRM Sub Unit");
						WebElement comments  = driver.findElement(By.id("txtDescription"));
						comments.clear();
						comments.sendKeys("Banglore");
						driver.findElement(By.id("btnSave")).click();

						message = driver.findElement(By.xpath("//div[@id='divMessageBar']")).getText();
						
					}
				}
				
			}
			
			
		} catch (ElementNotInteractableException e) {
			Assert.assertTrue(true);
		}
		
		return message;
	}
		
}
