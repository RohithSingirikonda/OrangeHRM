package com.HRM.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class PayGradesPage extends TestBase{

	@FindBy(xpath="//*[@class='head']//h1")
	WebElement page_header;
	
	@FindBy(id="btnAdd")
	WebElement btn_add;
	
	@FindBy(id="btnDelete")
	WebElement btn_delete;
	
	public PayGradesPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String PayGradesPageHeader(){
		String header = page_header.getText();
		return header;
	}
	
	
	public AddPayGradePage AddPayGrade(){
		btn_add.click();
		return new AddPayGradePage();	
	}

	
	
	public void DeletepayGrades(String JobTitle, String validation){
		
		List<WebElement> Titles = driver.findElements(By.xpath("//td[@class='left']//a"));
		
		for (int i = 0; i < Titles.size(); i++) {
			
			String text = Titles.get(i).getText();
			
			if (text.equals(JobTitle)) {
					driver.findElement(By.xpath("//a[contains(text(),'"+ text +"')]//parent::td[@class='left']//preceding-sibling::td//input")).click();
					btn_delete.click();
					if (validation.equals("TRUE")) {
						driver.findElement(By.xpath("//*[@id='deleteConfModal']//*[@class='modal-footer']//input[@value='Ok']")).click();
					} else {
						driver.findElement(By.xpath("//*[@id='deleteConfModal']//*[@class='modal-footer']//input[@value='Cancel']")).click();

					}
			}
		}	
	}

	
}
