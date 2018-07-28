package com.HRM.testcases;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AddJobTitlePage;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.JobTitlesPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class AddJobTitlePageTest extends TestBase{

	public static String actual_message;
	String AddJobTitles_sheet = "AddJobTitles";
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	JobTitlesPage job_TitlesPage;
	AddJobTitlePage add_JobTitlePage;
	TestUtil testUtil;
	
	public AddJobTitlePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		job_TitlesPage= new JobTitlesPage();
		add_JobTitlePage = new AddJobTitlePage();
		testUtil = new TestUtil();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		job_TitlesPage = admin_ModulePage.ClickonJobTitlesMenu();
		add_JobTitlePage = job_TitlesPage.AddJobTitles();
	}
	
	
	@Test(priority=1, enabled=true)
	public void VerifyPageLablesTest(){
		String expected[] = {"Job Title *", "Job Description", "Job Specification", "Note"};
		String actual[] = add_JobTitlePage.PageLables();
			Assert.assertArrayEquals(expected, actual);
	}
	
	@DataProvider(name = "InsertJobTitles")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(AddJobTitles_sheet);
		return data;
	}
	
	
	@Test(dataProvider="InsertJobTitles",priority=2, enabled=true)
	public void VerifyInsertTitleDataTest(String JobTitle, String JobDesc, String JobNote){

		try {
			actual_message = add_JobTitlePage.InsertTitleData(JobTitle, JobDesc, JobNote);
			
			if (!actual_message.equals(null) || !actual_message.equals("")) {
				 Assert.assertEquals(actual_message, "Required");
			} 
			else {
				throw new NullPointerException();
			}

		} catch (NullPointerException e) {
			actual_message = driver.findElement(By.xpath("//*[@id='search-results']/div[1]/h1")).getText();
		 	Assert.assertEquals(actual_message, "Job Titles");
			
		}
	}
	
	
	@Test(priority=3, enabled=true)
	public void VerifyClickOnCancelTest(){
		add_JobTitlePage.ClickOnCancelBtn();
		actual_message = driver.findElement(By.xpath("//*[@id='search-results']/div[1]/h1")).getText();
		Assert.assertEquals(actual_message, "Job Titles");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
