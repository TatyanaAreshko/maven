package com.pinterest.login;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class SavedBoardPage extends BasePage{
    public SavedBoardPage(WebDriver driver) {
        super(driver);
    }

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

     // --------------------------edit--------------------------

    @FindBy(xpath = "//div[@data-test-id='profile-board-card']")
    public WebElement focus;

    @Step("Фокус")
    public SavedBoardPage focus(){
        focus.click();
        return this;
    }
    @FindBy(xpath = "//div[@data-test-id='more-board-options']")
    public WebElement edit;

    @Step("Нажать кнопку редактирования доски")
    public SavedBoardPage edit(){
        log.info("----------------------------------------EDIT BOARD----------------------------------------------");
        edit.click();
        return this;
    }
    @FindBy(xpath = "//div[@data-test-id='editBoardButton']")
    public WebElement chooseEdit;

    @Step("Выбрать пункт редактировать")
    public SavedBoardPage chooseEdit(){
        chooseEdit.click();
        return this;
    }

    @FindBy(xpath = "//input[@id='boardEditName']")
    public WebElement boardEditName;

    @Step("Ввести в поле ввода новое название доски")
    public SavedBoardPage boardEditName(String board){
        boardEditName.sendKeys(board);
        return this;
    }

    public SavedBoardPage clearName(){
        boardEditName.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "");
        return this;
    }

    @FindBy(xpath = "//textarea[@id='boardEditDescription']")
    public WebElement editBoardDescArea;

    @Step("Ввести в поле ввода описание доски")
    public SavedBoardPage editBoardDescArea(String board){
        editBoardDescArea.sendKeys(board);
        return this;
    }

    public SavedBoardPage clearDesc(){
        editBoardDescArea.click();
        editBoardDescArea.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "");
        return this;
    }

    @FindBy(id = "secret")
    public WebElement secretCheckbox;

    @Step("Отметить чекбоксом приватность доски")
    public SavedBoardPage secretCheckbox(){
        if (!secretCheckbox.isSelected())
        {
            secretCheckbox.click();
        }
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Готово')]")
    public WebElement editBoardCloseButton;


    @Step("Нажать кнопку 'Готово'")
    public SavedBoardPage editBoardCloseButton(){
        editBoardCloseButton.click();
        return this;
    }

    // -----------------------delete---------------------------

    @FindBy(xpath = "//h3[contains(text(),'Удалить доску')]")
    public WebElement deleteBoard;


    @Step("Нажать кнопку 'Готово'")
    public SavedBoardPage deleteBoard(){
        log.info("----------------------------------------DELETE BOARD----------------------------------------------");
        deleteBoard.click();
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Удалить навсегда')]")
    public WebElement deleteBoardButton;


    @Step("Нажать кнопку 'Готово'")
    public SavedBoardPage deleteBoardButton(){
        deleteBoardButton.click();
        return this;
    }

    // -----------------------create---------------------------


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
        log.info("-----------------------------------CREATE BOARD-------------------------------------------");
        doneButton.click();
        return this;
    }

    @Step("Закрыть рекламный попап")
    public SavedBoardPage popupCloseButton(){
        popupCloseButton.click();
        return this;
    }

    @Step("Вернуться на личную страницу")
    public SavedBoardPage goToThisPage(){
        log.info("-----------------------------------REDIRECT TO ACCOUNT---------------------------------------");
        driver.get("https://www.pinterest.com/tatyanaareshko0849/_saved");
        return this;
    }


}
