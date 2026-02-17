package utils;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenshotUtils {
	 public static String capture(WebDriver driver, String testName) {
	        try {
	            File src = ((TakesScreenshot) driver)
	                    .getScreenshotAs(OutputType.FILE);
	            String path = "target/screenshots/" + testName + ".png";
	            FileUtils.copyFile(src, new File(path));
	            return path;
	        } catch (Exception e) {
	            return null;
	        }
	    }

}
