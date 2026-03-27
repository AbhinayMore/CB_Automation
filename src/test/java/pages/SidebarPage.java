package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SidebarPage extends BasePage{

    // ☰ Menu button
    private By menuButton =
            By.xpath("//*[@id=\"root\"]/div/header/div[1]/button/svg");

    private By referralButton =
            By.xpath("//*[@id=\"root\"]/div/div/aside/div[2]/div/div[1]/button");

    // Referrals Sent
    private By referralsSentLink =
            By.xpath("//*[@id=\"root\"]/div/div/aside/div[2]/div/div[1]/div/a[2]");

    private By thankYouNoteLink =
            By.xpath("//span[normalize-space()='Thank You Note']");

    private By tyNotesSent =
            By.xpath("//span[normalize-space()='TY Notes Sent']");

    // Meetings (parent)
    private By meetingsMenu =
            By.xpath("//*[@id=\"root\"]/div/div/aside/div[2]/div/div[2]/button/span");

    // Member Meetings (child)
    private By memberMeetings =
            By.xpath("//*[@id=\"root\"]/div/div/aside/div[2]/div/div[2]/div/a[1]");

    // Event (parent)
    private By eventMenu =
            By.cssSelector("a[href='/info/events']");

    //chapter admin meetings
    private By meetingMenu =
            By.xpath("//*[@id=\"root\"]/div/div/aside/div[2]/div/div[2]/button");

    private By chapterMeetingsSubMenu =
            By.xpath("//*[@id=\"root\"]/div/div/aside/div[2]/div/div[2]/div/a[2]");

    private By trainingMenu =
            By.xpath("//*[@id=\"root\"]/div/div/aside/div[2]/div/a[7]");

    public void openChapterMeetingsPage(){

        // click Meetings first Chapter admin meetings
        WaitUtils.waitForClickable(driver, meetingMenu)
                .click();

        // then click Chapter Meetings
        WaitUtils.waitForClickable(driver, chapterMeetingsSubMenu)
                .click();
    }

    public void openTrainingPage(){

        WaitUtils.waitForClickable(driver, trainingMenu)
                .click();
    }

    public void openEventPage() {
        WaitUtils.waitForClickable(driver, eventMenu).click();
    }



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
