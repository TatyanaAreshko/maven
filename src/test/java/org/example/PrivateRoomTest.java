package org.example;

import com.pinterest.login.MainPage;
import com.pinterest.login.SavedBoardPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrivateRoomTest extends BaseTest{
    private MainPage mainPage;
    private SavedBoardPage savedBoardPage;
    private final String NAME_BOARD = "TestBoard";

    @BeforeMethod
    public void goToAccount() {
        mainPage = new MainPage(driver);
        mainPage.EnterInPersonPageButton.click();
    }

    @Test
    public void createBoard(){

        savedBoardPage = new SavedBoardPage(driver);
        savedBoardPage.addButton.click();
        savedBoardPage.addBoardButton.click();
        savedBoardPage.enterBoard(NAME_BOARD);
        savedBoardPage.doneButton.click();
        savedBoardPage.popupCloseButton.click();
    }

    @AfterMethod
    public void backToPrivateRoom(){
        savedBoardPage.goToThisPage();
    }



}
