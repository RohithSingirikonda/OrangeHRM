package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class UsersPage extends TestBase {

	

	@FindBy(id="btnAdd")
	WebElement addBtn;
	
	
	@FindBy(id="btnDelete")
	WebElement deleteBtn;
	
	
	@FindBy(xpath="//input[@type='checkbox' and @name='chkSelectRow[]']")
	WebElement chkBox; 
	
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public AddUserPage ClickOnAddRole(){
		addBtn.click();
		return new AddUserPage();
	}
	
	public boolean ClickOnDeleteRole(){
		deleteBtn.click();
		return chkBox.isSelected();
	}
	
	
	public void getUsersRoleData(){
		
		 for(WebElement tdata:driver.findElements(By.tagName("tr")))
	        {
	        	System.out.print(tdata.getText());
	        	System.out.println("\n");
	        }
		
	}


	
}
