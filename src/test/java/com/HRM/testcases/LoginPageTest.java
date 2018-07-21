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
	public void ValidateLoginPageTitleTest(){
		actualTitle = loginpage.ValidateLoginPageTitle();
		assertEquals(actualTitle, "OrangeHRM");
	}
  
	@Test(priority=2)
	public void ValidateLoginPageLogoTest(){
		boolean flag = loginpage.ValidateHRMLogo();
		assertTrue(flag);
	}
	
	
	@Test(priority=3, enabled=false)
	public void ValidateAdminCredintialsTest(){
		admin_homepage = loginpage.AdminLogin(prop.getProperty("Admin_username"),prop.getProperty("Admin_password"));
		actualTitle = admin_homepage.AdminHomePageTitle();
		assertEquals(actualTitle, "OrangeHrm","Test Fail");
	}
	
	
	@Test(priority=4)
	public void ValidateUserCredintialsTest(){
		user_homepage = loginpage.UserLogin(prop.getProperty("username"),prop.getProperty("password"));
		actualTitle = user_homepage.UserHomePageTitle();
		assertEquals(actualTitle, "OrangeHRM", "Test Fail");
		
	}

  
	@AfterMethod
	public void TearDown() {
	       driver.close();
	}

}
