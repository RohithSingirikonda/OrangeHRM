package com.HRM.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LocationsPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class LocationsPageTest extends TestBase{

	
	public static String actual_message;
	String DeleteLocations_sheet = "DeleteLocations";
	
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	LocationsPage LocationsPage;
	
	public LocationsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		LocationsPage= new LocationsPage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		LocationsPage = admin_ModulePage.ClickonLocationsMenu();
	}
	
	
	@Test(priority=1, enabled=false)
	public void VerifyJobTitlesPageHeaderTest(){
		actual_message = LocationsPage.LocationsPageHeader();
		Assert.assertEquals("Locations", actual_message);
	}
	
	
	
	@Test(priority=2, enabled=false)
	public void VerifyAddLocationsTest(){
		LocationsPage.AddLocations();
		actual_message = driver.findElement(By.id("locationHeading")).getText();
		Assert.assertEquals("Add Location",actual_message);
	}
	
	
	@DataProvider(name = "deleteLocations")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(DeleteLocations_sheet);
		return data;
	}
	
	@Test(dataProvider="deleteLocations", priority=3, enabled=true)
	public void VerifyDeleteJobTitlesTest(String locations, String Validation){
		LocationsPage.DeleteLocations(locations, Validation);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	
	
}
