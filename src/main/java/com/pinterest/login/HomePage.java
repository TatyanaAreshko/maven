package com.pinterest.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    WebDriver driver;
    @FindBy(xpath = "//div[contains(text(),'Войти')]")
    public WebElement signInButton;
//    public WebElement signInButton = driver.findElement(By.xpath("//div[contains(text(),'Войти')]"));

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
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void open(){
        driver.get("https://www.pinterest.com/");    }


}
