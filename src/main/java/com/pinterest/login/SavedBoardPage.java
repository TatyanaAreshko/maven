package com.pinterest.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedBoardPage extends LoginPage{
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Tatyana Areshko')]")
    public WebElement headerBoardPage;

    @FindBy(xpath = "//div[@data-test-id='boardActionsButton']")
    public WebElement addButton;

    @FindBy(xpath = "//div[contains(text(),'Доска')]")
    public WebElement addBoardButton;

    @FindBy(id = "boardEditName")
    public WebElement boardInputArea;

    @FindBy(xpath = "//div[contains(text(),'Готово')]")
    public WebElement doneButton;

    public SavedBoardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SavedBoardPage enterBoard(String board){
        boardInputArea.sendKeys(board);
        return this;
    }

    public void quit(){
        driver.quit();
    }

}
