package com.HRM.pages;

import org.openqa.selenium.Alert;
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
	
	
	
	public String clickOnAdminHomeUserAboutLink() {
		username_login.click();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
		
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
	
	
	
	
	public AdminPage clickOnAdminPageLink() {
		username_login.click();
		return new AdminPage();
	}
	
	public PIMPage clickOnPIMPageLink() {
		pimBtn.click();
		return new PIMPage();
		
	}
	
	public LeavePage clickOnLeavePageLink() {
		leaveBtn.click();
		return new LeavePage();
		
	}
	
	public TimePage clickOnTimePageLink() {
		timeBtn.click();
		return new TimePage();
	}
	
	public TimePage clickOnRecruitmentPageLink() {
		recruitmentBtn.click();
		return new TimePage();
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
