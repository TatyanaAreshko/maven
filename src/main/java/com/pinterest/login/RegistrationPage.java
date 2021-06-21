package com.pinterest.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(id = "email")
    private WebElement emailRegInput;

    @FindBy(id = "password")
    private WebElement passwordRegInput;

    @FindBy(id = "age")
    private WebElement ageRegInput;

    @FindBy(xpath = "//div[@data-test-id='registerFormSubmitButton']")
    public WebElement regButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод валидного email в поле логина на странице регистрации")
    public RegistrationPage enterRegEmail(String regEmail){
        emailRegInput.sendKeys(regEmail);
        return this;
    }

    @Step("Ввод валидного пароля в поле пароля на странице регистрации")
    public RegistrationPage enterRegPass(String regPass){
        passwordRegInput.sendKeys(regPass);
        return this;
    }

    @Step("Нажать кнопку регистрации")
    public RegistrationPage enterRegAge(String regAge){
        ageRegInput.sendKeys(regAge);
        return this;
    }

    @Step("Нажать внопку завершения регистрации")
    public RegistrationPage regButton(){
        regButton.click();
        return this;
    }


}
