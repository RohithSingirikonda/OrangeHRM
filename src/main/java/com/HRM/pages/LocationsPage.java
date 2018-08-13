package com.HRM.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class LocationsPage extends TestBase{

	
	@FindBy(id="searchLocationHeading")
	WebElement page_header;
	
	@FindBy(id="btnAdd")
	WebElement add_btn;
	
	@FindBy(id="btnDelete")
	WebElement delete_btn;
	
	
	
	
	
	public LocationsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String LocationsPageHeader(){
		String header = page_header.getText();
		return header;
	}
	
	
	
	public AddLocationPage AddLocations(){
		add_btn.click();
		return new AddLocationPage();
	}
	
	
	
	public String DeleteLocations(String location, String validation){
		
		String message = null;
		List<WebElement> Titles = driver.findElements(By.xpath("//td[@class='left']//a"));
		
		for (int i = 0; i <Titles.size(); i++) {
			message=Titles.get(i).getText();
			
				if(message.equals(location)) {
					driver.findElement(By.xpath("//a[contains(text(),'"+ location +"')]//parent::td[@class='left']//preceding-sibling::td//input")).click();
					delete_btn.click();
					
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
