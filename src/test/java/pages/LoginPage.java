package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage extends BasePage {

    // Credentials
    private By emailInput =
            By.xpath("//*[@id=\"email\"]");

    private By continueBtn =
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/form/div[2]/button");

    private By passwordInput =
            By.xpath("//*[@id=\"password\"]");

    private By signInBtn =
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/form/div[3]/button");

//    By adminLoginCard =
//            By.xpath("//div[contains(@class,'card-footer') and normalize-space()='Admin Login']");

    private By memberLoginBtn =
            By.xpath("//button[normalize-space()='Member Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Step 1–3: Enter credentials and sign in
    public void login(String email, String password) {

        WaitUtils.waitForVisible(driver, emailInput).sendKeys(email);

        WaitUtils.waitForClickable(driver, continueBtn).click();

        WaitUtils.waitForVisible(driver, passwordInput).sendKeys(password);

        WaitUtils.waitForClickable(driver, signInBtn).click();
    }

    // Step 4–5: Choose role
//    public void chooseAdminLogin() {
//        WaitUtils.waitForClickable(driver, adminLoginCard).click();
//    }

    public void chooseMemberLogin() {
        WaitUtils.waitForClickable(driver, memberLoginBtn).click();
    }
}