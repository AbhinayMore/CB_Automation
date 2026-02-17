package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class ThankYouNotePage extends BasePage {

    // ================= BUTTONS =================

    private By sendThankYouBtn =
            By.xpath("//button[normalize-space()='Send Thank You Note']");

    private By submitBtn =
            By.xpath("//button[normalize-space()='Submit']");

    // ================= SELECT MEMBER (react-select) =================

    private By selectMemberInput =
            By.xpath("//input[@role='combobox']");

    // ================= BUSINESS AMOUNT =================

    private By businessAmountInput =
            By.xpath("//*[@id=\"content-page\"]/div/div/div/div/div[2]/form/div/div[2]/input");

    // ================= SUCCESS MESSAGE =================

    private By successAlert =
            By.xpath("//div[@role='alert' and contains(@class,'alert-success')]");

    // ================= CONSTRUCTOR =================

    public ThankYouNotePage(WebDriver driver) {
        super(driver);
    }

    // ================= ACTION METHODS =================

    public void clickSendThankYouNote() {
        WaitUtils.waitForClickable(driver, sendThankYouBtn).click();
    }

    public void selectMember(String memberName) {
        WebElement input = WaitUtils.waitForVisible(driver, selectMemberInput);
        input.click();
        input.sendKeys(memberName);
        input.sendKeys(Keys.ENTER);
    }

    public void enterBusinessAmount(String amount) {
        WaitUtils.waitForVisible(driver, businessAmountInput).sendKeys(amount);
    }

    public void submit() {
        WaitUtils.waitForClickable(driver, submitBtn).click();
    }

    // ================= VALIDATION =================

    public boolean waitForSuccessMessage() {
        try {
            WaitUtils.waitForVisible(driver, successAlert);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
