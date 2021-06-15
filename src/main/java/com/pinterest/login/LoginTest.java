package com.pinterest.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        setup();
        test1();
        test2();
    }


    public static void setup() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //открыть сайт
        driver.get("https://www.pinterest.com/");

        //нажать на кнопку "Войти"
        WebElement buttonEnter = driver.findElement(By.xpath("//div[contains(text(),'Войти')]"));
        buttonEnter.click();
        WebElement loginWindow = driver.findElement(By.xpath("//h3[contains(text(),'Добро пожаловать в Pinterest')]"));
        if (loginWindow.getText().equals("Добро пожаловать в Pinterest")) {
            System.out.println("Заголовок модального окна входа успешно показан");
        } else {
            throw new Exception("Заголовок \"Вход\" отсутствует в Header");
        }

        //входим на сайт
        WebElement setEmail = driver.findElement(By.id("email"));
        setEmail.sendKeys("tatyana.areshko@gmail.com");
        WebElement setPass = driver.findElement(By.id("password"));
        setPass.sendKeys("Test123");
        WebElement buttonEnterModal = driver.findElement(By.cssSelector("button.red.SignupButton.active"));
        buttonEnterModal.click();

        //завершение скрипта
        System.out.println("Вход выполнен");
    }

    public static void test1() throws Exception {
            WebElement buttonAvatar = driver.findElement(By.xpath("//*[@data-test-id=\"header-profile\"]"));
            buttonAvatar.click();

            WebElement akk = driver.findElement(By.xpath("//h1[contains(text(),'Tatyana Areshko')]"));
            if (akk.getText().equals("Tatyana Areshko")) {
                System.out.println("OK");
            } else {
                throw new Exception("Элемент не найден");
            }

            System.out.println("Вход на персональную страницу выполнен");
        }

    public static void test2() throws Exception{
        WebElement addBoard = driver.findElement(By.xpath("//body/div[@id='__PWS_ROOT__']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/button[1]/div[1]/*[1]"));
        addBoard.click();
        WebElement textShow = driver.findElement(By.xpath("//div[contains(text(),'Создать')]"));
        if (textShow.getText().equals("Создать")) {
            System.out.println("OK");
        } else {
            throw new Exception("Элемент не найден");
        }
        WebElement addButton = driver.findElement(By.xpath("//div[contains(text(),'Доска')]"));
        addButton.click();

        WebElement windowCreateBoard = driver.findElement(By.xpath("//h2[contains(text(),'Создание доски')]"));
        if (windowCreateBoard.getText().equals("Создание доски")) {
            System.out.println("OK");
        } else {
            throw new Exception("Элемент не найден");
        }

        WebElement searchInputArea = driver.findElement(By.id("boardEditName"));
        searchInputArea.sendKeys("NewTestBoard");
        WebElement buttonSearch = driver.findElement(By.xpath("//div[contains(text(),'Готово')]"));
        buttonSearch.click();
        System.out.println("Создано");

        /*WebElement savePin = driver.findElement(By.cssSelector("button.RCK.Hsu.USg.adn.CCY.czT.Vxj.aZc.Zr3.hA-.Il7.Jrn.hNT.BG7.NTm.KhY.iyn"));
        if (savePin.getText().equals("Сохраните несколько пинов на новой доске")) {
            System.out.println("OK");
        } else {
            throw new Exception("Элемент не найден");
        }
        WebElement buttonPin = driver.findElement(By.xpath("//div[contains(text(),'Готово')]"));
        buttonPin.click();*/

        WebElement findLogoNewBoard = driver.findElement(By.cssSelector("h1.lH1.dyH.iFc.mWe.ky3.pBj.tg7.IZT"));
        driver.quit();
    }



}



