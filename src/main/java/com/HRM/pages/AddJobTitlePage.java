package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class AddJobTitlePage extends TestBase{

	@FindBy(id="saveHobTitleHeading")
	WebElement page_header;
	
	@FindBy(xpath="//label[@for='jobTitle_jobTitle']")
	WebElement label_JobTitle;
	
	@FindBy(id="jobTitle_jobTitle")
	WebElement input_JobTitle;

	@FindBy(xpath="//label[@for='jobTitle_jobDescription']")
	WebElement label_JobDesc;
	
	@FindBy(id="jobTitle_jobDescription")
	WebElement input_JobDesc;
		
	@FindBy(xpath="//label[@for='jobTitle_jobSpec']")
	WebElement label_JobSpec;
	
	@FindBy(id="jobTitle_jobSpec")
	WebElement input_JobSpec;

	@FindBy(xpath="//label[@for='jobTitle_note']")
	WebElement label_Note;
	
	@FindBy(id="jobTitle_note")
	WebElement input_JobNote;
	
	@FindBy(id="btnSave")
	WebElement btn_Save;
	
	@FindBy(id="btnCancel")
	WebElement btn_Cancel;

	
	public AddJobTitlePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String AddJobTitlesPageHeader(){
		String header = page_header.getText();
		return header;
	}
	
	
	public String[] PageLables(){
		
		String label[] = new String[4];
		label[0]=label_JobTitle.getText();
		label[1]=label_JobDesc.getText();
		label[2]=label_JobSpec.getText();
		label[3]=label_Note.getText();
		
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
	
	
	public String InsertTitleData(String JobTitle, String JobDesc, String JobNote){
		
				String message = null;
		
				input_JobTitle.clear();
				input_JobTitle.sendKeys(JobTitle);
				input_JobDesc.clear();
				input_JobDesc.sendKeys(JobDesc);
					//input_JobSpec.sendKeys(JobSpec);
				input_JobNote.clear();
				input_JobNote.sendKeys(JobNote);
				ClickOnSaveBtn();
				
			
				if (JobTitle.isEmpty()) {
					message = driver.findElement(By.xpath("//form[@id='frmSavejobTitle']//li//span")).getText();
					return message;
				}
				else {
					message = null;
					return message;
				}
				
				
				
	}
	
}
