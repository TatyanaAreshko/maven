package screenshot;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotMaker {
    /*@Attachment(value = "Screenshot on failure", type = "image/png")
    public static byte[] makeScreenshot(WebDriver driver, String fileName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/
    public static void makeScreenshot(WebDriver driver, String filename){
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(new File("./target/") + filename);
        try {
            {
                FileUtils.copyFile(temp, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
