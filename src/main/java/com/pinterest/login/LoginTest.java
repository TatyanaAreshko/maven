package com.pinterest.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement buttonAvatar = driver.findElement(By.xpath("//*[@data-test-id=\"header-profile\"]"));
        buttonAvatar.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement akk = driver.findElement(By.xpath("//h1[contains(text(),'Tatyana Areshko')]"));

        if (akk.getText().equals("Tatyana Areshko")) {
            System.out.println("OK");
        } else {
            throw new Exception("Элемент не найден");
        }


        System.out.println("Вход на персональную страницу выполнен");

        driver.quit();


    }
}



