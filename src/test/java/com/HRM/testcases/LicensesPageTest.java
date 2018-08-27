package com.HRM.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LicensesPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class LicensesPageTest extends TestBase{

public String actual_message;
	
	LoginPage loginPage;
	AdminModulePage adminModulePage;
	LicensesPage licensesPage;
	
	public LicensesPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminModulePage  = new AdminModulePage();
		licensesPage =  new LicensesPage();
		loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		licensesPage = adminModulePage.ClickonLicensesMenu();
	}
	
	@Test(priority=1, enabled=true)
	public void VerifylicensesPageHeaderTest(){
		actual_message = licensesPage.LicensesPageHeader();
		Assert.assertEquals(actual_message, "Licenses");
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyAddlicensesPageHeaderTest(){
		actual_message = licensesPage.AddLicensesPageHeader();
		Assert.assertEquals(actual_message, "Add License");
	}
	
	
	@DataProvider(name = "AddLicense")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData("AddLicense");
		return data;
	}
	
	
	@Test(dataProvider="AddLicense", priority=3, enabled=true)
	public void VerifyAddLicenseTest(String License){
		actual_message = licensesPage.AddLicense(License);

		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} 
		else if(actual_message.contains("Exists")) {
			assertTrue(actual_message.contains("Name Already Exists"));
		}else {
			assertTrue(actual_message.contains("Successfully Saved"));
		}
	}
	
	
	@DataProvider(name = "DeleteLicense")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData("DeleteLicense");
		return data;
	}
	
	
	@Test(dataProvider="DeleteLicense", priority=4, enabled=true)
	public void VerifyDeleteSkillTest(String License){
		actual_message = licensesPage.DeleteLicense(License);
		if (actual_message.contains("Success"))
		assertTrue(actual_message.contains("Successfully Deleted"));
	}
	
	
	@DataProvider(name = "EditLicense")
	public Object[][] getOrangeHRMTestData2(){
		Object data[][] = TestUtil.getTestData("EditLicense");
		return data;
	}
	
	
	@Test(dataProvider="EditLicense", priority=5, enabled=true)
	public void VerifyEditLicenseTest(String existing_License, String updated_License){
		actual_message = licensesPage.EditLicense(existing_License, updated_License);
		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} else {
			assertTrue(actual_message.contains("Successfully Updated"));
		}
	}
	

	@AfterMethod
	public void tearDown(){
		driver.close();
	}

	
	
}
