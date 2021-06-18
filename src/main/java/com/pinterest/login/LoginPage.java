package com.pinterest.login;

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

    public LoginPage enterEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPass(String pass){
        passInput.sendKeys(pass);
        return this;
    }

    public LoginPage enterButton(){
        enterButton.click();
        return this;
    }

    public void AssertInvalidEmailError(){
        Assert.assertTrue(emailInput.isDisplayed());
    }

    public void AssertInvalidPassError(){
        Assert.assertTrue(passInput.isDisplayed());
    }


}