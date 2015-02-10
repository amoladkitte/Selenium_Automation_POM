package com.erisite.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.erisite.Pages.AccountsTab;
import com.erisite.Pages.HomePage;
import com.erisite.Pages.LoginPage;
import com.erisite.Pages.NewUserCreation;
import com.erisite.Pages.WorkAreaPage;
import com.erisite.model.MainForm;
import com.erisite.utils.FileReader;
import com.erisite.utils.SeleniumConstructs;

public class UserCreationFlow {
	static WebDriver driver = null;

	public static void main(String args[]) {
		driver = SeleniumConstructs.getDriver();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin();

		WorkAreaPage workarea = new WorkAreaPage(driver);
		workarea.doClickOnGlobal();

		HomePage homepage = new HomePage(driver);

		homepage.doClickOnAddressBookLink();

		homepage.doClickOnUserLink();
		homepage.doClickOnNewButton();

		homepage.doClickOnExternalUserButton();
		homepage.doSwitchNewWindow();

		NewUserCreation newUser = new NewUserCreation(driver);

		List<MainForm> mainForms = FileReader
				.readCsvData("C:\\Users\\318759\\Desktop\\Book1.csv");

		for (MainForm form : mainForms) {

			newUser.doEnterEmployeeId(form.getEmployeeId());
			newUser.doEnterFirstName(form.getFirstName());
			newUser.doEnterLastName(form.getLastName());

			newUser.doEnterEmployedBy(form.getEmployeeBy());
			newUser.doClickOnLookUpButton();
			newUser.doSwitchNewWindowPopup();
			newUser.doClickOnOkButton();
		
			AccountsTab accTab = new AccountsTab(driver);
			accTab.doClickAccountLink();
			accTab.doClickCreateAccountButton();
			accTab.switchCreateAccountPopup();
			accTab.switchFrameCreateAccount();

			accTab.selectAccountType();
			accTab.selectCountryAccess();
			accTab.doEnterUserNameValue(form.getUserName());
			accTab.doEnterPasswordValue(form.getPassword());
			accTab.doEnterConfirmPasswordValue(form.getConfirmPassword());
			accTab.selectPasswordNvrExpire();
			accTab.doClickOkButton();
			accTab.selectSecurityCategory();
		}
		

		/* For LookUp Open and Select Value from it */
		// newUser.doClickOnLookUpButton();
		// newUser.doSwitchNewWindowPopup();
		// newUser.SwitchToNewPicklistFrame();

		// driver.quit();
	}
}