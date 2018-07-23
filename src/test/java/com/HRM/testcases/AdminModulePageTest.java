package com.HRM.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LoginPage;

public class AdminModulePageTest extends TestBase{
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	
	
	public AdminModulePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyAdminPageHeaderTest(){
		String expected_heading = admin_ModulePage.AdminPageHeader();
		Assert.assertEquals(expected_heading, "System Users", "Page Header is not matched");
	}
	
	
	@Test(priority=2, enabled=true)
	public void verifyClickonUsersMenuTest(){
		admin_ModulePage.ClickonUsersMenu();
		String expected_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "System Users","Page Header is not matched");
	}
	
	
	@Test(priority=3, enabled=true)
	public void verifyJobTitlesMenuTest(){
		admin_ModulePage.ClickonJobTitlesMenu();
		String expected_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "Job Titles","Page Header is not matched");
	}
	
	@Test(priority=4, enabled=true)
	public void verifyPayGradesMenuTest(){
		admin_ModulePage.ClickonPayGradesMenu();
		String expected_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "Pay Grades","Page Header is not matched");
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyEmploymentStatusMenuTest(){
		admin_ModulePage.ClickonEmploymentStatusMenu();
		String expected_heading = driver.findElement(By.xpath("//div[@id='search-results']//h1")).getText();
		Assert.assertEquals(expected_heading, "Employment Status","Page Header is not matched");
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyJobCategoriesMenuTest(){
		admin_ModulePage.ClickonJobCategoriesMenu();
		String expected_heading = driver.findElement(By.xpath("//div[@id='search-results']//h1")).getText();
		Assert.assertEquals(expected_heading, "Job Categories","Page Header is not matched");
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyWorkShiftsMenuTest(){
		admin_ModulePage.ClickonWorkShiftsMenu();
		String expected_heading = driver.findElement(By.xpath("//div[@id='search-results']//h1")).getText();
		Assert.assertEquals(expected_heading, "Work Shifts","Page Header is not matched");
	}
	
	
	
	
	
	  
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
