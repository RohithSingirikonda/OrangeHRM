package com.Temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PIMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rohithsingirikonda.tk");

		WebElement uname = driver.findElement(By.id("txtUsername"));
		uname.clear();
		uname.sendKeys("Admin");
		
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.clear();
		pass.sendKeys("Rohith$123#");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).build().perform();
		
		action.moveToElement(driver.findElement(By.id("menu_pim_Configuration"))).build().perform();
		
		action.moveToElement(driver.findElement(By.id("menu_pim_configurePim"))).click().build().perform();


	}

}
