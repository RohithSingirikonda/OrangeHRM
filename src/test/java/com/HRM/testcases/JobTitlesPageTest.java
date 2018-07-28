package com.HRM.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.JobTitlesPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class JobTitlesPageTest extends TestBase {

	
	public static String actual_message;
	String DeleteJobTitles_sheet = "DeleteJobTitles";
	
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	JobTitlesPage job_TitlesPage;
	
	public JobTitlesPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		job_TitlesPage= new JobTitlesPage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		job_TitlesPage = admin_ModulePage.ClickonJobTitlesMenu();
	}
	
	
	@Test(priority=1, enabled=false)
	public void VerifyAddJobTitlesTest(){
		job_TitlesPage.AddJobTitles();
		actual_message = driver.findElement(By.id("saveHobTitleHeading")).getText();
		Assert.assertEquals("Add Job Title",actual_message);
	}
	
	
	@DataProvider(name = "deleteJobTitles")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(DeleteJobTitles_sheet);
		return data;
	}
	
	@Test(dataProvider="deleteJobTitles", priority=2, enabled=true)
	public void VerifyDeleteJobTitlesTest(String JobTitle){
		job_TitlesPage.DeleteJobTitles(JobTitle);
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
}
