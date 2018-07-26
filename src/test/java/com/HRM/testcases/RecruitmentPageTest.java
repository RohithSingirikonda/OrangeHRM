package com.HRM.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.base.TestBase;
import com.HRM.pages.AdminHomePage;
import com.HRM.pages.LoginPage;
import com.HRM.pages.RecruitmentPage;

public class RecruitmentPageTest extends TestBase{


	public static String actual_heading;
	
	LoginPage loginPage;
	AdminHomePage admin_HomePage;
	RecruitmentPage recruitment_Page;
	
	
	public RecruitmentPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		admin_HomePage = new AdminHomePage();
		recruitment_Page = new RecruitmentPage();
		admin_HomePage = loginPage.AdminLogin(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
		recruitment_Page = admin_HomePage.clickOnRecruitmentPageLink();
	}
	
	
	@Test(priority=1, enabled=true)
	public void verifyRecruitmentPageHeaderTest(){
		actual_heading =  recruitment_Page.RecruitmentPageHeader();
		Assert.assertEquals(actual_heading, "Candidates", "Page Header is not matched");
	}
	
	
	@Test(priority=2, enabled=true)
	public void verifyCandidatesMenuTest(){
		recruitment_Page.ClickOnCandidatesMenu();
		actual_heading =  driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Candidates", "Page Header is not matched");
	}
	
	
	@Test(priority=3, enabled=true)
	public void verifyVacanciesMenuTest(){
		recruitment_Page.ClickOnVacanciesMenu();
		actual_heading =  driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		Assert.assertEquals(actual_heading, "Vacancies", "Page Header is not matched");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
		
}
