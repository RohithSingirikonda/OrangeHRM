package com.HRM.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LanguagePage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class LanguagePageTest extends TestBase{

	public String actual_message;
	
	LoginPage loginPage;
	AdminModulePage adminModulePage;
	LanguagePage languagePage;
	
	public LanguagePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminModulePage = new AdminModulePage();
		languagePage = new LanguagePage();
		loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		languagePage = adminModulePage.ClickonlanguagesMenu();
	}

	
	@Test(priority=1, enabled=true)
	public void VerifylanguagePageHeaderTest(){
		actual_message = languagePage.LanguagePageHeader();
		Assert.assertEquals(actual_message, "Languages");
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyAddlanguagePageHeaderTest(){
		actual_message = languagePage.AddLanguagePageHeader();
		Assert.assertEquals(actual_message, "Add Language");
	}
	
	
	
	@DataProvider(name = "AddLanguage")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData("AddLanguage");
		return data;
	}

	@Test(dataProvider="AddLanguage", priority=3, enabled=true)
	public void VerifyAddLanguageTest(String language){
		actual_message = languagePage.AddLanguage(language);

		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} 
		else if(actual_message.contains("Exists")) {
			assertTrue(actual_message.contains("Name Already Exists"));
		}else {
			assertTrue(actual_message.contains("Successfully Saved"));
		}
	}
	
	
	
	
	@DataProvider(name = "DeleteLanguage")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData("DeleteLanguage");
		return data;
	}
	
	@Test(dataProvider="DeleteLanguage", priority=4, enabled=true)
	public void VerifyDeleteLanguageTest(String language){
		actual_message = languagePage.DeleteLanguage(language);
		if (actual_message.contains("Success"))
		assertTrue(actual_message.contains("Successfully Deleted"));
	}
	
	
	
	
	@DataProvider(name = "EditLanguage")
	public Object[][] getOrangeHRMTestData2(){
		Object data[][] = TestUtil.getTestData("EditLanguage");
		return data;
	}
	
	@Test(dataProvider="EditLanguage", priority=5, enabled=true)
	public void VerifyEditLanguageTest(String existing_Language, String updated_Language){
		actual_message = languagePage.EditLanguage(existing_Language, updated_Language);
		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} else {
			assertTrue(actual_message.contains("Successfully Updated"));
		}
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
