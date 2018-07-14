package com.Temp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.HRM.util.Xls_Reader;

public class HRM_Test {

	public static void main(String[] args) throws InterruptedException {
		
		String Sheet_Name ="logins";
			
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"/src/test/java/com/Temp/testdata.xlsx");
		
		int rowCount = reader.getRowCount("logins");		
		
		for (int rowNum = 2; rowNum <=rowCount; rowNum++) {
	
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rohith-trials641.orangehrmlive.com/");
			
		
			String email = reader.getCellData(Sheet_Name, "username", rowNum);	
			String pass = reader.getCellData(Sheet_Name, "password", rowNum);
			
			String urlA = driver.getCurrentUrl();
			driver.findElement(By.id("txtUsername")).sendKeys(email);
			driver.findElement(By.id("txtPassword")).sendKeys(pass);
			driver.findElement(By.id("btnLogin")).click();
			
			String urlB = driver.getCurrentUrl();
			
			if (!urlB.equals(urlA)) {
					System.out.println("Login Successfull");
					reader.setCellData(Sheet_Name, "Actual", rowNum, driver.getTitle());
			} else {
				System.out.println("Login Failed");
				String alert = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
				reader.setCellData(Sheet_Name, "Actual", rowNum, alert);
			}
			
			String expected = reader.getCellData(Sheet_Name, "Expected", rowNum);
			String actual = reader.getCellData(Sheet_Name, "Actual", rowNum);
			
			Thread.sleep(1000);
			
			if (actual.equals(expected)) {
				reader.setCellData(Sheet_Name, "Status", rowNum, "Pass");
			} else {
				reader.setCellData(Sheet_Name, "Status", rowNum, "Fail");
			}
			
			
			driver.close();
			
		}
		
	}

}

