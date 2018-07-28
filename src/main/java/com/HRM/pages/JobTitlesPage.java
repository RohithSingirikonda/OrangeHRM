package com.HRM.pages;

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
	
	
	public void DeleteJobTitles(){
				
			
	}
	
	

}
