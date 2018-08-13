package com.HRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class AddLocationPage extends TestBase{

	
	public String message = null;
	
	@FindBy(id="locationHeading")
	WebElement page_header;
	
	@FindBy(id="location_name")
	WebElement location_name;
	
	@FindBy(id="location_country")
	WebElement location_country;
	
	@FindBy(id="location_province")
	WebElement location_province;
	
	@FindBy(id="location_city")
	WebElement location_city;
	
	@FindBy(id="location_address")
	WebElement location_address;
	
	@FindBy(id="location_zipCode")
	WebElement location_zipCode;
	
	@FindBy(id="location_phone")
	WebElement location_phone;
	
	@FindBy(id="location_fax")
	WebElement location_fax;
	
	@FindBy(id="location_notes")
	WebElement location_notes;
	
	@FindBy(id="btnSave")
	WebElement btnSave;
	
	@FindBy(id="btnCancel")
	WebElement btnCancel;
	
	public AddLocationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String AddLocationPageHeader(){
		return page_header.getText();
	}
	
	
	public String AddLocations(String locations, String country, String state, String city, String address, String pincode,
								String phone, String fax, String Notes){
		
	
	
		
		
		
		return message;
	}
	
	
	
	
	
	
	
}
