package org.example;

import com.pinterest.login.HomePage;
import com.pinterest.login.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest{

    private LoginPage loginPage;
    private HomePage homePage;
    private final String INVALID_PASS = "123";
    private final String INVALID_EMAIL = "abc";
    private final String VALID_EMAIL = "tatyana.areshko@gmail.com";
    private final String VALID_PASS = "Test123123";

    @Test
    public void invalidEmail(){
        homePage = new HomePage(driver);

        homePage.open();
        homePage.signInButton.click();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(VALID_EMAIL);
        loginPage.enterButton.click();
        loginPage.AssertInvalidPassError();
    }

    @AfterClass
    public void quit(){
        loginPage.quit();
    }

}
