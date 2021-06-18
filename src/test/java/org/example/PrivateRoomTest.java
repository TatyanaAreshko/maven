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

    // до каждого теста личного аккаунта должен быть осуществлен входна личный аккаунт
    @BeforeMethod
    public void goToAccount() {
        mainPage = new MainPage(driver);
        mainPage.EnterInPersonPageButton.click();
    }

    // здесь будут все тесты по личному аккаунту
    @Test
    public void createBoard(){

        savedBoardPage = new SavedBoardPage(driver);
        savedBoardPage.addButton.click();
        savedBoardPage.addBoardButton.click();
        savedBoardPage.enterBoard(NAME_BOARD);
        savedBoardPage.doneButton.click();
        savedBoardPage.popupCloseButton.click();
    }

    // после каждого метода программа должна вернуться на главную страницу аккаунта,
    // чтобы продолжить тестировать другие функции
    @AfterMethod
    public void backToPrivateRoom(){
        savedBoardPage.goToThisPage();
    }



}
