package org.example;

import com.pinterest.login.HomePage;
import com.pinterest.login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private final String INVALID_PASS = "123";
    private final String INVALID_EMAIL = "abc";
    private final String VALID_EMAIL = "tatyana.areshko@gmail.com";
    private final String VALID_PASS = "Test123";


    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeTest
    public void login(){
        homePage = new HomePage(driver);
        homePage.open();
        homePage.signInButton.click();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(VALID_EMAIL);
        loginPage.enterPass(VALID_PASS);
        loginPage.enterButton.click();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
