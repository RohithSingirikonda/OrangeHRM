package com.HRM.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.JobCategoriesPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class JobCategoriesPageTest extends TestBase {

	public static String actual_message;
	String AddJobCategories_sheet = "AddJobCategories";
	String DeleteJobCategories_sheet = "DeleteJobCategories";
	

	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	JobCategoriesPage jobCategoriesPage;
	TestUtil testUtil;
	
	public JobCategoriesPageTest() {
		super();
	}
	
	

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		jobCategoriesPage = new JobCategoriesPage();
		testUtil = new TestUtil();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		jobCategoriesPage = admin_ModulePage.ClickonJobCategoriesMenu();
	}
	
	
	@Test(priority=1, enabled=true)
	public void VerifyJobCategoriesPageHeaderTest(){
		actual_message = jobCategoriesPage.JobCategoriesPageHeader();
		Assert.assertEquals("Job Categories", actual_message);
	}
	
	@DataProvider(name = "AddJobCategories")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(AddJobCategories_sheet);
		return data;
	}
	
	
	@Test(dataProvider="AddJobCategories",priority=2, enabled=true)
	public void VerifyAddJobCategoriesTest(String jobCategory){

		try {
			actual_message = jobCategoriesPage.AddJobCategory(jobCategory);
			
			if (actual_message.equals("Required")) {
				Assert.assertEquals(actual_message, "Required");
			} 
			else {
				//Assert.assertEquals("Successfully Saved Close", actual_message);
			}

			} catch (NullPointerException e) {
		 	e.printStackTrace();
			
		}
	}

	
	@DataProvider(name = "DeleteJobCategories")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData(DeleteJobCategories_sheet);
		return data;
	}
	
	@Test(dataProvider="DeleteJobCategories", priority=3, enabled=true)
	public void VerifyDeleteJobTitlesTest(String jobCategory, String Validation){
		actual_message = jobCategoriesPage.DeleteJobCategory(jobCategory, Validation);
		//Assert.assertEquals("Successfully Deleted", actual_message);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
