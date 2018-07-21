package com.Temp;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		
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
		
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.id("aboutDisplayLink")).click();
		
		
		List<WebElement> text =  driver.findElements(By.xpath("//div[@class='modal-body']//div[@id='companyInfo']//li"));
		//System.out.println(text.size());
		
		Iterator<WebElement> itr = text.iterator();
		
		while(itr.hasNext()) {
		    System.out.println(itr.next().getText());
		}
		
		System.out.println("*****************Click Close Popup*****************");
		
		driver.findElement(By.xpath("//div[@id='displayAbout']//a[@class='close']")).click();
		System.out.println("*****************Popup Closed*****************");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("*****************Logging out*****************");
		driver.close();
		
		
	}

}
