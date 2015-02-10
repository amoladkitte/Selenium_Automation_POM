package com.erisite.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewUserCreation {

	By IdEmployee = By.id("V_StaffDetails__ctl1_StaffID_TheTextBox");
	By InnerFrame = By.id("InnerFrame");
	By FirstName = By.id("V_StaffDetails__ctl2_FirstName_TheTextBox");
	By LastName = By.id("V_StaffDetails__ctl4_LastName_TheTextBox");

	By LookUpButton = By
			.id("V_StaffDetails_RefCompanyDocument_ParentReference_MyNameTextBox_layout_MyPopupButton");
	By EmployedBy = By
			.id("V_StaffDetails_RefCompanyDocument_ParentReference_MyNameTextBox_layout_TheTextBox");
	By SearchTextBox = By.id("SearchTextBox");
	By OkButtonClick = By.id("OKButtonMiddle");

	private String windowhandlebefore, popupHandle;
	private WebDriver driver;

	public NewUserCreation(WebDriver driver) {
		this.driver = driver;
	}

	public void doEnterEmployeeId(String employeeId) {

		driver.switchTo().frame(driver.findElement(InnerFrame));

		System.out.println("switched to new frame");
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.visibilityOfElementLocated(IdEmployee));

		driver.findElement(IdEmployee).sendKeys(employeeId);

	}

	public void doEnterFirstName(String firstName) {

		// System.out.println("switched to new frame");
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.visibilityOfElementLocated(FirstName));

		driver.findElement(FirstName).sendKeys(firstName);

	}

	public void doEnterLastName(String lastName) {

		// System.out.println("switched to new frame");
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.visibilityOfElementLocated(LastName));

		driver.findElement(LastName).sendKeys(lastName);

	}

	public void doEnterEmployedBy(String employeeBy) {

		// System.out.println("switched to new frame");
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.visibilityOfElementLocated(EmployedBy));

		driver.findElement(EmployedBy).sendKeys(employeeBy);

	}

	// CODE TO OPEN LOOK UP ENTER SEARCH AND SELECT VALUE

	public void doClickOnLookUpButton() {

		windowhandlebefore = driver.getWindowHandle();
		System.out.println("winhandle : " + driver.getTitle());
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.elementToBeClickable(LookUpButton));
		driver.findElement(LookUpButton).click();

	}

	public void doClickOnOkButton() {

		driver.switchTo().frame(driver.findElement(InnerFrame));

		System.out.println("switched to new frame");

		new WebDriverWait(driver, 20).until(ExpectedConditions
				.elementToBeClickable(OkButtonClick));
		driver.findElement(OkButtonClick).click();
		driver.switchTo().window(windowhandlebefore);
		System.out.println("winhandle : " + driver.getTitle());
		driver.switchTo().frame(driver.findElement(InnerFrame));

		System.out.println("Inner frame : " + driver.getTitle());

	}

	public void doSwitchNewWindowPopup() {

		Set s = driver.getWindowHandles();

		Iterator ite = s.iterator();

		while (ite.hasNext()) {

			popupHandle = ite.next().toString();

			if (!popupHandle.contains(windowhandlebefore)) {
				driver.switchTo().window(popupHandle);
				String str = driver.getTitle();

				System.out.println("switched to new window : " + popupHandle
						+ "Window Title is : " + str);
				// driver.manage().window().maximize();

			}

		}

	}

	// public void SwitchToNewPicklistFrame(){

	// driver.switchTo().frame(driver.findElement(By.name("ContentFrame")));

	// CharSequence[] SearchText = { "FSO-0001-FSO-0004" };

	// System.out.println("switched to new frame "+driver.getTitle());
	// //new WebDriverWait(driver,
	// 20).until(ExpectedConditions.visibilityOfElementLocated(SearchTextBox));

	// driver.findElement(SearchTextBox).sendKeys(SearchText);

	// }
	// */
	/*
	 * public void doEnterSearch() { CharSequence[] SearchText = {
	 * "FSO-0001-FSO-0004" };
	 * 
	 * //System.out.println("switched to new frame"); new WebDriverWait(driver,
	 * 20).until(ExpectedConditions.visibilityOfElementLocated(SearchTextBox));
	 * 
	 * driver.findElement(SearchTextBox).sendKeys(SearchText);
	 * 
	 * 
	 * }
	 */

}
