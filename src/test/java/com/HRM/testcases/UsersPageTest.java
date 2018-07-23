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
import com.HRM.pages.UsersPage;

public class UsersPageTest extends TestBase{

	
	LoginPage loginPage;
	AdminModulePage admin_ModulePage;
	AdminHomePage admin_HomePage;
	UsersPage usersPage;
	
	
	public UsersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_ModulePage = new AdminModulePage();
		admin_HomePage = new AdminHomePage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyAddRoleTest(){
		usersPage.ClickOnAddRole();
		String expected_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "Add User");
	}
	
	
	@Test(priority=2, enabled=true)
	public void verifyDeleteRoleTest(){
		boolean flag = usersPage.ClickOnDeleteRole();
		Assert.assertFalse(flag);
	}
	
	
	@Test(priority=3, enabled=true)
	public void verifyUserRoleDataTest(){
		usersPage.getUsersRoleData();
	}
	
	
	
	
	
	  
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	
}
