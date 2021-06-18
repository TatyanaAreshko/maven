package org.example;

import com.pinterest.login.HomePage;
import com.pinterest.login.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    private RegistrationPage registrationPage;
    private HomePage homePage;
    private final String VALID_REG_EMAIL = "p2drv@vmani.com";
    // Временная почта https://www.crazymailing.com/ru/
    private final String VALID_REG_PASS = "Test123";
    private final String VALID_REG_AGE = "18";


    @Test
    public void RegisterTest(){
        homePage = new HomePage(driver);
        homePage.open();
        homePage.regInButton.click();
        registrationPage = new RegistrationPage(driver);
        registrationPage.enterRegEmail(VALID_REG_EMAIL);
        registrationPage.enterRegPass(VALID_REG_PASS);
        registrationPage.enterRegAge(VALID_REG_AGE);
        registrationPage.regButton.click();
        System.out.println("Регистрация прошла успешно");
    }


}
