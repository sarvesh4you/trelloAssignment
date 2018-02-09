package com.smartassistant.trello.tests;

import static com.smartassistant.automation.utils.PropertyFileReaderAndWriter.getPropertyFromTestData;


import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smartassistant.automation.TestSessionInitiator;


public class Trello_Test_Login_And_AddCommentToAnExistingCard {
	
	TestSessionInitiator test;
	
	

	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator();
		
	}

	@BeforeMethod
    public void handleTestMethodName(Method method){
        test.stepStartMessage(method.getName()); 
    }
	
	
	/**
	 *  Trello Test - Open browser and verify user is able to launch the application
	 */
	@Test(priority = 1)
	public void Step01_Launch_Trello_Application() {
		 
		test.launchApplication(getPropertyFromTestData("baseUrl"));	
	}
	
	
	/**
	 *  Trello Test - Verify user is successfully able to login to the application using valid credentials
	 */
	@Test(priority = 2, dependsOnMethods = "Step01_Launch_Trello_Application")
	public void Step02_Login_To_The_Application(){
		test.loginPage.loginToTheTrelloApplication(getPropertyFromTestData("userName"),getPropertyFromTestData("passWord"));
		test.homePage.verifyUserIsOnTrelloHomePage();
		
	}
	
	
	/**
	 *  Trello Test - Verify user is successfully able to add a comment to an existing card in an existing board
	 */
	@Test(priority = 3, dependsOnMethods = "Step02_Login_To_The_Application")
	public void Step03_Make_A_Comment_On_Existing_Card_In_Esixting_Board(){
		test.homePage.verifyUserIsOnTrelloHomePage();
		test.homePage.clickOnExistingBoard(getPropertyFromTestData("boardName"));
		test.boardPage.verifyUserIsOnTrelloBoardPage();
		test.boardPage.clickOnExistingCard(getPropertyFromTestData("listName"), getPropertyFromTestData("cardName"));
		test.boardPage.addCommentinExistingCard(getPropertyFromTestData("comment"));
		
	}
	

	/**
	 *  Trello Test - Close the browser session
	 */
	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
	}

}
