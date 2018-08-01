package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRM.base.TestBase;

public class GeneralInformationPage extends TestBase {

	@FindBy(id="btnSaveGenInfo")
	WebElement saveBtn;

	
	public GeneralInformationPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String GenInfoPageHeader(){
		String page_header = driver.findElement(By.id("genInfoHeading")).getText();
		return page_header;
	}

	
	public String GenInfoPageValidation(String OrgName, String TaxId, String RegNo, String Phone, String Fax, String Email,
							String Address1, String Address2, String City, String State, String Zipcode, String Country, String Note){
		
		String message = null;
		WebElement org_name = driver.findElement(By.id("organization_name"));
		
		if (!org_name.isEnabled()) {
		
			saveBtn.click();
			
			
			org_name.clear();
			org_name.sendKeys(OrgName);
			driver.findElement(By.id("organization_taxId")).sendKeys(TaxId);
			driver.findElement(By.id("organization_registraionNumber")).sendKeys(RegNo);
			driver.findElement(By.id("organization_phone")).sendKeys(Phone);
			driver.findElement(By.id("organization_fax")).sendKeys(Fax);
			driver.findElement(By.id("organization_email")).sendKeys(Email);
			driver.findElement(By.id("organization_street1")).sendKeys(Address1);
			driver.findElement(By.id("organization_street2")).sendKeys(Address2);
			driver.findElement(By.id("organization_city")).sendKeys(City);
			driver.findElement(By.id("organization_province")).sendKeys(State);
			driver.findElement(By.id("organization_zipCode")).sendKeys(Zipcode);
			//Select select = new Select(driver.findElement(By.name("organization[country]")));
			//select.selectByVisibleText(Country);
			driver.findElement(By.id("organization_note")).sendKeys(OrgName);
			
			
			if (!org_name.equals(null) || !org_name.equals("")) {
				message = driver.findElement(By.xpath("//*[@id='frmGenInfo']//span[@for='organization_name']")).getText();
			} else {
				message = driver.findElement(By.xpath("//div[@class='message success fadable']")).getText();
			}
		}
		
		return message;
		
	}
	
	
	
}
