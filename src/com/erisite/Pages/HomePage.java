package com.erisite.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	By linkAddressBook = By.linkText("Address Book");
	By linkUser = By.linkText("User");
	By ButtonNew = By.id("V_Toolbar_NewButton_Button");
	By ButtonExternalUser = By.id("V_Toolbar_NewButton_NewSubType0_Button");
	//By EmployeeID = By.id("V_StaffDetails__ctl1_StaffID_TheTextBox");
		
	private WebDriver driver;
	//private WebElement element;
	private String windowhandlebefore, popupHandle; 
	//private static String popupHandle1;
			
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
		
	public void doClickOnAddressBookLink() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(linkAddressBook));
		driver.findElement(linkAddressBook).click();
	}
	
	public void doClickOnUserLink(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(linkUser));
		driver.findElement(linkUser).click();
		
	}
	
	public void doClickOnNewButton(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ButtonNew));
		driver.findElement(ButtonNew).click();
		
	}
	
	public void doClickOnExternalUserButton(){
		
		windowhandlebefore = driver.getWindowHandle();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ButtonExternalUser));
		driver.findElement(ButtonExternalUser).click();
		
	}
	
	
	public void doSwitchNewWindow()
	{
			
		Set s=driver.getWindowHandles();
		
		Iterator ite=s.iterator();
		
		while (ite.hasNext()) {
			
			popupHandle=ite.next().toString();
			
			if(!popupHandle.contains(windowhandlebefore))
			{
				driver.switchTo().window(popupHandle);
				
				System.out.println("switched to new window : "+popupHandle);
				driver.manage().window().maximize();
				System.out.println(" New window : "+driver.getTitle());		
			}
				
		}
		
	}
		
	/*public void doSwitchNewWindow1()
		{
				
			Set s=driver.getWindowHandles();
			
			Iterator ite=s.iterator();
			
			while (ite.hasNext()) {
				
				
				popupHandle1=ite.next().toString();
				
				
				if(!popupHandle1.contains(popupHandle))
				{
					
					System.out.println("New window "+popupHandle1);
					
					driver.switchTo().window(popupHandle1);
					
					System.out.println("switched to new window : "+popupHandle1);
					//driver.manage().window().maximize();
					
					//popupHandle=driver.getWindowHandle();
					
					//Action on switched window
					
					CharSequence[] employeeId = {"818107"};
					
					new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeSelected(EmployeeID));
					element=driver.findElement(EmployeeID);
					element.sendKeys(employeeId);
					
					System.out.println("value Entered");		
					
				}
				
			}
		
		
		
				
	}
	
		*/
	
	
}
