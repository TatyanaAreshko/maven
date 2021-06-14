package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest
{
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //открыть википедию
        driver.get("https://www.wikipedia.org/");
        //вписать в инпут "Селениум"
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Selenium");
        WebElement buttonSearch = driver.findElement(By.cssSelector("button.pure-button"));
        buttonSearch.click();
        WebElement header = driver.findElement(By.id("firstHeading"));
        if (header.getText().equals("Selenium")) {
            System.out.println("OK");
        } else {
            throw new Exception("No \"selenium\" in Header");
        }
        System.out.println("Breakpoint");
        driver.quit();
    }

}
