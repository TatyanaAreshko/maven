package org.example;

import com.pinterest.login.MainPage;
import com.pinterest.login.SavedBoardPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrivateRoomTest extends BaseTest{
    private MainPage mainPage;
    private SavedBoardPage savedBoardPage;
    private final String NAME_BOARD = "TestBoard";

    // до каждого теста личного аккаунта должен быть осуществлен переход на страницу личного аккаунта
    @BeforeMethod
    public void goToAccount() {
        mainPage = new MainPage(driver);
        mainPage.EnterInPersonPageButton.click();
    }

    // здесь будут все тесты по личному аккаунту
    @Test
    public void createBoard(){
        new SavedBoardPage(driver)
        .addButton()
        .addBoardButton()
        .enterBoard(NAME_BOARD)
        .doneButton()
        .popupCloseButton();
    }

    // после каждого метода программа должна вернуться на главную страницу аккаунта,
    // чтобы продолжить тестировать другие функции
   /* @AfterMethod
    public void backToPrivateRoom(){
        savedBoardPage.goToThisPage();
    }*/



}
