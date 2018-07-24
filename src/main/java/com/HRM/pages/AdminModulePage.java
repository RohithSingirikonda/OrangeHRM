package com.HRM.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;


public class AdminModulePage extends TestBase{

	
	Actions action = new Actions(driver);
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement AdminBtn;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement UserMgmt_Option;
	
	@FindBy(id="menu_admin_Job")
	WebElement job_Option;
	
	@FindBy(id="menu_admin_Organization")
	WebElement organization_Option;
	
	@FindBy(id="menu_admin_Qualifications")
	WebElement qualifications_Option;
	
	@FindBy(id="menu_admin_nationality")
	WebElement nationality_Option;
	
	@FindBy(id="menu_admin_Configuration")
	WebElement configuration_Option;
	
	
	public AdminModulePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String AdminPageHeader(){
		String header = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		return header;
	}
	

	//User Management Menu
	public UsersPage ClickonUsersMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(UserMgmt_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewSystemUsers"))).click().build().perform();
		return new UsersPage();
	}
	
	
	//Job Menu
	
	public JobTitlesPage ClickonJobTitlesMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(job_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewJobTitleList"))).click().build().perform();
		return new JobTitlesPage();
	}
	
	
	public PayGradesPage ClickonPayGradesMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(job_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewPayGrades"))).click().build().perform();
		return new PayGradesPage();
	}
	
	
	public EmploymentStatusPage ClickonEmploymentStatusMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(job_Option).
		moveToElement(driver.findElement(By.id("menu_admin_employmentStatus"))).click().build().perform();
		return new EmploymentStatusPage();
	}
	
	
	public JobCategoriesPage ClickonJobCategoriesMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(job_Option).
		moveToElement(driver.findElement(By.id("menu_admin_jobCategory"))).click().build().perform();
		return new JobCategoriesPage();
	}
	
	
	public WorkShiftsPage ClickonWorkShiftsMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(job_Option).
		moveToElement(driver.findElement(By.id("menu_admin_workShift"))).click().build().perform();
		return new WorkShiftsPage();
	}
	
	
	//Organization Menu
	
	public GeneralInformationPage ClickonGeneralInfoMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(organization_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation"))).click().build().perform();
		return new GeneralInformationPage();
	}
	
	public LocationsPage ClickonLocationsMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(organization_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewLocations"))).click().build().perform();
		return new LocationsPage();
	}
	
	public StructurePage ClickonStructureMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(organization_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewCompanyStructure"))).click().build().perform();
		return new StructurePage();
	}

	
	
	//Qualifications Menu
	
	public SkillsPage ClickonSkillsMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(qualifications_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewSkills"))).click().build().perform();
		return new SkillsPage();
	}
	
	
	public EducationPage ClickonEducationMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(qualifications_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewEducation"))).click().build().perform();
		return new EducationPage();
	}
	
	
	public LicensesPage ClickonLicensesMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(qualifications_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewLicenses"))).click().build().perform();
		return new LicensesPage();
	}
	
	public LanguagePage ClickonlanguagesMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(qualifications_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewLanguages"))).click().build().perform();
		return new LanguagePage();
	}
	
	
	public StructurePage ClickonMembershipsMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(qualifications_Option).
		moveToElement(driver.findElement(By.id("menu_admin_membership"))).click().build().perform();
		return new StructurePage();
	}
	
	
	

	//Nationalities Menu
	
	public NationalitiesPage ClickonNationalitiesMenu(){
		action.moveToElement(nationality_Option).click().build().perform();
		return new NationalitiesPage();
	}
	
	
	
	//Configuration Menu
	
	public EmailConfigurationPage ClickonEmailConfigMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(configuration_Option).
		moveToElement(driver.findElement(By.id("menu_admin_listMailConfiguration"))).click().build().perform();
		return new EmailConfigurationPage();
	}
	
	
	public EmailNotificationsPage ClickonEmailNotifyMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(configuration_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewEmailNotification"))).click().build().perform();
		return new EmailNotificationsPage();
	}
	
	
	public LocalizationPage ClickonLocalizationMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(configuration_Option).
		moveToElement(driver.findElement(By.id("menu_admin_localization"))).click().build().perform();
		return new LocalizationPage();
	}
	
	
	public ModulesConfigurationPage ClickonModulesMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(configuration_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewModules"))).click().build().perform();
		return new ModulesConfigurationPage();
	}
	
	
	public SocailMediaAuthPage ClickonSocialMediaMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(configuration_Option).
		moveToElement(driver.findElement(By.id("menu_admin_openIdProvider"))).click().build().perform();
		return new SocailMediaAuthPage();
	}
	
	
	public OAuthClientPage ClickonOAuthClientMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(configuration_Option).
		moveToElement(driver.findElement(By.id("menu_admin_registerOAuthClient"))).click().build().perform();
		return new OAuthClientPage();
	}
	
	
	
}
