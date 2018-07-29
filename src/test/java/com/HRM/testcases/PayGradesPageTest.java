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
import com.HRM.pages.PayGradesPage;
import com.HRM.util.TestUtil;

public class PayGradesPageTest extends TestBase {

	
	public static String actual_message;
	String DeletePayGrade_sheet = "DeletePayGrade";
	
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	PayGradesPage payGradesPage;
	
	
	public PayGradesPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		payGradesPage= new PayGradesPage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		payGradesPage = admin_ModulePage.ClickonPayGradesMenu();
	}
	
	
	@Test(priority=1, enabled=true)
	public void VerifyJobTitlesPageHeaderTest(){
		actual_message = payGradesPage.PayGradesPageHeader();
		Assert.assertEquals("Pay Grades", actual_message);
	}
	
	
	@Test(priority=2, enabled=true)
	public void VerifyAddPayGradeTest(){
		payGradesPage.AddPayGrade();
		actual_message = driver.findElement(By.id("payGradeHeading")).getText();
		Assert.assertEquals("Add Pay Grade",actual_message);
	}
	
	
	@DataProvider(name = "deletepayGrades")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(DeletePayGrade_sheet);
		return data;
	}
	
	@Test(dataProvider="deletepayGrades", priority=3, enabled=true)
	public void VerifyDeleteJobTitlesTest(String PayGrade, String Validation){
		payGradesPage.DeletepayGrades(PayGrade, Validation);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
