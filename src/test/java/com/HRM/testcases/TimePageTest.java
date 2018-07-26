package com.HRM.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.TimePage;

public class TimePageTest extends TestBase {
  
	
	public static String actual_heading;
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	TimePage timePage;
	
	
	public TimePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		timePage = new TimePage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		timePage = admin_HomePage.clickOnTimePageLink();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyTimePageHeaderTest(){
		actual_heading = timePage.TimePageHeader();
		Assert.assertEquals(actual_heading, "Timesheets Pending Action", "Page Header is not matched");
	}
	
	
	//Time Sheets Menu Test
	
	@Test(priority=2, enabled=true)
	public void verifyEmployeeTimeSheetsMenuTest(){
		timePage.ClickOnEmployeeTimeSheetsMenu();
		actual_heading = driver.findElement(By.xpath("//div[@id='content']//div[2]//h1")).getText();
		Assert.assertEquals(actual_heading, "Timesheets Pending Action","Page Header is not matched");
	}
	
	
	// Attendence menu Tests	
	
	@Test(priority=3, enabled=true)
	public void verifyEmployeeRecordsMenuTest(){
		timePage.ClickOnEmployeeRecordsMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "View Attendance Record","Page Header is not matched");
	}
	
	
	@Test(priority=4, enabled=true)
	public void verifyAttendenceConfigMenuTest(){
		timePage.ClickOnAttendenceConfigMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Attendance Configuration","Page Header is not matched");
	}

	
	
	// Reports Menu Tests
	
	@Test(priority=5, enabled=true)
	public void verifyProjectReportsMenuTest(){
		timePage.ClickOnProjectReportsMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='reportToHeading']")).getText();
		Assert.assertEquals(actual_heading, "Project Report","Page Header is not matched");
	}

	
	@Test(priority=6, enabled=true)
	public void verifyEmployeeReportsMenuTest(){
		timePage.ClickOnEmployeeReportsMenu();
		actual_heading = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Employee Report","Page Header is not matched");
	}

	
	@Test(priority=7, enabled=true)
	public void verifyAttendanceSummaryMenuTest(){
		timePage.ClickOnAttendanceSummaryMenu();
		actual_heading = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Attendance Total Summary Report","Page Header is not matched");
	}

	
	
	// Project info Menu Tests
	
	@Test(priority=8, enabled=true)
	public void verifyCustomersMenuTest(){
		timePage.ClickOnCustomersMenu();
		actual_heading = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Customers","Page Header is not matched");
	}
	
	
	@Test(priority=9, enabled=true)
	public void verifyProjectsMenuTest(){
		timePage.ClickOnProjectsMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='searchProjectHeading']")).getText();
		Assert.assertEquals(actual_heading, "Projects","Page Header is not matched");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
