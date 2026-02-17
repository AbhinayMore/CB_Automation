package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		String browser = ConfigReader.get("browser");

		// SAFETY CHECK
		if (browser == null) {
			throw new RuntimeException(
					"Browser value is NULL. Check config.properties"
			);
		}

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			throw new RuntimeException(
					"Unsupported browser in config.properties: " + browser
			);
		}

		driver.manage().window().maximize();
		driver.get(ConfigReader.get("url"));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
