package com.smartassistant.trello.keywords;

import org.openqa.selenium.WebDriver;

import com.smartassistant.automation.getpageobjects.GetPage;

public class HomePageActions extends GetPage {
	
	WebDriver driver;

    public HomePageActions(WebDriver driver) {
        super(driver, "HomePage");
        this.driver = driver;
    }

    
    /**
	 * Method which verifies that Home Page is displayed
	 */
	public void verifyUserIsOnTrelloHomePage() {	
		verifyPageTitleContains();
		isElementDisplayed("txt_homePageHeader");	
		logMessage("User is on Home Page of the application.");
	}


	/**
	 * Method which takes Board name and click on it.
	 * 
	 */
	public void clickOnExistingBoard(String boardName) {
		click(element("lnk_existingBoard", boardName));
		logMessage("User entered in board : "+boardName);
		
	}




}
