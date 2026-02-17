package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class ReferralPage extends BasePage {

    // Send Referral button
    private By sendReferralBtn =
            By.xpath("//button[normalize-space()='Send Referral']");

    // react-select (Select Member)
    private By selectMemberInput =
            By.xpath("//input[@role='combobox']");

    // Normal select (Flag)
    private By flagDropdown =
            By.name("ref_flag");

    // Fields
    private By referralNameInput =
            By.xpath("//label[text()='Referral Name']/following::input[1]");

    private By emailInput =
            By.xpath("//label[text()='Email']/following::input[1]");

    private By contactNoInput =
            By.xpath("//label[contains(text(),'Contact No')]/following::input[1]");

    private By companyNameInput =
            By.xpath("//label[text()='Company Name']/following::input[1]");

    private By descriptionInput =
            By.xpath("//label[text()='Referral Description']/following::textarea[1]");

    private By submitBtn =
            By.xpath("//button[normalize-space()='Submit']");

    private By successAlert =
            By.xpath("//div[@role='alert' and contains(@class,'alert-success')]");


    public ReferralPage(WebDriver driver) {
        super(driver);
    }

    public void clickSendReferral() {
        WaitUtils.waitForClickable(driver, sendReferralBtn).click();
    }

    public void selectMember(String name) {
        WebElement input = WaitUtils.waitForVisible(driver, selectMemberInput);
        input.click();
        input.sendKeys(name);
        input.sendKeys(Keys.ENTER);
    }

    public void selectFlag(String flag) {
        Select select = new Select(WaitUtils.waitForVisible(driver, flagDropdown));
        select.selectByVisibleText(flag);
    }

    public void fillReferralForm(String name, String email, String mobile,
                                 String company, String desc) {

        WaitUtils.waitForVisible(driver, referralNameInput).sendKeys(name);
        WaitUtils.waitForVisible(driver, emailInput).sendKeys(email);
        WaitUtils.waitForVisible(driver, contactNoInput).sendKeys(mobile);
        WaitUtils.waitForVisible(driver, companyNameInput).sendKeys(company);
        WaitUtils.waitForVisible(driver, descriptionInput).sendKeys(desc);
    }

    public void submit() {
        WaitUtils.waitForClickable(driver, submitBtn).click();
    }

    public boolean waitForSuccessMessage() {
        try {
            WaitUtils.waitForVisible(driver, successAlert);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
