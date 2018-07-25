package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class PIMModulePage extends TestBase{

	Actions action = new Actions(driver);
	
	@FindBy(xpath="//*[@id='employee-information']//h1")
	WebElement pim_Header;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pim_btn;
	
	@FindBy(id="menu_pim_Configuration")
	WebElement config_Option;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement viewEmployee_Option;
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement addEmployee_Option;
	
	@FindBy(id="menu_core_viewDefinedPredefinedReports")
	WebElement reports_Option;
	
	
	public PIMModulePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String PIMPageHeader(){
		String header = driver.findElement(By.xpath("//div[@class='head']//h1")).getText();
		return header;
	}
	
	
	
	//Configuration Menu
	public OptionalFieldsPage ClickonOptionalFieldsMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_pim_configurePim"))).click().build().perform();
		return new OptionalFieldsPage();
	}
		

	public CustomFieldsPage ClickonCustomFieldsMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_pim_listCustomFields"))).click().build().perform();
		return new CustomFieldsPage();
	}


	public Employee_DataImportPage ClickonEmpDataImportMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_admin_pimCsvImport"))).click().build().perform();
		return new Employee_DataImportPage();
	}


	public ReportingMethodsPage ClickonRepotingMethodsMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_pim_viewReportingMethods"))).click().build().perform();
		return new ReportingMethodsPage();
	}

	
	public TerminationReasonsPage ClickonTerminationsReasonsMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_pim_viewTerminationReasons"))).click().build().perform();
		return new TerminationReasonsPage();
	}


	//Employee List Menu
	public EmployeeListPage ClickonEmployeeListMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_pim_viewEmployeeList"))).click().build().perform();
		return new EmployeeListPage();
	}
	

	//Add Employee Menu
	public EmployeeListPage ClickonAddEmployeeMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_pim_addEmployee"))).click().build().perform();
		return new EmployeeListPage();
	}
	

	//Reports Menu
	public ReportingMethodsPage ClickonReportsMenu(){
		action.moveToElement(pim_btn).
		moveToElement(config_Option).
		moveToElement(driver.findElement(By.id("menu_core_viewDefinedPredefinedReports"))).click().build().perform();
		return new ReportingMethodsPage();
	}
	
	
	
	
}
