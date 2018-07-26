package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class PerformancePage extends TestBase{
	
	Actions action = new Actions(driver);
	
	@FindBy(id="menu__Performance")
	WebElement performance_Btn;
	
	@FindBy(id="menu_performance_Configure")
	WebElement configure_Option;
	
	@FindBy(id="menu_performance_ManageReviews")
	WebElement manageReviews_Option;
	
	@FindBy(id="menu_performance_viewEmployeePerformanceTrackerList")
	WebElement employeeTrackers_Option;

	
	public PerformancePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	// Configure Menu
	
	public KPIsPage ClickOnKPIsMenu(){
		action.moveToElement(performance_Btn).
		moveToElement(configure_Option).
		moveToElement(driver.findElement(By.id("menu_performance_searchKpi"))).click().build().perform();
		return new KPIsPage();
	}
	
	
	public TrackersPage ClickOnTrackersMenu(){
		action.moveToElement(performance_Btn).
		moveToElement(configure_Option).
		moveToElement(driver.findElement(By.id("menu_performance_addPerformanceTracker"))).click().build().perform();
		return new TrackersPage();
	}
	
	
	
	// Manage Reviews Menu
	
	public ManageReviewsPage ClickOnManageReviewsMenu(){
		action.moveToElement(performance_Btn).
		moveToElement(manageReviews_Option).
		moveToElement(driver.findElement(By.id("menu_performance_searchPerformancReview"))).click().build().perform();
		return new ManageReviewsPage();
	}
	
	
	
	// Employee Trackers Menu
	
	public EmployeeTrackersPage ClickOnEmployeeTrackersMenu(){
		action.moveToElement(performance_Btn).
		moveToElement(employeeTrackers_Option).click().build().perform();
		return new EmployeeTrackersPage();
	}
	
	
}
