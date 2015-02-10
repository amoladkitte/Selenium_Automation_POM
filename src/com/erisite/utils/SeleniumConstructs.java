package com.erisite.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumConstructs {
	static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.ie.driver", "D://Selenium Jars//IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		return driver;
	}
}
