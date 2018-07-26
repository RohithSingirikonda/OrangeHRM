package com.HRM.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.EmployeeTrackersPage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.PerformancePage;

public class PerformancePageTest extends TestBase {

	public static String actual_heading;
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	PerformancePage performance_Page;
	
	
	public PerformancePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		performance_Page = new PerformancePage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
	}
	
	
	// Configure Menu Tests
	
	@Test(priority=1, enabled=true)
	public void verifyKPIsMenuTest(){
		performance_Page.ClickOnKPIsMenu();
		actual_heading =  driver.findElement(By.xpath("//*[@id='divFormContainer']//h1")).getText();
		Assert.assertEquals(actual_heading, "Search Key Performance Indicators", "Page Header is not matched");
	}
	
	
	@Test(priority=2, enabled=true)
	public void verifyTrackersMenuTest(){
		performance_Page.ClickOnTrackersMenu();
		actual_heading =  driver.findElement(By.xpath("//*[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "Performance Trackers", "Page Header is not matched");
	}
	
	
	// Manage Reviews Menu Tests
	
	@Test(priority=3, enabled=true)
	public void verifyManageReviewsMenuTest(){
		performance_Page.ClickOnManageReviewsMenu();
		actual_heading =  driver.findElement(By.xpath("//*[@id='leave-list-search']//h1")).getText();
		Assert.assertEquals(actual_heading, "Search Performance Reviews", "Page Header is not matched");
	}
	
	
	// Employee Trackers Menu
		
	@Test(priority=4, enabled=true)
	public void verifyEmployeeTrackersMenuTest(){
		performance_Page.ClickOnEmployeeTrackersMenu();
		actual_heading =  driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Performance Trackers", "Page Header is not matched");
	}	

	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
