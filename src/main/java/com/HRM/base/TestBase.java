package com.HRM.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.text.html.HTML;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.HRM.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener event_listener;
	
	
	public TestBase(){
		
		try {
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/HRM/config/config.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void init(){
		
		String browser_name = prop.getProperty("browser");
		
		if (browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser_name.equals("headless")){
			driver = new HtmlUnitDriver();
		}
		else {
			System.out.println("Assign the Browser Property");
		}
		
		
	}
	
	
	
	
	
	
	
	

}
