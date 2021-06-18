package org.example;

import com.pinterest.login.MainPage;
import com.pinterest.login.SavedBoardPage;
import org.testng.annotations.Test;

public class CreateBoardTest extends BaseTest {

    private SavedBoardPage savedBoardPage;
    public MainPage mainPage;
    private final String NAME_BOARD = "TestBoard";

    @Test
    public void createBoard(){
        mainPage = new MainPage(driver);
        mainPage.EnterInPersonPageButton.click();
        savedBoardPage = new SavedBoardPage(driver);
        savedBoardPage.addButton.click();
        savedBoardPage.addBoardButton.click();
        savedBoardPage.enterBoard(NAME_BOARD);
        savedBoardPage.doneButton.click();
    }
}
