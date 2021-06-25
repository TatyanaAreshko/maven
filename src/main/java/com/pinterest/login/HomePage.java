package com.pinterest.login;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class HomePage extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Войти')]")
    public WebElement signInButton;

    @FindBy(xpath = "//div[contains(text(),'Регистрация')]")
    public WebElement regInButton;

    @FindBy(xpath = "//div[@data-test-id='header-about-button']")
    public WebElement descriptionButton;

    @FindBy(xpath = "//div[@data-test-id='header-business-button']")
    public WebElement businessButton;

    @FindBy(xpath = "//div[@data-test-id='header-blog-button']")
    public WebElement blogButton;

    @FindBy(xpath = "//div[@data-test-id='page-scroll-arrow']")
    public WebElement scrollButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы сайта")
    public HomePage open(){
        driver.get("https://www.pinterest.com/");
        return this; }

    @Step("Нажать кнопку 'Войти'")
    public HomePage signInButton(){
        log.info("-----------------------------------------ENTER Pinterest-------------------------------------");
        signInButton.click();
        return this;
    }

    //@Step("Нажать кнопку 'Зарегистрироваться'")
    public HomePage regInButton(){
        log.info("----------------------------------------REGISTRATION-----------------------------------------");
        regInButton.click();
        return this;}


}
