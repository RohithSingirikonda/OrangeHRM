package com.HRM.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AddJobTitlePage;
import com.HRM.pages.AddPayGradePage;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.JobTitlesPage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.PayGradesPage;
import com.HRM.util.TestUtil;

public class AddPayGradePageTest extends TestBase {

	
	public static String actual_message;
	String AddpayGrades_sheet = "AddpayGrades";
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	PayGradesPage pay_GradesPage;
	AddPayGradePage add_PayGradePage;
	TestUtil testUtil;
	
	public AddPayGradePageTest(){
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		pay_GradesPage= new PayGradesPage();
		add_PayGradePage = new AddPayGradePage();
		testUtil = new TestUtil();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		pay_GradesPage = admin_ModulePage.ClickonPayGradesMenu();
		add_PayGradePage = pay_GradesPage.AddPayGrade();
	}
	
	
	@Test(priority=1, enabled=true)
	public void VerifyAddPayGradePageHeaderTest(){
		actual_message = add_PayGradePage.AddPayGradePageHeader();
		Assert.assertEquals("Add Pay Grade", actual_message);
	}
	
	
	@Test(priority=2, enabled=true)
	public void VerifyPageLablesTest(){
		String expected[] = {"Name *"};
		String actual[] = add_PayGradePage.PageLables();
			Assert.assertArrayEquals(expected, actual);
	}
	
	
	@DataProvider(name = "InsertpayGrades")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(AddpayGrades_sheet);
		return data;
	}
	
	
	@Test(dataProvider="InsertpayGrades",priority=3, enabled=true)
	public void VerifyInsertGradeDataTest(String payGrade){

		try {
			actual_message = add_PayGradePage.InsertGradeData(payGrade);
			
			if (!actual_message.equals(null) || !actual_message.equals("")) {
				 Assert.assertEquals(actual_message, "Required");
			} 
			else {
				throw new NullPointerException();
			}

		} catch (NullPointerException e) {
			actual_message = driver.findElement(By.xpath("//*[@id='payGradeHeading']")).getText();
		 	Assert.assertEquals(actual_message, "Edit Pay Grade");
			
		}
	}
	
	
	
	@Test(priority=4, enabled=true)
	public void VerifyClickOnCancelTest(){
		add_PayGradePage.ClickOnCancelBtn();
		actual_message = driver.findElement(By.xpath("//*[@id='search-results']/div[1]/h1")).getText();
		Assert.assertEquals(actual_message, "Pay Grades");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	
	
	
	
}
