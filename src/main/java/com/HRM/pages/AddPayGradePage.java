package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class AddPayGradePage extends TestBase{

	@FindBy(id="payGradeHeading")
	WebElement page_header;
	
	@FindBy(xpath="//label[@for='payGrade_name']")
	WebElement label_JobTitle;
	
	@FindBy(id="payGrade_name")
	WebElement input_payGrade;
	
	@FindBy(id="btnSave")
	WebElement btn_Save;
	
	@FindBy(id="btnCancel")
	WebElement btn_Cancel;

	
	public AddPayGradePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String AddPayGradePageHeader(){
		String header = page_header.getText();
		return header;
	}
	
	public String[] PageLables(){
		
		String label[] = new String[1];
		label[0]=label_JobTitle.getText();
	
		return label;
	}
	
	
	public JobTitlesPage ClickOnSaveBtn(){
		btn_Save.click();
		return new JobTitlesPage();
	}
	
	public JobTitlesPage ClickOnCancelBtn(){
		btn_Cancel.click();	
		return new JobTitlesPage();
	}
	
	
	
	public String InsertGradeData(String payGrade){
		
		String message = null;

		input_payGrade.clear();
		input_payGrade.sendKeys(payGrade);
		ClickOnSaveBtn();
		
		if (payGrade.isEmpty()) {
			message = driver.findElement(By.xpath("//form[@id='frmPayGrade']//li//span")).getText();
			return message;
		}
		else {
			message = null;
			return message;
		}	
	}	
	
	
	
}
