package com.smartassistant.trello.keywords;

import org.openqa.selenium.WebDriver;

import com.smartassistant.automation.getpageobjects.GetPage;

public class LoginPageActions extends GetPage {
	
	WebDriver driver;

    public LoginPageActions(WebDriver driver) {
        super(driver, "LoginPage");
        this.driver = driver;
    }

    
    /**
	 * Method which verifies that Login Page is displayed
	 */
	public void verifyUserIsOnTrelloLoginPage() {	
		verifyPageTitleContains();
		isElementDisplayed("txt_loginPageHeader");	
		logMessage("User is on  Login Page of the application.");
	}


	/**
	 * Method which enter 'username' & 'password' and Login to the application 
	 * 
	 */
	public void loginToTheTrelloApplication(String userName, String passWord) {
		click(element("lnk_login"));
		verifyUserIsOnTrelloLoginPage();
		enterText(element("txtFld_userName"), userName);
		enterText(element("txtFld_passWord"), passWord);
		click(element("btn_login "));
		logMessage("User clicked on Login button.");
			
	}




}
