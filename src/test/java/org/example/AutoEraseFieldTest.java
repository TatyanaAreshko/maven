package org.example;

import com.pinterest.login.MainPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AutoEraseFieldTest extends BaseTest{
    private MainPage mainPage;

    @Test(dataProvider = "ValueDataProvider", dataProviderClass = AutoEraseFieldProvider.class)
    @Description("test")
    public void enterData(String str){
        MainPage mainPage = new MainPage(driver);
        mainPage.setValue(str);
    }

}
