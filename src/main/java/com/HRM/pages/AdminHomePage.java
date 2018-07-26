package com.HRM.pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class AdminHomePage extends TestBase {

	
	
	@FindBy(xpath="//div[@id='branding']//img")
	WebElement homePageLogo;
	
	@FindBy(id="welcome")
	WebElement username_login;
	
	@FindBy(id="aboutDisplayLink")
	WebElement aboutLink;
	
	@FindBy(xpath="//a[text()='Change Password']")
	WebElement changePasswordLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutLink;
	
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminBtn;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pimBtn;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement leaveBtn;
	
	@FindBy(id="menu_time_viewTimeModule")
	WebElement timeBtn;
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	WebElement recruitmentBtn;
	
	@FindBy(id="menu__Performance")
	WebElement performanceBtn;
	
	@FindBy(id="menu_dashboard_index")
	WebElement dashboardBtn;
	
	@FindBy(id="menu_directory_viewDirectory")
	WebElement directoryBtn;
	
	
	public AdminHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String AdminHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean AdminHomePageLogo() {
		return homePageLogo.isDisplayed();
	}
	
	
	public String AdminHomePageUser() {
		return username_login.getText();
	}
	
	
	
	public void clickOnAdminHomeUserAboutLink() {
		username_login.click();
		aboutLink.click();
		List<WebElement> text =  driver.findElements(By.xpath("//div[@class='modal-body']//div[@id='companyInfo']//li"));
		Iterator<WebElement> itr = text.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		
	}
	
	public ChangePasswordPage clickOnChangePasswordLink() {
		username_login.click();
		return new ChangePasswordPage();
	}
	
	public LoginPage clickOnLogoutLink() {
		username_login.click();
		logoutLink.click();
		return new LoginPage();
		
	}
	

	public AdminModulePage clickOnAdminPageLink() {
		adminBtn.click();
		return new AdminModulePage();
	}
	
	public PIMModulePage clickOnPIMPageLink() {
		pimBtn.click();
		return new PIMModulePage();
		
	}
	
	public LeavePage clickOnLeavePageLink() {
		leaveBtn.click();
		return new LeavePage();
		
	}
	
	public TimePage clickOnTimePageLink() {
		timeBtn.click();
		return new TimePage();
	}
	
	public RecruitmentPage clickOnRecruitmentPageLink() {
		recruitmentBtn.click();
		return new RecruitmentPage();
	}
	
	public PerformancePage clickOnPerformancePageLink() {
		performanceBtn.click();
		return new PerformancePage();
	}
	
	public DashboardPage clickOnDashboardPageLink() {
		dashboardBtn.click();
		return new DashboardPage();
	}
	
	public DirectoryPage clickOnDirectoryPageLink() {
		directoryBtn.click();
		return new DirectoryPage();
	}
	
	
	
	
}
