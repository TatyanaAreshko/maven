package com.pinterest.login;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@data-test-id=\"header-profile\"]")
    public WebElement EnterInPersonPageButton;

    @FindBy(xpath = "//*[@data-test-id=\"search-box-input\"]")
    public WebElement searchField;

    @Step("Set sell amount: {value}")
    public void setValue(String value) {
        searchField.click();
        searchField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "");
        searchField.sendKeys(value);
        searchField.sendKeys(Keys.ENTER);
        log.info("----------------------------------------SEARCH VALUE---------------------------------------");
    }


    public MainPage(WebDriver driver) {
        super(driver);
    }
}
