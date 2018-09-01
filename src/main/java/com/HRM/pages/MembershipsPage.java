package com.HRM.pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRM.base.TestBase;

public class MembershipsPage extends TestBase {
	
	public static String message;
	
	@FindBy(xpath="//div[@id='membershipList']//h1")
	WebElement page_header;
	
	@FindBy(id="membershipHeading")
	WebElement addMembership_header;
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	@FindBy(id="btnDelete")
	WebElement delbtn;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement cnfmDelBtn;
	
	@FindBy(xpath="//input[@class='btn reset']")
	WebElement cnfmCancelBtn;
	
	@FindBy(id="membership_name")
	WebElement membership_name;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	@FindBy(id="btnCancel")
	WebElement cancelbtn;
	
	@FindBy(xpath="//*[@class='validation-error']")
	WebElement validation_error;

	
	public MembershipsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String MembershipsPageHeader(){
		return page_header.getText();
	}
		
	public String AddMembershipsPageHeader(){
		addbtn.click();
		return addMembership_header.getText();
	}
	
	
	public String AddMembership(String membership){

		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='tableWrapper']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		}
		
		addbtn.click();
		membership_name.sendKeys(membership);
		savebtn.click();
		
			if (membership.isEmpty() || iterator_list.contains(membership)) {
				message = validation_error.getText();
			}
			else {
				message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
			}
			
		return message;
	}
	
	
	
	public String DeleteMembership(String membership, String flag){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='tableWrapper']//tbody//tr//td[2]//a"));
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		 
			if (iterator_list.contains(membership)) {
				WebElement education_selected = driver.findElement(By.xpath("//*[@id='tableWrapper']//tbody//td[2]//a[text()='"+membership+"']//parent::td//preceding-sibling::td"));
				education_selected.click();
				delbtn.click();
				
				if (flag.contains("true") || flag.contains("TRUE")) {
					assertTrue(driver.findElement(By.id("deleteConfModal")).isDisplayed());
					assertTrue(driver.findElement(By.xpath("//div[@id='deleteConfModal']//div[@class='modal-header']//h3")).isDisplayed());
					assertTrue(driver.findElement(By.xpath("//div[@id='deleteConfModal']//div[@class='modal-body']//p")).isDisplayed());
					cnfmDelBtn.click();
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				} else {
					cnfmCancelBtn.click();
				}
			} else {
				boolean disable = delbtn.isEnabled();
				Assert.assertFalse(disable);
			}
		
		return message;
	}


	public String EditMembership(String existing_membership, String updated_membership){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='tableWrapper']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		
		 	if (iterator_list.contains(existing_membership)) {
				WebElement skill_selected = driver.findElement(By.xpath("//*[@id='resultTable']//tbody//tr//td[2]//a[text()='"+existing_membership+"']"));
				skill_selected.click();
				try{
					membership_name.clear();
					throw new InvalidElementStateException();
				}
				catch (InvalidElementStateException e) {
					membership_name.clear();
					membership_name.sendKeys(updated_membership);
					savebtn.click();
				}
				
				
				if (!updated_membership.isEmpty()){
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				}
				else {
					message = validation_error.getText();
				}
		}
		return message;
	}

	
	

}
