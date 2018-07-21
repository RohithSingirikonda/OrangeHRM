package com.HRM.testcases;

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
			admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_username"));
		}
		
		@Test(priority=1)
		public void verifyHomePageTitleTest(){
			String homePageTitle = admin_HomePage.AdminHomePageTitle();
			Assert.assertEquals(homePageTitle, "OrangeH4M","Home page title not matched");
			
		}
		 
		@Test(priority=2)
		public void verifyHomeLogoTest(){
			boolean flag = admin_HomePage.AdminHomePageLogo();
			Assert.assertTrue(flag);
			
		}
		  
		  
			  
		@AfterMethod
		public void tearDown() {
			driver.close();
		}

}
