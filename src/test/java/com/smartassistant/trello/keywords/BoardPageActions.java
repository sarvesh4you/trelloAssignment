package com.smartassistant.trello.keywords;

import org.openqa.selenium.WebDriver;

import com.smartassistant.automation.getpageobjects.GetPage;


public class BoardPageActions extends GetPage {
	
	WebDriver driver;

    public BoardPageActions(WebDriver driver) {
        super(driver, "boardPage");
        this.driver = driver;
    }

    
    /**
	 * Method which verifies that Board Page is displayed
	 */
	public void verifyUserIsOnTrelloBoardPage() {	
		verifyPageTitleContains();
		isElementDisplayed("txt_boardPageHeader");	
		logMessage("User is on Board Page of the application.");
	}


	/**
	 * Method which takes List and Card names and click on them.
	 */
	public void clickOnExistingCard(String listName, String cardName) {
		click(element("lnk_existingCard", listName, cardName));
		logMessage("User clicked on Card "+cardName+" under List "+listName);
		
	}


	/**
	 * Method which adds a comment in the existing card.
	 */
	public void addCommentinExistingCard(String comment) {
		verifyPageTitleContains();
		
		enterText(element("txtArea_addComment"),comment);
		logMessage("User entered comment: "+comment);
		
		click(element("btn_saveComment"));
		logMessage("User clicked on Save button");
		
		isElementDisplayed("text_comment", comment);
		
	}




}
