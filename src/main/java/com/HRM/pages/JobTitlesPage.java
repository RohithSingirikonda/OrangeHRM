package com.HRM.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class JobTitlesPage extends TestBase {
	
	
	@FindBy(xpath="//*[@class='head']//h1")
	WebElement page_header;
	
	@FindBy(id="btnAdd")
	WebElement btn_add;
	
	@FindBy(id="btnDelete")
	WebElement btn_delete;
	
	
	public JobTitlesPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String JobTitlesPageHeader(){
		String header = page_header.getText();
		return header;
	}
	
	
	public AddJobTitlePage AddJobTitles(){
		btn_add.click();
		return new AddJobTitlePage();	
	}
	
	
	public String DeleteJobTitles(String JobTitle, String validation){
		
		String message = null;
		List<WebElement> Titles = driver.findElements(By.xpath("//td[@class='left']//a"));
		
		for (int i = 0; i < Titles.size(); i++) {
			
			message = Titles.get(i).getText();
			
			if (message.equals(JobTitle)) {
					driver.findElement(By.xpath("//a[contains(text(),'"+ JobTitle +"')]//parent::td[@class='left']//preceding-sibling::td//input")).click();
					btn_delete.click();
					
					if (validation.equals("TRUE")) {
						driver.findElement(By.xpath("//*[@id='deleteConfModal']//*[@class='modal-footer']//input[@value='Ok']")).click();
						message = driver.findElement(By.xpath("//div[@class='message success fadable']")).getText();	
						break;
						
					} else {
						driver.findElement(By.xpath("//*[@id='deleteConfModal']//*[@class='modal-footer']//input[@value='Cancel']")).click();
						break;
					}
			}
		}
		return message;
			
	}
	
	

}
