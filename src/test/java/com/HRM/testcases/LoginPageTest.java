package com.HRM.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.UserHomePage;

public class LoginPageTest extends TestBase{
	
	public static String actualTitle="";
	
	LoginPage loginpage;
	AdminHomePage admin_homepage;
	UserHomePage user_homepage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() {
		init();
		loginpage = new LoginPage();
		
	}
	
	
	@Test(priority=1)
	public void verifyeLoginPageTitleTest(){
		actualTitle = loginpage.ValidateLoginPageTitle();
		assertEquals(actualTitle, "OrangeHRM");
	}
  
	@Test(priority=2)
	public void verifyLoginPageLogoTest(){
		boolean flag = loginpage.ValidateHRMLogo();
		assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void verifyAdminCredintialsTest(){
		admin_homepage = loginpage.AdminLogin(prop.getProperty("admin_username"),prop.getProperty("admin_password"));
		actualTitle = admin_homepage.AdminHomePageTitle();
		assertEquals(actualTitle, "OrangeHRM","Test Fail");
	}
	
	
	@Test(priority=4, enabled=true)
	public void verifyUserCredintialsTest(){
		user_homepage = loginpage.UserLogin(prop.getProperty("emp_username"),prop.getProperty("emp_password"));
		actualTitle = user_homepage.UserHomePageTitle();
		assertEquals(actualTitle, "OrangeHRM", "Test Fail");
		
	}

  
	@AfterMethod
	public void TearDown() {
	       driver.close();
	}

}
