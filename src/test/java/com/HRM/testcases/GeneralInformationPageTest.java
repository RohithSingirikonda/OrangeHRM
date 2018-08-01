package com.HRM.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.GeneralInformationPage;
import com.HRM.pages.LoginPage;
import com.HRM.util.TestUtil;

public class GeneralInformationPageTest extends TestBase {
	
	public static String actual_message;
	String generalInfo_sheet = "generalInfo";


	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	GeneralInformationPage generalInformationPage;
	TestUtil testUtil;
	
	public GeneralInformationPageTest() {
		super();
	}
	
	

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		generalInformationPage =  new GeneralInformationPage();
		testUtil = new TestUtil();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
		generalInformationPage = admin_ModulePage.ClickonGeneralInfoMenu();
	}
	
	
	@Test(priority=1, enabled=true)
	public void VerifyGenInfoPageHeaderTest(){
		actual_message = generalInformationPage.GenInfoPageHeader();
		Assert.assertEquals("General Information", actual_message);
	}
	
	
	@DataProvider(name = "GenInfoDetails")
	public Object[][] getNewToursTestData(){
		Object data[][] = TestUtil.getTestData(generalInfo_sheet);
		return data;
	}
	
	
	@Test(dataProvider="GenInfoDetails", priority=2, enabled=true)
	public void VerifyGenInfoPageValidationTest(String OrgName, String TaxId, String RegNo, String Phone, String Fax, String Email,
			String Address1, String Address2, String City, String State, String Zipcode, String Country, String Note){
		
		String message = generalInformationPage.GenInfoPageValidation(OrgName, TaxId, RegNo, Phone, Fax, Email, Address1, Address2, City, State, Zipcode, Country, Note);
		
		if (message.contains("Required")) {
			System.out.println(message);
		} else {
			System.out.println(message);
		}
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
}
