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
import com.HRM.pages.PIMModulePage;

public class PIMPageTest extends TestBase {

	public static String expected_heading;
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	PIMModulePage pim_ModulePage;
	
	public PIMPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		pim_ModulePage = admin_HomePage.clickOnPIMPageLink();
	}
	
	
	
	@Test(priority=1, enabled=true)
	public void verifyPIMPageHeaderTest(){
		expected_heading = pim_ModulePage.PIMPageHeader();
		Assert.assertEquals(expected_heading, "Employee Information", "Page Header is not matched");
	}
	
	
	//Configuration Menu Tests
	
	@Test(priority=2, enabled=true)
	public void verifyOptionalFieldsMenuTest(){
		pim_ModulePage.ClickonOptionalFieldsMenu();
		expected_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "Configure PIM", "Page Header is not matched");
	}
	
	
	@Test(priority=3, enabled=true)
	public void verifyCustomFieldsMenuTest(){
		pim_ModulePage.ClickonCustomFieldsMenu();
		expected_heading = driver.findElement(By.xpath("//div[@id='customFieldAddPane']//h1")).getText();
		Assert.assertEquals(expected_heading, "Add Custom Field", "Page Header is not matched");
	}
	

	@Test(priority=4, enabled=true)
	public void verifyEmpDataImportMenuTest(){
		pim_ModulePage.ClickonEmpDataImportMenu();
		expected_heading = driver.findElement(By.xpath("//*[@id='pimCsvImportHeading']")).getText();
		Assert.assertEquals(expected_heading, "CSV Data Import", "Page Header is not matched");
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyReportingMethodsMenuTest(){
		pim_ModulePage.ClickonRepotingMethodsMenu();
		expected_heading = driver.findElement(By.xpath("//*[@id='recordsListDiv']//h1")).getText();
		Assert.assertEquals(expected_heading, "Reporting Methods", "Page Header is not matched");
	}
	
	
	@Test(priority=6, enabled=true)
	public void verifyTerminationsReasonsMenuTest(){
		pim_ModulePage.ClickonTerminationsReasonsMenu();
		expected_heading = driver.findElement(By.xpath("//*[@id='recordsListDiv']//h1")).getText();
		Assert.assertEquals(expected_heading, "Termination Reasons", "Page Header is not matched");
	}
	
	
	
	//Employee List Menu Tests
	
	@Test(priority=7, enabled=true)
	public void verifyEmployeeListMenuTest(){
		pim_ModulePage.ClickonEmployeeListMenu();
		expected_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "Employee Information", "Page Header is not matched");
	}
	
	
	//Add Employee Menu Tests
	
	@Test(priority=8, enabled=true)
	public void verifyAddEmployeeMenuTest(){
		pim_ModulePage.ClickonAddEmployeeMenu();
		expected_heading = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "Add Employee", "Page Header is not matched");
	}
	
	
	//Reports Menu Tests
	
	@Test(priority=9, enabled=true)
	public void verifyReportsMenuTest(){
		pim_ModulePage.ClickonReportsMenu();
		expected_heading = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(expected_heading, "Employee Reports", "Page Header is not matched");
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
