package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Actions {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        setup();
        login();
        test1();
        test2();
        screenShot();
        closeUp();
    }

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
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.pinterest.com/");
        System.out.println("Вход на сайт выполнен успешно");

        String pageSource=driver.findElement(By.tagName("body")).getText();

        System.out.println("_______________________");
        System.out.println("Структура тела главной страницы " + pageSource);
        System.out.println("_______________________");

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

    @Test
    // Проверка входа
    public static void test1() throws Exception {
        WebElement buttonAvatar = driver.findElement(By.xpath("//*[@data-test-id=\"header-profile\"]"));
        buttonAvatar.click();

        WebElement akk = driver.findElement(By.xpath("//h1[contains(text(),'Tatyana Areshko')]"));
        try{
            Assert.assertTrue(akk.isDisplayed());
            System.out.println("String 'Tatyana Areshko' Displayed");
        } catch (Exception e) {
            System.out.println("Элемент не найден");
        }

        System.out.println("Вход на персональную страницу выполнен");
    }

    @Test
    // создание новой доски
    public static void test2() throws Exception{
        WebElement addBoard = driver.findElement(By.xpath("//body/div[@id='__PWS_ROOT__']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/button[1]/div[1]/*[1]"));
        addBoard.click();
        WebElement textShow = driver.findElement(By.xpath("//div[contains(text(),'Создать')]"));

        try{
            Assert.assertTrue(textShow.isDisplayed());
            System.out.println("Text 'Создать' Displayed");
        } catch (Exception e) {
            System.out.println("Элемент не найден");
        }

        WebElement addButton = driver.findElement(By.xpath("//div[contains(text(),'Доска')]"));
        addButton.click();

        WebElement windowCreateBoard = driver.findElement(By.xpath("//h2[contains(text(),'Создание доски')]"));

        try{
            Assert.assertTrue(windowCreateBoard.isDisplayed());
            System.out.println("Text 'Создание доски' Displayed");
        } catch (Exception e) {
            System.out.println("Элемент не найден");
        }

        WebElement searchInputArea = driver.findElement(By.id("boardEditName"));
        searchInputArea.sendKeys("NewTestBoard2");
        WebElement buttonSearch = driver.findElement(By.xpath("//div[contains(text(),'Готово')]"));
        buttonSearch.click();


        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("__PWS_ROOT__")));

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div/button")).click();

        WebElement findLogoNewBoard = driver.findElement(By.cssSelector("h1.lH1.dyH.iFc.mWe.ky3.pBj.tg7.IZT"));
        System.out.println("Создано");
    }

    @AfterClass
    public static void screenShot() throws IOException {

        /*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));*/
        System.out.println("Тут должен быть скриншот, но что-то пошло не так");
    }

    @AfterTest
    public static void closeUp() {
        driver.close();
    }

}
