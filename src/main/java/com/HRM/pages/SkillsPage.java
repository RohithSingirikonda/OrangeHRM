package com.HRM.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.HRM.base.TestBase;

public class SkillsPage extends TestBase {
	
	public static String message;
	
	@FindBy(xpath="//*[@id='recordsListDiv']//h1")
	WebElement page_header;
	
	@FindBy(xpath="//*[@id='saveFormDiv']//h1")
	WebElement add_header;
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	@FindBy(id="btnDel")
	WebElement delbtn;
	
	@FindBy(id="skill_name")
	WebElement skill_name;
	
	@FindBy(id="skill_description")
	WebElement skill_desc;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	@FindBy(id="btnCancel")
	WebElement cancelbtn;
	
	
	@FindBy(xpath="//*[@class='validation-error']")
	WebElement validation_error;
	
	public SkillsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String SkillsPageHeader(){
		return page_header.getText();
	}
	
	public String AddSkillsPageHeader(){
		addbtn.click();
		return add_header.getText();
	}
	
	
	public String AddSkill(String skill, String desc){
		 
		addbtn.click();
		skill_name.sendKeys(skill);
		skill_desc.sendKeys(desc);
		savebtn.click();
		
		try {
			
		    if (skill.isEmpty()) {
				message = validation_error.getText();
			}else {
				List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a"));
							
				for (WebElement ele : totalList) {
					String temp = ele.getText();
						
					if(temp.contains(skill)){
						message = validation_error.getText();
						break;
					}
					else
						throw new NoSuchElementException();
				}
			}
			
		} catch (NoSuchElementException e) {
			message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
		}
		
		return message;
	}
	
	
	public String DeleteSkill(String skill){
		
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]"));
		
		for (WebElement ele : totalList) {
				String temp = ele.getText();
				System.out.println(temp);
			
			if (temp.contains(skill)) {
				WebElement skill_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+skill+"']//parent::td//preceding-sibling::td"));
				skill_selected.click();
				delbtn.click();
				message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
				break;
			} else {
				boolean disable = delbtn.isEnabled();
				Assert.assertFalse(disable);
			}
		}
			
		return message;
	}
	
	
	public String EditSkill(String existingskill, String newskill){
		List<WebElement> totalList = driver.findElements(By.xpath("//*[@id='recordsListTable']//tbody//tr//td[2]//a"));
		
		for (WebElement ele : totalList) {
			String temp = ele.getText();
			
		if (temp.contains(existingskill)) {
				WebElement skill_selected = driver.findElement(By.xpath("//*[@id='recordsListTable']//tbody//td[2]//a[text()='"+existingskill+"']"));
				skill_selected.click();
				skill_name.clear();
				skill_name.sendKeys(newskill);
				savebtn.click();
				
				if (!newskill.isEmpty()){
					message = driver.findElement(By.xpath("//div[contains(@class, 'message success fadable')]")).getText();
					break;
				}
				else {
					message = validation_error.getText();
					break;
				}
			}
		}
			
		return message;
	}
	

}

