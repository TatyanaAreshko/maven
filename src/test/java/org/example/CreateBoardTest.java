package org.example;

import com.pinterest.login.LoginPage;
import com.pinterest.login.MainPage;
import com.pinterest.login.SavedBoardPage;
import org.testng.annotations.Test;

public class CreateBoardTest extends BaseTest {

    private SavedBoardPage savedBoardPage;
    public MainPage mainPage;
    private LoginPage loginPage;
    
    private final String NAME_BOARD = "TestBoard";

    @Test
    public void createBoard() throws InterruptedException {

        savedBoardPage = new SavedBoardPage(driver);
        /*new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                        (By.xpath("//div[@data-test-id='boardActionsButton']")));*/
        savedBoardPage.addButton.click();
        savedBoardPage.addBoardButton.click();
        savedBoardPage.enterBoard(NAME_BOARD);
        savedBoardPage.doneButton.click();
    }




}
