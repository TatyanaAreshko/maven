package actions;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestApp {
    static WebDriver driver;

    @BeforeTest
    // драйвер
    public static void setup() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    @BeforeMethod
    public static void login() throws Exception{
        //открыть сайт
        driver.get("https://www.pinterest.com/");
        System.out.println("Вход на сайт выполнен успешно");

        //нажать на кнопку "Войти"
        WebElement buttonEnter = driver.findElement(By.xpath("//div[contains(text(),'Войти')]"));
        buttonEnter.click();
        WebElement loginWindow = driver.findElement(By.xpath("//h3[contains(text(),'Добро пожаловать в Pinterest')]"));
        Assert.assertTrue("Добро пожаловать в Pinterest",true);

        //входим на сайт
        WebElement setEmail = driver.findElement(By.id("email"));
        setEmail.sendKeys("tasja1990@tut.by");
        WebElement setPass = driver.findElement(By.id("password"));
        setPass.sendKeys("Luria140140");
        WebElement buttonEnterModal = driver.findElement(By.cssSelector("button.red.SignupButton.active"));
        buttonEnterModal.click();

        //завершение скрипта
        System.out.println("Вход в аккаунт выполнен");
    }

    @Test
    // Проверка входа
    public static void test1() throws Exception {
        WebElement buttonAvatar = driver.findElement(By.xpath("//*[@data-test-id=\"header-profile\"]"));
        buttonAvatar.click();

        WebElement akk = driver.findElement(By.xpath("//h1[contains(text(),'Tatyana Areshko')]"));
        Assert.assertTrue("Tatyana Areshko",true);
        System.out.println("Вход на персональную страницу выполнен");
    }

    @Test
    // создание новой доски
    public static void test2() throws Exception{
        WebElement addBoard = driver.findElement(By.xpath("//div[@data-test-id='boardActionsButton']"));
        addBoard.click();
        WebElement textShow = driver.findElement(By.xpath("//div[contains(text(),'Создать')]"));
        Assert.assertTrue("Создать",true);

        WebElement addButton = driver.findElement(By.xpath("//div[contains(text(),'Доска')]"));
        addButton.click();
        Assert.assertTrue("Доска",true);

        WebElement windowCreateBoard = driver.findElement(By.xpath("//h2[contains(text(),'Создание доски')]"));
        Assert.assertTrue("Создание доски",true);

        //присваиваем имя доски
        WebElement searchInputArea = driver.findElement(By.id("boardEditName"));
        searchInputArea.sendKeys("TestBoard");

        //закрыть вредный попап
        WebElement buttonSearch = driver.findElement(By.xpath("//div[contains(text(),'Готово')]"));
        buttonSearch.click();
        driver.findElement(By.xpath("//button[@aria-label='Готово']")).click();

        WebElement findLogoNewBoard = driver.findElement(By.cssSelector("h1.lH1.dyH.iFc.mWe.ky3.pBj.tg7.IZT"));
        System.out.println("Доска успешно создана");
    }

    @AfterClass
    public static void theEnd() throws IOException {
        System.out.println("The End");
    }

    @AfterTest
    public static void closeUp() {
        driver.close();
    }

}
