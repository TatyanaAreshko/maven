package com.pinterest.login;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passInput;

    @FindBy(css = "button.red.SignupButton.active")
    public WebElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод валидного email в поле логина")
    public LoginPage enterEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Ввод валидного пароля")
    public LoginPage enterPass(String pass){
        passInput.sendKeys(pass);
        return this;
    }

    @Step("Нажать кнопку 'Войти'")
    public LoginPage enterButton(){
        enterButton.click();
        return this;
    }

    //@Step("Ошибка при неверном вводе логина")
    public void AssertInvalidEmailError(){
        Assert.assertTrue(emailInput.isDisplayed());
    }

    //@Step("Ошибка при неверном вводе пароля")
    public void AssertInvalidPassError(){
        Assert.assertTrue(passInput.isDisplayed());
    }


}