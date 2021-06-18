package com.pinterest.login;

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

    public RegistrationPage enterRegEmail(String regEmail){
        emailRegInput.sendKeys(regEmail);
        return this;
    }

    public RegistrationPage enterRegPass(String regPass){
        passwordRegInput.sendKeys(regPass);
        return this;
    }

    public RegistrationPage enterRegAge(String regAge){
        ageRegInput.sendKeys(regAge);
        return this;
    }


}
