package com.erisite.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WorkAreaPage {
	
	WebDriver driver = null;
	By linkGlobal = By.linkText("Global");
	
	public WorkAreaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doClickOnGlobal() {
		new org.openqa.selenium.support.ui.WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(linkGlobal));
		driver.findElement(linkGlobal).click();
	}
}
