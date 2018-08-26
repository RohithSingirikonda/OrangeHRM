package com.HRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.SkillsPage;
import com.HRM.util.TestUtil;

public class SkillsPageTest extends TestBase {

	
	public String actual_message;
	String AddSkills_sheet = "AddSkills";
	
	LoginPage loginPage;
	AdminModulePage adminModulePage;
	SkillsPage skillsPage;
	
	public SkillsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminModulePage  = new AdminModulePage();
		skillsPage = new SkillsPage();
		loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		adminModulePage.ClickonSkillsMenu();
	}
	
	@Test(priority=1, enabled=false)
	public void VerifySkillsPageHeaderTest(){
		actual_message = skillsPage.SkillsPageHeader();
		Assert.assertEquals(actual_message, "Skills");
	}
	
	@DataProvider(name = "AddSkillSet")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData("AddSkills");
		return data;
	}
	
	
	@Test(dataProvider="AddSkillSet", priority=2, enabled=false)
	public void VerifyAddSkillTest(String skill, String desc){
		actual_message = skillsPage.AddSkill(skill, desc);
		//Assert.assertEquals(actual_message, "Skills");
		System.out.println(actual_message);
	}
	
	
	@DataProvider(name = "DeleteSkillSet")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData("DeleteSkills");
		return data;
	}
	
	
	@Test(dataProvider="DeleteSkillSet", priority=2, enabled=false)
	public void VerifyDeleteSkillTest(String skill){
		actual_message = skillsPage.DeleteSkill(skill);
		//Assert.assertEquals(actual_message, "Skills");
		System.out.println(actual_message);
	}
	
	
	@DataProvider(name = "EditSkillSet")
	public Object[][] getOrangeHRMTestData2(){
		Object data[][] = TestUtil.getTestData("EditSkills");
		return data;
	}
	
	
	@Test(dataProvider="EditSkillSet", priority=2, enabled=true)
	public void VerifyEditSkillTest(String existingskill, String newskill){
		actual_message = skillsPage.EditSkill(existingskill, newskill);
		//Assert.assertEquals(actual_message, "Skills");
		System.out.println(actual_message);
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}
