package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class ReferralPage extends BasePage {

    // ================= BUTTON =================

    private By sendReferralBtn =
            By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div[1]/button");

    // ================= FIELDS =================

    // Referred To Member dropdown
    private By memberDropdown =
            By.xpath("//select[option[contains(text(),'Select a member')]]");

    // Client Full Name
    private By clientName =
            By.xpath("//input[@placeholder='e.g. John Doe']");

    // Contact Number
    private By contactNumber =
            By.xpath("//input[contains(@placeholder,'99999')]");

    // Priority Level dropdown
    private By priorityLevel =
            By.xpath("//select[option[contains(text(),'Select Level')]]");

    // Company / Organization
    private By companyName =
            By.xpath("//input[@placeholder='e.g. Acme Corp']");

    // Additional Notes
    private By additionalNotes =
            By.xpath("//textarea[contains(@placeholder,'context')]");

    // Submit button
    private By submitBtn =
            By.xpath("//button[normalize-space()='Send Referral']");

    // Success message
    private By successToast =
            By.xpath("//div[contains(@class,'Toastify__toast') and contains(text(),'Referral sent successfully')]");

    public ReferralPage(WebDriver driver) {
        super(driver);
    }

    // ================= ACTIONS =================

    public void clickSendReferralButton() {
        WaitUtils.waitForClickable(driver, sendReferralBtn).click();
    }

    public void selectMember(String memberName) {

        Select select =
                new Select(
                        WaitUtils.waitForVisible(driver, memberDropdown)
                );

        boolean found = false;

        for (WebElement option : select.getOptions()) {

            if (option.getText().trim()
                    .equalsIgnoreCase(memberName.trim())) {

                option.click();

                found = true;

                break;
            }
        }

        if (!found) {

            throw new RuntimeException(
                    "Member not found in dropdown: " + memberName
            );
        }
    }

    public void enterClientName(String name) {

        WaitUtils.waitForVisible(driver, clientName)
                .sendKeys(name);
    }

    public void enterContactNumber(String number) {

        WaitUtils.waitForVisible(driver, contactNumber)
                .sendKeys(number);
    }

    public void selectPriorityLevel(String level) {

        Select select =
                new Select(
                        WaitUtils.waitForVisible(driver, priorityLevel)
                );

        for (WebElement option : select.getOptions()) {

            String text = option.getText().toLowerCase();

            if (text.contains(level.toLowerCase())) {

                option.click();

                return;
            }
        }

        throw new RuntimeException(
                "Priority level not found: " + level
        );
    }

    public void enterCompanyName(String company) {

        WaitUtils.waitForVisible(driver, companyName)
                .sendKeys(company);
    }

    public void enterAdditionalNotes(String notes) {

        WaitUtils.waitForVisible(driver, additionalNotes)
                .sendKeys(notes);
    }

    public void submitReferral() {

        WaitUtils.waitForClickable(driver, submitBtn).click();
    }

    // ================= ASSERT =================

    public boolean isReferralSentSuccessfully() {

        try {

            WaitUtils.waitForVisible(driver, successToast);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}