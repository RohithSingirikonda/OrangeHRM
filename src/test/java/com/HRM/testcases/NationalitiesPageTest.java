package com.HRM.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.NationalitiesPage;
import com.HRM.util.TestUtil;

public class NationalitiesPageTest  extends TestBase {
	
	
	public String actual_message;
	
	LoginPage loginPage;
	AdminHomePage adminHomePage;
	AdminModulePage adminModulePage;
	NationalitiesPage nationalitiesPage;
	
	public NationalitiesPageTest(){
		super();
	}

	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminHomePage = new AdminHomePage();
		adminModulePage = new AdminModulePage();
		nationalitiesPage = new NationalitiesPage();
		loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		adminModulePage = adminHomePage.clickOnAdminPageLink();
		nationalitiesPage = adminModulePage.ClickonNationalitiesMenu();
	}
	
	@Test(priority=1, enabled=true)
	public void VerifyNationalityPageHeaderTest(){
		actual_message = nationalitiesPage.NationalitiesPageHeader();
		Assert.assertEquals(actual_message, "Nationalities");
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyAddNationalityPageHeaderTest(){
		actual_message = nationalitiesPage.AddNationalitiesPageHeader();
		Assert.assertEquals(actual_message, "Add Nationality");
	}
	
	@DataProvider(name = "AddNationality")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData("AddNationality");
		return data;
	}

	@Test(dataProvider="AddNationality", priority=3, enabled=true)
	public void VerifyAddNationalityTest(String nationality){
		actual_message = nationalitiesPage.AddNationality(nationality);

		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} 
		else if(actual_message.contains("exists")) {
			assertTrue(actual_message.contains("Already exists"));
		}else {
			assertTrue(actual_message.contains("Successfully Saved"));
		}
	}
	
	
	
	
	@DataProvider(name = "DeleteNationality")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData("DeleteNationality");
		return data;
	}
	
	@Test(dataProvider="DeleteNationality", priority=4, enabled=true)
	public void VerifyDeleteNationalityTest(String nationality, String flag){
		actual_message = nationalitiesPage.DeleteNationality(nationality, flag);		
		if (actual_message.contains("Success"))
		assertTrue(actual_message.contains("Successfully Deleted"));
	}
	
	
	
	
	@DataProvider(name = "EditNationality")
	public Object[][] getOrangeHRMTestData2(){
		Object data[][] = TestUtil.getTestData("EditNationality");
		return data;
	}
	
	@Test(dataProvider="EditNationality", priority=5, enabled=true)
	public void VerifyEditNationalityTest(String existing_Nationality, String updated_Nationality){
		actual_message = nationalitiesPage.EditNationality(existing_Nationality, updated_Nationality);
		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} else if(actual_message.contains("exists")) {
			assertTrue(actual_message.contains("Already exists"));
		}else {
			assertTrue(actual_message.contains("Successfully Saved"));
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
