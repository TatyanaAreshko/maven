package com.pinterest.login;

import io.qameta.allure.Step;
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

    @Step("Ввести в поле ввода название доски")
    public SavedBoardPage enterBoard(String board){
        boardInputArea.sendKeys(board);
        return this;
    }

    @Step("Нажать кнопку 'Добавить пин или доску'")
    public SavedBoardPage addButton(){
        addButton.click();
        return this;
    }

    @Step("Нажать кнопку 'Добавить доску'")
    public SavedBoardPage addBoardButton(){
        addBoardButton.click();
        return this;
    }

    @Step("Нажать кнопку подтверждения создания 'Готово'")
    public SavedBoardPage doneButton(){
        doneButton.click();
        return this;
    }

    @Step("Закрыть рекламный попап")
    public SavedBoardPage popupCloseButton(){
        popupCloseButton.click();
        return this;
    }

    //@Step("Вернуться на личную страницу")
    public SavedBoardPage goToThisPage(){
        driver.get("https://www.pinterest.com/tatyanaareshko0849/_saved/");
        return this;
    }


}
