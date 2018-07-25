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

public class AdminModulePageTest extends TestBase{
	
	public static String actual_heading;
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	AdminModulePage admin_ModulePage;
	
	
	public AdminModulePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		admin_ModulePage = new AdminModulePage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		admin_ModulePage = admin_HomePage.clickOnAdminPageLink();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyAdminPageHeaderTest(){
		actual_heading = admin_ModulePage.AdminPageHeader();
		Assert.assertEquals(actual_heading, "System Users", "Page Header is not matched");
	}
	
	
	//User Management Menu Tests
	
	@Test(priority=2, enabled=true)
	public void verifyClickonUsersMenuTest(){
		admin_ModulePage.ClickonUsersMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "System Users","Page Header is not matched");
	}
	
	
	//Job Menu Tests
	
	@Test(priority=3, enabled=true)
	public void verifyJobTitlesMenuTest(){
		admin_ModulePage.ClickonJobTitlesMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Job Titles","Page Header is not matched");
	}
	
	@Test(priority=4, enabled=true)
	public void verifyPayGradesMenuTest(){
		admin_ModulePage.ClickonPayGradesMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Pay Grades","Page Header is not matched");
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyEmploymentStatusMenuTest(){
		admin_ModulePage.ClickonEmploymentStatusMenu();
		actual_heading = driver.findElement(By.xpath("//div[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "Employment Status","Page Header is not matched");
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyJobCategoriesMenuTest(){
		admin_ModulePage.ClickonJobCategoriesMenu();
		actual_heading = driver.findElement(By.xpath("//div[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "Job Categories","Page Header is not matched");
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyWorkShiftsMenuTest(){
		admin_ModulePage.ClickonWorkShiftsMenu();
		actual_heading = driver.findElement(By.xpath("//div[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "Work Shifts","Page Header is not matched");
	}
	
	
	
	
	//Organization Menu Tests
	
	@Test(priority=6, enabled=true)
	public void verifyGeneralInfoMenuTest(){
		admin_ModulePage.ClickonGeneralInfoMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='genInfoHeading']")).getText();
		Assert.assertEquals(actual_heading, "General Information","Page Header is not matched");
	}
	
	
	@Test(priority=7, enabled=true)
	public void verifyLocationsMenuTest(){
		admin_ModulePage.ClickonLocationsMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='searchLocationHeading']")).getText();
		Assert.assertEquals(actual_heading, "Locations","Page Header is not matched");
	}
	
	
	@Test(priority=8, enabled=true)
	public void verifyStructureMenuTest(){
		admin_ModulePage.ClickonStructureMenu();
		actual_heading = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Organization Structure","Page Header is not matched");
	}
	
	
	
	//Qualifications Menu Tests
	
	@Test(priority=9, enabled=true)
	public void verifySkillsMenuTest(){
		admin_ModulePage.ClickonSkillsMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='recordsListDiv']//h1")).getText();
		Assert.assertEquals(actual_heading, "Skills","Page Header is not matched");
	}
	
	
	@Test(priority=10, enabled=true)
	public void verifyEducationMenuTest(){
		admin_ModulePage.ClickonEducationMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='recordsListDiv']//h1")).getText();
		Assert.assertEquals(actual_heading, "Education","Page Header is not matched");
	}
	
	
	@Test(priority=11, enabled=true)
	public void verifyLicensesMenuTest(){
		admin_ModulePage.ClickonLicensesMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='recordsListDiv']//h1")).getText();
		Assert.assertEquals(actual_heading, "Licenses","Page Header is not matched");
	}
	
	

	@Test(priority=12, enabled=true)
	public void verifyLanguagesMenuTest(){
		admin_ModulePage.ClickonlanguagesMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='recordsListDiv']//h1")).getText();
		Assert.assertEquals(actual_heading, "Languages","Page Header is not matched");
	}
	
	

	@Test(priority=13, enabled=true)
	public void verifyMembershipsMenuTest(){
		admin_ModulePage.ClickonMembershipsMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "Memberships","Page Header is not matched");
	}
	
	
	
	//Nationalities Menu Tests
	
	@Test(priority=14, enabled=true)
	public void verifyNationalitiesMenuTest(){
		admin_ModulePage.ClickonNationalitiesMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "Nationalities","Page Header is not matched");
	}
	
	
	
	
	//Configuration Menu Tests
	
	@Test(priority=15, enabled=true)
	public void verifyEmailConfigMenuTest(){
		admin_ModulePage.ClickonEmailConfigMenu();
		actual_heading = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Mail Configuration","Page Header is not matched");
	}
	
	
	@Test(priority=16, enabled=true)
	public void verifyEmailNotifyMenuTest(){
		admin_ModulePage.ClickonEmailNotifyMenu();
		actual_heading = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Email Notification","Page Header is not matched");
	}
	
	
	@Test(priority=17, enabled=true)
	public void verifyLocalizationMenuTest(){
		admin_ModulePage.ClickonLocalizationMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='localizationHeading']")).getText();
		Assert.assertEquals(actual_heading, "Localization","Page Header is not matched");
	}
	
	
	@Test(priority=18, enabled=true)
	public void verifyModulesMenuTest(){
		admin_ModulePage.ClickonModulesMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='saveFormHeading']")).getText();
		Assert.assertEquals(actual_heading, "Module Configuration","Page Header is not matched");
	}
	
	
	@Test(priority=19, enabled=true)
	public void verifySocialMediaMenuTest(){
		admin_ModulePage.ClickonSocialMediaMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "Provider List","Page Header is not matched");
	}
	
	
	@Test(priority=20, enabled=true)
	public void verifyOAuthClientMenuTest(){
		admin_ModulePage.ClickonOAuthClientMenu();
		actual_heading = driver.findElement(By.xpath("//*[@id='search-results']//h1")).getText();
		Assert.assertEquals(actual_heading, "OAuth Client List","Page Header is not matched");
	}
		
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
