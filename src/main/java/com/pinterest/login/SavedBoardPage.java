package com.pinterest.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedBoardPage extends BasePage{

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

    @FindBy(xpath = "//button[@aria-label='Готово']")
    public WebElement popupCloseButton;

    public SavedBoardPage(WebDriver driver) {
        super(driver);
    }

    public SavedBoardPage enterBoard(String board){
        boardInputArea.sendKeys(board);
        return this;
    }

    public SavedBoardPage addButton(){
        addButton.click();
        return this;
    }

    public SavedBoardPage addBoardButton(){
        addBoardButton.click();
        return this;
    }

    public SavedBoardPage doneButton(){
        doneButton.click();
        return this;
    }

    public SavedBoardPage popupCloseButton(){
        popupCloseButton.click();
        return this;
    }

    public void goToThisPage(){
        driver.get("https://www.pinterest.com/tatyanaareshko0849/_saved/");
    }


}
