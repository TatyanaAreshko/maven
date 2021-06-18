package com.pinterest.login;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "email")
    private WebElement emailInput;
//    public WebElement emailInput = driver.findElement(By.id("email"));

    @FindBy(id = "password")
    public WebElement passInput;
//    public WebElement passInput = driver.findElement(By.id("password"));

    @FindBy(css = "button.red.SignupButton.active")
    public WebElement enterButton;
//    public WebElement enterButton = driver.findElement(By.cssSelector("button.red.SignupButton.active"));

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public LoginPage enterEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPass(String pass){
        passInput.sendKeys(pass);
        return this;
    }

    public void AssertInvalidPassError(){
        boolean passError = driver.findElement(By.xpath("//div[@data-test-id='touchableErrorMessage']")).isDisplayed();
        Assert.assertTrue(passError);
    }

    public void quit(){
        driver.quit();
    }



}