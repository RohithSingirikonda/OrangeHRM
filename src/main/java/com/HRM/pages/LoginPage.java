package com.HRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(xpath="//div[@id='divLogo']")
	WebElement logo;
	
	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean ValidateHRMLogo(){
		return logo.isDisplayed();
	}

	public AdminHomePage AdminLogin(String name, String pass){
		userName.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
		
		return new AdminHomePage();
	}
	
	
	public UserHomePage UserLogin(String name, String pass){
		userName.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
		
		return new UserHomePage();
	}
	
	
}
