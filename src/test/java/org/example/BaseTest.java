package org.example;

import com.pinterest.login.HomePage;
import com.pinterest.login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

// основной класс, с которого стартуют все тесты
//@Slf4j
//@Listeners(CustomLogger.class)
public class BaseTest {
    EventFiringWebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private final String INVALID_PASS = "123";
    private final String INVALID_EMAIL = "abc";
    private final String VALID_EMAIL = "tatyana.areshko@gmail.com";
    private final String VALID_PASS = "Test123";


    // так как драйвер необходим для тестирования всего сайта, то вынесем его в отдельный метод,
    // который будет запускаться до всех тестов. Все настройки драйвера указываем тут же.
    @Description("Запуск драйвера с параметрами")
    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.register(new CustomLogger());
    }

    // каждый мой тест требует открытия страницы сайта и авторизации, поэтому вынесла все это в общий класс BaseTest,
    // который наследуется остальными классами-тестами
    @Description("Авторизация на сайте с валидными входными данными")
    @BeforeTest
    public void login(){
        new HomePage(driver)
                .open()
                .signInButton();
        new LoginPage(driver)
                .enterEmail(VALID_EMAIL)
                .enterPass(VALID_PASS)
                .enterButton()
                .AssertInvalidEmailError();
    }

    @Description("Закрытие драйвера")
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
