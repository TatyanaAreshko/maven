package org.example;

import com.pinterest.login.MainPage;
import com.pinterest.login.SavedBoardPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(CustomLogger.class)
public class PrivateRoomTest extends BaseTest {
    private MainPage mainPage;
    private SavedBoardPage savedBoardPage;
    private final String NAME_BOARD = "TestBoard";
    private final String EDIT_NAME_BOARD = "New Test Board2";
    private final String EDIT_DESC_BOARD = "This is description2";

    // до каждого теста личного аккаунта должен быть осуществлен переход на страницу личного аккаунта
    @Description("Переход на страницу личного аккаунта пользователя")
    @BeforeMethod
    public void goToAccount() {
        mainPage = new MainPage(driver);
        mainPage.EnterInPersonPageButton.click();
    }

    // здесь будут все тесты по личному аккаунту
    @Description("Создание новой доски")
    @Test
    public void createBoard() {
        savedBoardPage = new SavedBoardPage(driver)
                .addButton()
                .addBoardButton()
                .enterBoard(NAME_BOARD)
                .doneButton()
                .popupCloseButton();
    }

    @Description("Редактирование доски")
    @Test
    public void editBoard() {
        savedBoardPage = new SavedBoardPage(driver)
                .focus()
                .edit()
                .chooseEdit()
                .clearName()
                .boardEditName(EDIT_NAME_BOARD)
                .clearDesc()
                .editBoardDescArea(EDIT_DESC_BOARD)
                .secretCheckbox()
                .editBoardCloseButton();
    }

    @Description("Удаление доски")
    @Test
    public void deleteBoard() {
        savedBoardPage = new SavedBoardPage(driver)
                .focus()
                .edit()
                .chooseEdit()
                .deleteBoard()
                .deleteBoardButton();
    }

    // после каждого метода программа должна вернуться на главную страницу аккаунта,
    // чтобы продолжить тестировать другие функции
    @AfterMethod
    public void backToPrivateRoom() {
        savedBoardPage.goToThisPage();
    }


}
