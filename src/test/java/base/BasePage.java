package base;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
}
