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
	WebElement qualofications_Option;
	
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
	
		
	public UsersPage ClickonUsersMenu(){
		action.moveToElement(AdminBtn).
		moveToElement(UserMgmt_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewSystemUsers"))).click().build().perform();
		return new UsersPage();
	}
	
	
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
	

	
}
