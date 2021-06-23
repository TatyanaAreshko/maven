package org.example;

import com.pinterest.login.HomePage;
import com.pinterest.login.RegistrationPage;
import io.qameta.allure.Description;
import listener.CustomLogger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomLogger.class)
public class RegistrationTest extends BaseTest{

    private RegistrationPage registrationPage;
    private HomePage homePage;
    private final String VALID_REG_EMAIL = "2wkbh@wimsg.com";
    // Временная почта https://www.crazymailing.com/ru/
    private final String VALID_REG_PASS = "Test123";
    private final String VALID_REG_AGE = "18";


    @Description("Регистрация нового пользователя сайта")
    @Test

    public void RegisterTest(){
        new HomePage(driver)
            .open()
            .regInButton();
        new RegistrationPage(driver)
            .enterRegEmail(VALID_REG_EMAIL)
            .enterRegPass(VALID_REG_PASS)
            .enterRegAge(VALID_REG_AGE)
            .regButton();
        tearDown();
        System.out.println("Регистрация прошла успешно");
    }


}
