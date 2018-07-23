package com.HRM.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;


public class AdminModulePage extends TestBase{

	
	Actions action = new Actions(driver);
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement AdminBtn;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement UserMgmtBtn;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement UsersBtn;
	
	
	public AdminModulePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String AdminPageHeader(){
		return driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
	}
	
		
	public UsersPage ClickonUsersMenu(){
		action.moveToElement(AdminBtn).moveToElement(UserMgmtBtn).moveToElement(UsersBtn).click().build().perform();
		return new UsersPage();
	}
	

	
}
