package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class RecruitmentPage extends TestBase{

	
	Actions action = new Actions(driver);
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	WebElement recruitment_btn;
	
	public RecruitmentPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String RecruitmentPageHeader(){
		String header = driver.findElement(By.xpath("//*[@class='head']//h1")).getText();
		return header;		
	}
	
	
	public CandidatesPage ClickOnCandidatesMenu(){
		action.moveToElement(recruitment_btn).
		moveToElement(driver.findElement(By.id("menu_recruitment_viewCandidates"))).click().build().perform();
		return new CandidatesPage();
		
	}
	
	
	public VacanciesPage ClickOnVacanciesMenu(){
		action.moveToElement(recruitment_btn).
		moveToElement(driver.findElement(By.id("menu_recruitment_viewJobVacancy"))).click().build().perform();
		return new VacanciesPage();
		
	}
	
	
}
