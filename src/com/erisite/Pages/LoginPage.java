package com.erisite.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver = null;
	By txtOrganization = By.id("OrgNameTextbox");
	By txtUsrname = By.xpath("//input[@id='UserNameTextbox']");
	By txtPasswrd = By.id("PasswordTextbox");
	By btnLogin = By.id("LoginButton");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get("http://10.232.198.72/Proliance/WebUI/Login.aspx");
	}

	public void doLogin() {
		CharSequence[] organization = {"testconfig"};
		CharSequence[] username = {"admin"};
		CharSequence[] password = {"p"};
		driver.findElement(txtOrganization).sendKeys(organization);
		driver.findElement(txtUsrname).sendKeys(username);
		driver.findElement(txtPasswrd).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
}
