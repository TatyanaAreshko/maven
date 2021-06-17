package com.pinterest.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//div[contains(text(),'Войти')]")
    public WebElement signInButton;
//    public WebElement signInButton = driver.findElement(By.xpath("//div[contains(text(),'Войти')]"));

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get("https://www.pinterest.com/");    }


}
