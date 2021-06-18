package org.example;

public class TestPinterest extends BaseTest{

    /*private WebDriver driver;

    @Test
    // Проверка входа
    public void test1() throws Exception {
        WebElement buttonAvatar = driver.findElement(By.xpath("//*[@data-test-id=\"header-profile\"]"));
        buttonAvatar.click();

        WebElement akk = driver.findElement(By.xpath("//h1[contains(text(),'Tatyana Areshko')]"));
        Assert.assertTrue(true, "Tatyana Areshko");
        System.out.println("Вход на персональную страницу выполнен");
    }

    @Test
    // создание новой доски
    public void test2() throws Exception{
        WebElement addBoard = driver.findElement(By.xpath("//div[@data-test-id='boardActionsButton']"));
        addBoard.click();
        WebElement textShow = driver.findElement(By.xpath("//div[contains(text(),'Создать')]"));
        Assert.assertTrue(true, "Создать");

        WebElement addButton = driver.findElement(By.xpath("//div[contains(text(),'Доска')]"));
        addButton.click();
        Assert.assertTrue(true, "Доска");

        WebElement windowCreateBoard = driver.findElement(By.xpath("//h2[contains(text(),'Создание доски')]"));
        Assert.assertTrue(true, "Создание доски");

        //присваиваем имя доски
        WebElement searchInputArea = driver.findElement(By.id("boardEditName"));
        searchInputArea.sendKeys("TestBoard111");

        //закрыть вредный попап
        WebElement buttonSearch = driver.findElement(By.xpath("//div[contains(text(),'Готово')]"));
        buttonSearch.click();
        driver.findElement(By.xpath("//button[@aria-label='Готово']")).click();

        WebElement findLogoNewBoard = driver.findElement(By.cssSelector("h1.lH1.dyH.iFc.mWe.ky3.pBj.tg7.IZT"));
        System.out.println("Доска успешно создана");
    }

    @AfterClass
    public static void theEnd() {
        System.out.println("The End");
    }

    @AfterTest
    public void closeUp() {
        driver.close();
    }*/


}
