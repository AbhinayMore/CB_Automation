package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage extends BasePage {

    // ✅ Correct locators from your DOM
    private By emailInput =
            By.id("exampleInputEmail1");

    private By passwordInput =
            By.id("exampleInputPassword1");

    private By signInButton =
            By.xpath("//button[normalize-space()='Sign in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        WaitUtils.waitForVisible(driver, emailInput).clear();
        WaitUtils.waitForVisible(driver, emailInput).sendKeys(email);

        WaitUtils.waitForVisible(driver, passwordInput).clear();
        WaitUtils.waitForVisible(driver, passwordInput).sendKeys(password);

        WaitUtils.waitForClickable(driver, signInButton).click();
    }
}
