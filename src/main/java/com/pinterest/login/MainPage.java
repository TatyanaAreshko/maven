package com.pinterest.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@data-test-id=\"header-profile\"]")
    public WebElement EnterInPersonPageButton;

    @FindBy(xpath = "//*[@data-test-id=\"search-box-input\"]")
    public WebElement searchField;

    @Step("Set sell amount: {value}")
    public void setValue(String value) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(value);
    }


    public MainPage(WebDriver driver) {
        super(driver);
    }
}
