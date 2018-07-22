package com.HRM.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AdminHomePageTest extends TestBase{
		
		AdminHomePage admin_HomePage;
		LoginPage loginPage;
	
		public AdminHomePageTest() {
			super();
		}
	
	
		@BeforeMethod
		public void setUp() {
			init();
			loginPage = new LoginPage();
			admin_HomePage = new AdminHomePage();
			admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		}
		
		@Test(priority=1, enabled=true)
		public void verifyHomePageTitleTest(){
			String homePageTitle = admin_HomePage.AdminHomePageTitle();
			Assert.assertEquals(homePageTitle, "OrangeHRM","Home page title not matched");
			
		}
		 
		@Test(priority=2, enabled=true)
		public void verifyHomeLogoTest(){
			boolean flag = admin_HomePage.AdminHomePageLogo();
			Assert.assertTrue(flag);
			
		}
		 
		
		@Test(priority=3, enabled=true)
		public void verifyAdminHomePageUserTest(){
			String actual_name = admin_HomePage.AdminHomePageUser();
			Assert.assertEquals(actual_name, "Welcome Admin", "Test Failed: Not Admin User");
		}
		
		@Test(priority=4, enabled=true)
		public void verifyAdminAboutLinkTest(){
			admin_HomePage.clickOnAdminHomeUserAboutLink();
			//Assert.assertEquals(actual_name, "Welcome Admin", "Not Admin User");
		}
		
		@Test(priority=5, enabled=true)
		public void verifyAdminChangePasswordLinkTest(){
			admin_HomePage.clickOnChangePasswordLink();
			// actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1"));
			//actual_heading.getText();
			//System.out.println(actual_heading.getText());
			//Assert.assertEquals(actual_heading, "Change Password", "Not Change Password Page");
		}
		
		@Test(priority=6, enabled=true)
		public void verifyAdminLogoutLinkTest(){
			admin_HomePage.clickOnLogoutLink();
			WebElement actual_heading = driver.findElement(By.id("logInPanelHeading"));
			actual_heading.getText();
			Assert.assertEquals(actual_heading, "LOGIN Panel", "Not in Login Page");
		}
		
		
		@Test(priority=7, enabled=true)
		public void verifyPIMPageLinkTest(){
			admin_HomePage.clickOnPIMPageLink();
			
		}
		
		
		@Test(priority=8, enabled=true)
		public void verifyLeavePageLinkTest(){
			admin_HomePage.clickOnLeavePageLink();
			
		}
		
		@Test(priority=9, enabled=true)
		public void verifyTimePageLinkTest(){
			admin_HomePage.clickOnTimePageLink();
			
		}
		
		@Test(priority=10, enabled=true)
		public void verifyRecruitmentPageLinkTest(){
			admin_HomePage.clickOnRecruitmentPageLink();
			
		}
		
		@Test(priority=11, enabled=true)
		public void verifyPerformancePageLinkTest(){
			admin_HomePage.clickOnPerformancePageLink();
			
		}
		
		@Test(priority=12, enabled=true)
		public void verifyAdminDashboardLinkTest(){
			admin_HomePage.clickOnDashboardPageLink();
			
		}
		
		@Test(priority=13, enabled=true)
		public void verifyDirectoryPageLinkTest(){
			admin_HomePage.clickOnDirectoryPageLink();
			
		}
		
			  
		@AfterMethod
		public void tearDown() {
			driver.close();
		}

}
