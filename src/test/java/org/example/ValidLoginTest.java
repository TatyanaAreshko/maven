package org.example;

import com.pinterest.login.HomePage;
import com.pinterest.login.LoginPage;
import com.pinterest.login.MainPage;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest{

    private LoginPage loginPage;
    private HomePage homePage;
    private MainPage mainPage;
    private final String INVALID_PASS = "123";
    private final String INVALID_EMAIL = "abc";
    private final String VALID_EMAIL = "tatyana.areshko@gmail.com";
    private final String VALID_PASS = "Test123";

    @Test
    public void validEmail(){
        homePage = new HomePage(driver);
        homePage.open();
        homePage.signInButton.click();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(VALID_EMAIL);
        loginPage.enterPass(VALID_PASS);
        loginPage.enterButton.click();
        //loginPage.AssertInvalidPassError();
        //mainPage = new MainPage(driver);
        //mainPage.EnterInPersonPageButton.click();
    }

    /*@AfterClass
    public void quit(){
        loginPage.quit();
    }*/

}
