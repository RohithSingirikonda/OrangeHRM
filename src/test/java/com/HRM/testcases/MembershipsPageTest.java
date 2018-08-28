package com.HRM.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminModulePage;
import com.HRM.pages.MembershipsPage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.MembershipsPage;
import com.HRM.util.TestUtil;

public class MembershipsPageTest extends TestBase {


	public String actual_message;
	
	LoginPage loginPage;
	AdminModulePage adminModulePage;
	MembershipsPage membershipsPage;
	
	public MembershipsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();
		adminModulePage = new AdminModulePage();
		membershipsPage = new MembershipsPage();
		loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		membershipsPage = adminModulePage.ClickonMembershipsMenu();
	}
	
	@Test(priority=1, enabled=true)
	public void VerifymembershipPageHeaderTest(){
		actual_message = membershipsPage.MembershipsPageHeader();
		Assert.assertEquals(actual_message, "Memberships");
	}
	
	@Test(priority=2, enabled=true)
	public void VerifyAddmembershipPageHeaderTest(){
		actual_message = membershipsPage.AddMembershipsPageHeader();
		Assert.assertEquals(actual_message, "Add Membership");
	}
	
	
	
	@DataProvider(name = "AddMembership")
	public Object[][] getOrangeHRMTestData(){
		Object data[][] = TestUtil.getTestData("AddMembership");
		return data;
	}

	@Test(dataProvider="AddMembership", priority=3, enabled=true)
	public void VerifyAddMembershipsTest(String membership){
		actual_message = membershipsPage.AddMembership(membership);

		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} 
		else if(actual_message.contains("Exists")) {
			assertTrue(actual_message.contains("Already Exists"));
		}else {
			assertTrue(actual_message.contains("Successfully Saved"));
		}
	}
	
	
	
	
	@DataProvider(name = "DeleteMembership")
	public Object[][] getOrangeHRMTestData1(){
		Object data[][] = TestUtil.getTestData("DeleteMembership");
		return data;
	}
	
	@Test(dataProvider="DeleteMembership", priority=4, enabled=true)
	public void VerifyDeleteMembershipsTest(String membership, String flag){
		actual_message = membershipsPage.DeleteMembership(membership, flag);
		if (actual_message.contains("Success"))
		assertTrue(actual_message.contains("Successfully Deleted"));
	}
	
	
	
	
	@DataProvider(name = "EditMembership")
	public Object[][] getOrangeHRMTestData2(){
		Object data[][] = TestUtil.getTestData("EditMembership");
		return data;
	}
	
	@Test(dataProvider="EditMembership", priority=5, enabled=true)
	public void VerifyEditMembershipsTest(String existing_Membership, String updated_Membership){
		actual_message = membershipsPage.EditMembership(existing_Membership, updated_Membership);
		if (actual_message.contains("Required")) {
			assertTrue(actual_message.contains("Required"));
		} else {
			assertTrue(actual_message.contains("Successfully Updated"));
		}
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
