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

public class NationalitiesPage extends TestBase {

	public static String message;
	
	@FindBy(xpath="//div[@id='nationalityList']//h1")
	WebElement page_header;
	
	@FindBy(id="nationalityHeading")
	WebElement addNationality_header;
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	@FindBy(id="btnDelete")
	WebElement delbtn;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement cnfmDelBtn;
	
	@FindBy(xpath="//input[@class='btn reset']")
	WebElement cnfmCancelBtn;
	
	@FindBy(id="nationality_name")
	WebElement nationality_name;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	@FindBy(id="btnCancel")
	WebElement cancelbtn;
	
	@FindBy(xpath="//*[@class='validation-error']")
	WebElement validation_error;

	
	public NationalitiesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String NationalitiesPageHeader(){
		return page_header.getText();
	}
		
	public String AddNationalitiesPageHeader(){
		addbtn.click();
		return addNationality_header.getText();
	}
	
	
	public String AddNationality(String nationality){

		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='tableWrapper']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		}
		
		addbtn.click();
		nationality_name.sendKeys(nationality);
		savebtn.click();
		
			if (nationality.isEmpty() || iterator_list.contains(nationality)) {
				message = validation_error.getText();
			}
			else {
				message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
			}
			
		return message;
	}
	
	
	public String DeleteNationality(String nationality, String flag){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='tableWrapper']//tbody//tr//td[2]//a"));
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		 
			if (iterator_list.contains(nationality)) {
				WebElement education_selected = driver.findElement(By.xpath("//*[@id='tableWrapper']//tbody//td[2]//a[text()='"+nationality+"']//parent::td//preceding-sibling::td"));
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

	
	public String EditNationality(String existing_nationality, String updated_nationality){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='tableWrapper']//tbody//tr//td[2]//a")); 
		List<String> iterator_list = new ArrayList<>();
		 
		 for(int i=0; i<totalList.size(); i++){
			 iterator_list.add(totalList.get(i).getText());
		    }
		
		 	if (iterator_list.contains(existing_nationality)) {
				WebElement skill_selected = driver.findElement(By.xpath("//*[@id='resultTable']//tbody//tr//td[2]//a[text()='"+existing_nationality+"']"));
				skill_selected.click();
				try{
					nationality_name.clear();
					throw new InvalidElementStateException();
				}
				catch (InvalidElementStateException e) {
					nationality_name.clear();
					nationality_name.sendKeys(updated_nationality);
					savebtn.click();
				}
				
				
				if (!updated_nationality.isEmpty()){
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				}
				else {
					message = validation_error.getText();
				}
		}
		return message;
	}

	
}
