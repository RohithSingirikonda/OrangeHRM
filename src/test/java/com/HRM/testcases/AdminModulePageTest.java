package com.HRM.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LoginPage;

public class AdminModulePageTest extends TestBase{
	
	LoginPage loginPage;
	AdminModulePage admin_ModulePage;
	AdminHomePage admin_HomePage;
	
	public AdminModulePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_ModulePage = new AdminModulePage();
		admin_HomePage = new AdminHomePage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
	}
	
	
	
	
	
	
	
	  
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
