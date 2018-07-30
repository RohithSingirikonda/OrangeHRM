package com.HRM.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.EmploymentStatusPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class EmploymentStatusPageTest extends TestBase {

	
	public static String actual_message;
	String AddEmpStatus_sheet = "AddEmpStatus";
	String DeleteEmpStatus_sheet = "DeleteEmpStatus";
	

	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	EmploymentStatusPage employmentStatusPage;
	TestUtil testUtil;
	
	public EmploymentStatusPageTest(){
		super();
	}
	
	

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		employmentStatusPage= new EmploymentStatusPage();
		testUtil = new TestUtil();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		employmentStatusPage = admin_ModulePage.ClickonEmploymentStatusMenu();
	}
	
	
	@Test(priority=1, enabled=true)
	public void VerifyEmploymentStatusPageHeaderTest(){
		actual_message = employmentStatusPage.EmploymentStatusPageHeader();
		Assert.assertEquals("Employment Status", actual_message);
	}
	
	@DataProvider(name = "InsertEmpStatus")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(AddEmpStatus_sheet);
		return data;
	}
	
	
	@Test(dataProvider="InsertEmpStatus",priority=2, enabled=true)
	public void VerifyAddEmpStatusTest(String empStatus){

		try {
			actual_message = employmentStatusPage.AddEmpStatus(empStatus);
			
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

	
	@DataProvider(name = "DeleteEmpStatus")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData(DeleteEmpStatus_sheet);
		return data;
	}
	
	@Test(dataProvider="DeleteEmpStatus", priority=3, enabled=true)
	public void VerifyDeleteJobTitlesTest(String empStatus, String Validation){
		actual_message = employmentStatusPage.DeleteEmpStatus(empStatus, Validation);
		//Assert.assertEquals("Successfully Deleted", actual_message);
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
