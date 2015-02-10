package com.erisite.Pages;

import java.awt.List;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsTab {

	By tabAccount = By.id("V_MenuLinks_UserAccountLink");
	By createAccount= By.id("V_UserAccountDetails__ctl4__ctl2_Button");
	By ContentFrame= By.name("ContentFrame");
	By accountType= By.name("Layout:Properties:CommonProperties:LoginType:_ctl2");
	
	By okButton= By.id("Layout_FooterButtons_OkButton");

	By countryAccess = By.id("Layout_Properties_CommonProperties_WorkspaceAccess__ctl2");
	By userName = By.id("Layout_Properties_CommonProperties_UserName_TextValue");
	By password = By.id("Layout_Properties_PasswordProperties_Password_TextValue");
	By confirmPswd = By.id("Layout_Properties_PasswordProperties_ConfirmPassword_TextValue");
	By pswdNvrExpire = By.id("Layout_Properties_PasswordMaxAgeControl__ctl2__ctl5");
	
	By securityCategory = By.name("V:UserSecurityProfile:CategoryRow:UserSecurityCategory");
	By analyticsCheck	= By.id("V_UserLicensingProfile_Analytics__ctl0_BoolCheckBox");
	By progManagement = By.name("V:UserLicensingProfile:Program_32_and_32_Project_32_ManagementRow:Program_32_and_32_Project_32_ManagementCmb:List");
	By erisiteViewer = By.id("V_UserLicensingProfile_Proliance_32_Viewer_32_And_32_Redlining__ctl0_BoolCheckBox");
	
	private WebDriver driver;
	private String windowhandlebefore, popupHandle;
	
	public AccountsTab(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	
	public void doClickAccountLink(){
		
		//driver.switchTo().frame("ContentFrame");
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(tabAccount));
		driver.findElement(tabAccount).click();
		
		System.out.println("Switched to account tab");
	}
	
	
	
	public void doClickCreateAccountButton(){
		windowhandlebefore=driver.getWindowHandle();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(createAccount));
		driver.findElement(createAccount).click();
		
	}
	
	public void switchCreateAccountPopup(){
		
			Set s=driver.getWindowHandles();
		
			Iterator ite=s.iterator();
		
			while (ite.hasNext()) {
			
			popupHandle=ite.next().toString();
			System.out.println("Window : "+popupHandle );
			
			if(!popupHandle.contains(windowhandlebefore))
			{
				driver.switchTo().window(popupHandle);
				String str=driver.getTitle();
				
				System.out.println("switched to new window : "+popupHandle +"Window Title is : "+str);
				//driver.manage().window().maximize();
											
			}
				
		}
		
	}
	
	public void switchFrameCreateAccount(){
		
		driver.switchTo().frame(driver.findElement(ContentFrame));
		System.out.println("Switched to Content frame");
		
	}
	
	public void selectAccountType(){
		
		driver.findElement(accountType).click();
		System.out.println("Drop down clicked");
		
		new Select(driver.findElement(accountType)).selectByVisibleText("User Account");
		
				
	}
	
	public void selectCountryAccess(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(countryAccess));
		driver.findElement(countryAccess).click();
	}
	
	public void doEnterUserNameValue(String userNamevalue){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(userName));

		driver.findElement(userName).sendKeys(userNamevalue);
		
	}
	
	public void doEnterPasswordValue(String passwordValue){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(password));

		driver.findElement(password).sendKeys(passwordValue);
		
	}
	
	public void doEnterConfirmPasswordValue(String cofirmPasswordvalue){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(confirmPswd));

		driver.findElement(confirmPswd).sendKeys(cofirmPasswordvalue);
		
	}	
	
	
	public void selectPasswordNvrExpire(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(pswdNvrExpire));
		driver.findElement(pswdNvrExpire).click();
	}
	
		
	public void doClickOkButton(){
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(okButton));
		driver.findElement(okButton).click();
		
		driver.switchTo().window(windowhandlebefore);
		System.out.println("winhandle : " + driver.getTitle());
		driver.switchTo().frame(driver.findElement(ContentFrame));

		System.out.println("Inner frame : " + driver.getTitle());
		
	}
	
	public void selectSecurityCategory(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(securityCategory));
		
		driver.findElement(securityCategory).click();
		System.out.println("Drop down clicked");
		
		new Select(driver.findElement(securityCategory)).selectByVisibleText("Administrator");
		
	}
	
	
	
	
	/*public void selectAccountType(){
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(accountType));
		driver.findElement(accountType).click();
		
		
	}*/
	
}
