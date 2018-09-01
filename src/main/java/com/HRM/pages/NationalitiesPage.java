package com.HRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(id="membership_name")
	WebElement membership_name;
	
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
	
	
}
