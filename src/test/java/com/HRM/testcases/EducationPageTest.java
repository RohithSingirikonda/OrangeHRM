package com.HRM.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.EducationPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class EducationPageTest extends TestBase{

	
	public String actual_message;
	String AddSkills_sheet = "AddSkills";
	
	LoginPage loginPage;
	AdminModulePage adminModulePage;
	EducationPage educationPage;
	
	public EducationPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminModulePage  = new AdminModulePage();
		educationPage = new EducationPage();
		loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		adminModulePage.ClickonEducationMenu();
	}
	
	@Test(priority=1, enabled=true)
	public void VerifyEducationPageHeaderTest(){
		actual_message = educationPage.EducationPageHeader();
		Assert.assertEquals(actual_message, "Education");
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyAddEducationPageHeaderTest(){
		actual_message = educationPage.AddEducationPageHeader();
		Assert.assertEquals(actual_message, "Add Education");
	}
	
	
	@DataProvider(name = "AddEducation")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData("AddEducation");
		return data;
	}
	
	
	@Test(dataProvider="AddEducation", priority=3, enabled=true)
	public void VerifyAddEducationTest(String education){
		actual_message = educationPage.AddEducation(education);

		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} 
		else if(actual_message.contains("Exists")) {
			assertTrue(actual_message.contains("Level Already Exists"));
		}else {
			assertTrue(actual_message.contains("Successfully Saved"));
		}
	}
	
	
	@DataProvider(name = "DeleteEducation")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData("DeleteEducation");
		return data;
	}
	
	
	@Test(dataProvider="DeleteEducation", priority=4, enabled=true)
	public void VerifyDeleteSkillTest(String education){
		actual_message = educationPage.DeleteEducation(education);
		if (actual_message.contains("Success"))
		assertTrue(actual_message.contains("Successfully Deleted"));
	}
	
	
	@DataProvider(name = "EditEducation")
	public Object[][] getOrangeHRMTestData2(){
		Object data[][] = TestUtil.getTestData("EditEducation");
		return data;
	}
	
	
	@Test(dataProvider="EditEducation", priority=5, enabled=true)
	public void VerifyEditEducationTest(String existing_Education, String updated_Education){
		actual_message = educationPage.EditEducation(existing_Education, updated_Education);
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
