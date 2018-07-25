package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class LeavePage extends TestBase{

	Actions action = new Actions(driver);
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement Leave_btn;
	
	@FindBy(id="menu_leave_Entitlements")
	WebElement entitlement_Option;
	
	@FindBy(id="menu_leave_Reports")
	WebElement reports_Option;
	
	@FindBy(id="menu_leave_Configure")
	WebElement leaveConfig_Option;
	
	@FindBy(id="menu_leave_viewLeaveList")
	WebElement viewLeaveList_Option;
	
	@FindBy(id="menu_leave_assignLeave")
	WebElement assignLeave_Option;
	
	
	
	public LeavePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String LeavePageHeader(){
		String header = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		return header;
	}
	
	
	
	//Entitlements Menu

	public AddEntitlementsPage ClickOnAddEntitlementsMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(entitlement_Option).
		moveToElement(driver.findElement(By.id("menu_leave_addLeaveEntitlement"))).click().build().perform();
		return new AddEntitlementsPage();
	}
	
	
	public EmployeeEntitlementsPage ClickOnEmployeeEntitlementsMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(entitlement_Option).
		moveToElement(driver.findElement(By.id("menu_leave_viewLeaveEntitlements"))).click().build().perform();
		return new EmployeeEntitlementsPage();
	}
	
	
	
	//Reports Menu
	
	public LeaveUsageReportPage ClickOnLeaveUsageReportMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(reports_Option).
		moveToElement(driver.findElement(By.id("menu_leave_viewLeaveBalanceReport"))).click().build().perform();
		return new LeaveUsageReportPage();
	}
	
	
	
	//Leave Configure Page
	
	public LeavePeriodPage ClickOnLeavePeriodMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(leaveConfig_Option).
		moveToElement(driver.findElement(By.id("menu_leave_defineLeavePeriod"))).click().build().perform();
		return new LeavePeriodPage();
	}
	
	
	public LeaveTypesPage ClickOnLeaveTypesMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(leaveConfig_Option).
		moveToElement(driver.findElement(By.id("menu_leave_leaveTypeList"))).click().build().perform();
		return new LeaveTypesPage();
	}
	
	
	public WorkWeekPage ClickOnWorkWeekPageMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(leaveConfig_Option).
		moveToElement(driver.findElement(By.id("menu_leave_defineWorkWeek"))).click().build().perform();
		return new WorkWeekPage();
	}
	
	
	public HolidaysPage ClickOnHolidaysMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(leaveConfig_Option).
		moveToElement(driver.findElement(By.id("menu_leave_viewHolidayList"))).click().build().perform();
		return new HolidaysPage();
	}
	
	

	//Leave List Page
	
	public LeaveListPage ClickOnLeaveListMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(viewLeaveList_Option).click().build().perform();
		return new LeaveListPage();
	}
	
	
	
	
	//Leave Assign Page
	public AssignLeavePage ClickOnAssignLeaveMenu(){
		action.moveToElement(Leave_btn).
		moveToElement(assignLeave_Option).click().build().perform();
		return new AssignLeavePage();
	}
	

	
	
}
