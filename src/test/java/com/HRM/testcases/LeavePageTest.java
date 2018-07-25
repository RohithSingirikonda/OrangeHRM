package com.HRM.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.LeavePage;
import com.HRM.pages.LoginPage;

public class LeavePageTest extends TestBase {
	
	public static String actual_heading;
	
	LoginPage loginPage;
	AdminHomePage adminHomePage;
	LeavePage leavePage;
	
	public LeavePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminHomePage = new AdminHomePage();
		leavePage = new LeavePage();
		adminHomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		leavePage = adminHomePage.clickOnLeavePageLink();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyLeavePageHeaderTest(){
		actual_heading = leavePage.LeavePageHeader();
		Assert.assertEquals(actual_heading, "Leave List", "Page Header is not matched");
	}
	
	
	
	//Entitlements Menu Tests
	
	@Test(priority=2, enabled=true)
	public void verifyAddEntitlementsMenuTest(){
		leavePage.ClickOnAddEntitlementsMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Add Leave Entitlement","Page Header is not matched");
	}
	
	
	@Test(priority=3, enabled=true)
	public void verifyEmployeeEntitlementsMenuTest(){
		leavePage.ClickOnEmployeeEntitlementsMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Leave Entitlements","Page Header is not matched");
	}
	
	
	
	// Reports Menu Tests
	
	@Test(priority=4, enabled=true)
	public void verifyLeaveUsageReportMenuTest(){
		leavePage.ClickOnLeaveUsageReportMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Leave Entitlements and Usage Report","Page Header is not matched");
	}
	
	
	
	
	// Leave Configure Page Tests
	
	@Test(priority=5, enabled=true)
	public void verifyLeavePeriodMenuTest(){
		leavePage.ClickOnLeavePeriodMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Leave Period","Page Header is not matched");
	}
	
	
	@Test(priority=6, enabled=true)
	public void verifyLeaveTypesMenuTest(){
		leavePage.ClickOnLeaveTypesMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Leave Types","Page Header is not matched");
	}
	
	@Test(priority=7, enabled=true)
	public void verifyWorkWeekPageMenuTest(){
		leavePage.ClickOnWorkWeekPageMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Work Week","Page Header is not matched");
	}
	
	
	@Test(priority=8, enabled=true)
	public void verifyHolidaysMenuTest(){
		leavePage.ClickOnHolidaysMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Holidays","Page Header is not matched");
	}
	
	
	
	
	// Leave List menu
	
	@Test(priority=9, enabled=true)
	public void verifyLeaveLeaveListMenuTest(){
		leavePage.ClickOnLeaveListMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Leave List", "Page Header is not matched");
	}
	
	

	// Assign Leave menu
	
	@Test(priority=10, enabled=true)
	public void verifyAssignLeaveMenuTest(){
		leavePage.ClickOnAssignLeaveMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Assign Leave", "Page Header is not matched");
	}

	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}
