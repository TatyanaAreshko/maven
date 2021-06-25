package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class AutoEraseFieldProvider {
    @DataProvider(name = "ValueDataProvider")
    public static Object[][] manageDataProvider() {
        return new Object[][]{
                {"1"},
                {"0"},
                {RandomStringUtils.randomNumeric(3)},
                {"-" + RandomStringUtils.randomNumeric(3)},
                {" "},
                {"0.0001"},
                {RandomStringUtils.randomAlphabetic(1)},
                {RandomStringUtils.randomAscii(10)},
                {RandomStringUtils.randomAlphanumeric(500)},
        };
    }

}
