package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SignupPage extends BasePage {
	// 🔹 Locators (update ids/xpaths if needed)
	private By firstName = By.xpath("//*[@id=\"firstName\"]");
	private By lastName = By.xpath("//*[@id=\"lastName\"]");
	private By emailId = By.xpath("//*[@id=\"email\"]");
	private By contactNumber = By.xpath("//*[@id=\"contactNumber\"]");
	private By yearsInBusiness = By.xpath("//*[@id=\"yearsInBusiness\"]");
	private By signupButton = By.xpath("//button[contains(., 'Complete Registration')]");
	private By successMessage = By.xpath("//*[@id=\"root\"]/section");
	private By errorMessage = By.xpath("//*[@id=\"root\"]/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]");
	// 🔹 Constructor
	public SignupPage(WebDriver driver) {
		super(driver);
	}

	// 🔹 Actions (Reusable methods)

	public void enterFirstName(String value) {
		WaitUtils.waitForVisible(driver, firstName).clear();
		driver.findElement(firstName).sendKeys(value);
	}

	public void enterLastName(String value) {
		WaitUtils.waitForVisible(driver, lastName).clear();
		driver.findElement(lastName).sendKeys(value);
	}

	public void enterEmail(String value) {
		WaitUtils.waitForVisible(driver, emailId).clear();
		driver.findElement(emailId).sendKeys(value);
	}

	public void enterContactNumber(String value) {
		WaitUtils.waitForVisible(driver, contactNumber).clear();
		driver.findElement(contactNumber).sendKeys(value);
	}

	public void enterYearsInBusiness(String value) {
		WaitUtils.waitForVisible(driver, yearsInBusiness).clear();
		driver.findElement(yearsInBusiness).sendKeys(value);
	}

	public boolean isErrorMessageDisplayed() {
		return WaitUtils.waitForVisible(driver, errorMessage).isDisplayed();
	}

	public void clickSignup() {
		WaitUtils.waitForClickable(driver, signupButton).click();
	}

	// 🔹 Validation

	public boolean isSignupSuccessful() {
		return WaitUtils.waitForVisible(driver, successMessage).isDisplayed();
	}
}
