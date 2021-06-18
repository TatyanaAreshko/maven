package org.example;

import com.pinterest.login.SavedBoardPage;
import org.testng.annotations.Test;

public class CreateBoardTest extends ValidLoginTest{

    ValidLoginTest validLoginTest = new ValidLoginTest();
    private SavedBoardPage savedBoardPage;
    private final String NAME_BOARD = "TestBoard";

    @Test
    public void createBoard(){
        savedBoardPage.addButton.click();
        savedBoardPage.addBoardButton.click();
        savedBoardPage.enterBoard(NAME_BOARD);
        savedBoardPage.doneButton.click();
    }
}
