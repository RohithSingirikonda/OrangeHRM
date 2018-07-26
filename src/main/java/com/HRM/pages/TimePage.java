package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class TimePage extends TestBase{
	
	Actions action = new Actions(driver);
	
	@FindBy(id="menu_time_viewTimeModule")
	WebElement time_btn;
	
	@FindBy(id="menu_time_Timesheets")
	WebElement timeSheets_Option;
	
	@FindBy(id="menu_attendance_Attendance")
	WebElement attendence_Option;
	
	@FindBy(id="menu_time_Reports")
	WebElement reports_Option;
	
	@FindBy(id="menu_admin_ProjectInfo")
	WebElement projectInfo_Option;
	
	
	public TimePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String TimePageHeader(){
		String header = driver.findElement(By.xpath("//div[@id='content']//div[2]//h1")).getText();
		return header;
	}
	
	
	// TimeSheets menu
	
	public EmployeeTimeSheetsPage ClickOnEmployeeTimeSheetsMenu(){
		action.moveToElement(time_btn).
		moveToElement(timeSheets_Option).
		moveToElement(driver.findElement(By.id("menu_time_viewEmployeeTimesheet"))).click().build().perform();
		return new EmployeeTimeSheetsPage();
	}

	
	
	// Attendence menu
	
	public EmployeeRecords ClickOnEmployeeRecordsMenu(){
		action.moveToElement(time_btn).
		moveToElement(attendence_Option).
		moveToElement(driver.findElement(By.id("menu_attendance_viewAttendanceRecord"))).click().build().perform();
		return new EmployeeRecords();
	}
	
	
	public ConfigurationPage ClickOnAttendenceConfigMenu(){
		action.moveToElement(time_btn).
		moveToElement(attendence_Option).
		moveToElement(driver.findElement(By.id("menu_attendance_configure"))).click().build().perform();
		return new ConfigurationPage();
	}
	
	
	
	// Reports menu
	
	public ProjectReportsPage ClickOnProjectReportsMenu(){
		action.moveToElement(time_btn).
		moveToElement(reports_Option).
		moveToElement(driver.findElement(By.id("menu_time_displayProjectReportCriteria"))).click().build().perform();
		return new ProjectReportsPage();
	}
	
	
	public EmployeeReportsPage ClickOnEmployeeReportsMenu(){
		action.moveToElement(time_btn).
		moveToElement(reports_Option).
		moveToElement(driver.findElement(By.id("menu_time_displayEmployeeReportCriteria"))).click().build().perform();
		return new EmployeeReportsPage();
	}
	
	
	public AttendanceSummaryPage ClickOnAttendanceSummaryMenu(){
		action.moveToElement(time_btn).
		moveToElement(reports_Option).
		moveToElement(driver.findElement(By.id("menu_time_displayAttendanceSummaryReportCriteria"))).click().build().perform();
		return new AttendanceSummaryPage();
	}
	
	
	// Project Info Menu
	
	public CustomersPage ClickOnCustomersMenu(){
		action.moveToElement(time_btn).
		moveToElement(projectInfo_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewCustomers"))).click().build().perform();
		return new CustomersPage();
	}
	
	
	public ProjectsPage ClickOnProjectsMenu(){
		action.moveToElement(time_btn).
		moveToElement(projectInfo_Option).
		moveToElement(driver.findElement(By.id("menu_admin_viewProjects"))).click().build().perform();
		return new ProjectsPage();
	}
	
	

}
