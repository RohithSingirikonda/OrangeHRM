package com.HRM.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import com.HRM.base.TestBase;

public class TestUtil extends TestBase{
	
		
		public static int Implicit_wait = 20;
		public static int PageLoad_Timeout=30;
		
	
	
	
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png"));
		
	}
	
	
}
