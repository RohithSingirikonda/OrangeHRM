package com.HRM.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AddLocationPage;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.LocationsPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class AddLocationPageTest extends TestBase{

	public static String actual_message;
	String AddLocation_sheet = "AddLocation";
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	LocationsPage locationsPage;
	AddLocationPage addLocationPage;
	
	public AddLocationPageTest(){
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		locationsPage = new LocationsPage();
		addLocationPage =  new AddLocationPage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		locationsPage = admin_ModulePage.ClickonLocationsMenu();
		addLocationPage = locationsPage.AddLocations();
	}
	
	
	
	@Test(priority=1, enabled=false)
	public void VerifyAddLocationPageHeaderTest(){
		actual_message = addLocationPage.AddLocationPageHeader();
			Assert.assertEquals("Add Location", actual_message);;
	}
	
	
	@DataProvider(name = "InsertJobLocations")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData(AddLocation_sheet);
		return data;
	}
	

	@Test(dataProvider="InsertJobLocations", priority=2, enabled=true)
	public void VerifyAddLocationsTest(String locations, String country, String state, String city, String address, String pincode,
									String phone, String fax, String notes) {
		
		actual_message = addLocationPage.AddLocations(locations, country, state, city, address, pincode, phone, fax, notes);
		
		if (locations.isEmpty() || country.isEmpty())
		Assert.assertEquals("Required", actual_message);
		else
		Assert.assertEquals("Successfully Saved", actual_message);
		
	}

	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
