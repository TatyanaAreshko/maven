package org.example;

import com.pinterest.login.MainPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AutoEraseFieldTest extends BaseTest{
    private MainPage mainPage;

    /*@BeforeMethod
    public void goToAccount() {
        mainPage = new MainPage(driver);
    }*/

    @Test(dataProvider = "currencyValueDataProvider", dataProviderClass = AutoEraseFieldProvider.class)
    @Description("test")
    public void enterData(String str){
        MainPage mainPage = new MainPage(driver);
        mainPage.setValue(str);

        //softVerify.assertEquals(calculatorPage.getSellAmount(), StringUtils.EMPTY, "Sell value is emptied");

    }

}
