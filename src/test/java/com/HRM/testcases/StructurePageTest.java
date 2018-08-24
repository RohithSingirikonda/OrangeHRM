package com.HRM.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.StructurePage;

public class StructurePageTest extends TestBase{
	
	
	String actual_message;
	
	LoginPage loginPage;
	AdminHomePage adminHomePage;
	AdminModulePage adminModulePage;
	StructurePage structurePage;
	
	public StructurePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminModulePage =  new AdminModulePage();
		structurePage = new StructurePage();
		loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		adminModulePage.ClickonStructureMenu();
	}
	
	
	@Test(priority=1, enabled=false)
	public void VerifyStructurePageHeaderTest(){
		actual_message = structurePage.StructurePageHeader();
		Assert.assertEquals(actual_message, "Organization Structure");
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyModifyOrgStructureTest(){
		actual_message = structurePage.ModifyOrgStructure();
		assertTrue(actual_message.contains("Successfully Saved"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
	
}
