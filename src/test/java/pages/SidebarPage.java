package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SidebarPage extends BasePage{

    // ☰ Menu button
    private By menuButton =
            By.cssSelector("a.sidebar-toggle");

    private By referralButton =
            By.xpath("//*[@id=\"sidebar-menu\"]/li[4]/a/span");

    // Referrals Sent
    private By referralsSentLink =
            By.xpath("//span[normalize-space()='Referrals Sent']");

    private By thankYouNoteLink =
            By.xpath("//span[normalize-space()='Thank You Note']");

    private By tyNotesSent =
            By.xpath("//span[normalize-space()='TY Notes Sent']");

    // Meetings (parent)
    private By meetingsMenu =
            By.xpath("//span[normalize-space()='Meetings']");

    // Member Meetings (child)
    private By memberMeetings =
            By.xpath("//span[normalize-space()='Member Meetings']");

    public void clickTYNotesSent() {
        WaitUtils.waitForClickable(driver, tyNotesSent).click();
    }

    public void openThankYouNote() {
        WaitUtils.waitForClickable(driver, thankYouNoteLink).click();
    }

    public void openMemberMeetings() {
        WaitUtils.waitForClickable(driver, meetingsMenu).click();
        WaitUtils.waitForClickable(driver, memberMeetings).click();
    }


    public SidebarPage(WebDriver driver) {
        super(driver);
    }

    public void openMenu() {
        WaitUtils.waitForClickable(driver, menuButton).click();
    }

    public void openReferrals() {
        WaitUtils.waitForClickable(driver, referralButton).click();
    }

    public void openReferralsSent() {
        WaitUtils.waitForClickable(driver, referralsSentLink).click();
    }
}
