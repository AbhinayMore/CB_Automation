package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class MemberMeetingPage extends BasePage {

    // ================= BUTTON =================

    private By scheduleMeetingBtn =
            By.xpath("//button[contains(text(),'Schedule 1-to-1')]");

    private By scheduleBtn =
            By.xpath("//button[normalize-space()='Schedule']");

    // ================= FIELDS =================

    // Subject / Title
    private By subjectInput =
            By.xpath("//input[@placeholder='e.g. Project Sync-up']");

    // Participant dropdown
    private By participantDropdown =
            By.name("invitees");

    // Date
    private By meetingDate =
            By.name("date");

    // Mode dropdown (Virtual / Offline)
    private By meetingMode =
            By.xpath("//select[contains(@name,'mode')]");

    // Start time
    private By startTime =
            By.name("startTime");

    private By endTime =
            By.name("endTime");

    // Meeting link (appears when Virtual selected)
    private By meetingLink =
            By.xpath("//input[contains(@placeholder,'zoom')]");

    // Description / agenda
    private By description =
            By.xpath("//textarea | //input[contains(@placeholder,'meeting')]");

    // ================= SUCCESS =================

    private By successAlert =
            By.xpath("//div[@role='alert' and contains(@class,'alert-success')]");

    public MemberMeetingPage(WebDriver driver) {
        super(driver);
    }

    // ================= ACTION METHODS =================

    public void clickScheduleMeetingButton() {
        WaitUtils.waitForClickable(driver, scheduleMeetingBtn).click();
    }

    public void enterSubject(String subject) {
        WaitUtils.waitForVisible(driver, subjectInput).sendKeys(subject);
    }

    public void selectParticipant(String participantName) {

        Select select =
                new Select(
                        WaitUtils.waitForVisible(driver, participantDropdown)
                );

        select.selectByVisibleText(participantName);
    }

    public void selectDate(String date) {

        // clear existing value first
        WaitUtils.waitForVisible(driver, meetingDate).clear();

        // enter date in yyyy-MM-dd format
        WaitUtils.waitForVisible(driver, meetingDate).sendKeys(date);
    }

    public void selectMeetingMode(String mode, String linkIfVirtual) {

        Select select =
                new Select(WaitUtils.waitForVisible(driver, meetingMode));

        select.selectByVisibleText(mode);

        // Virtual mode → meeting link field appears
        if (mode.equalsIgnoreCase("Virtual")) {
            WaitUtils.waitForVisible(driver, meetingLink)
                    .sendKeys(linkIfVirtual);
        }
    }

    public void selectStartTime(String time) {

        WaitUtils.waitForVisible(driver, startTime).clear();

        WaitUtils.waitForVisible(driver, startTime).sendKeys(time);
    }


    public void selectEndTime(String time) {

        WaitUtils.waitForVisible(driver, endTime).clear();

        WaitUtils.waitForVisible(driver, endTime).sendKeys(time);
    }

    public void enterDescription(String text) {
        WaitUtils.waitForVisible(driver, description).sendKeys(text);
    }

    public void clickScheduleButton() {
        WaitUtils.waitForClickable(driver, scheduleBtn).click();
    }

    // ================= SUCCESS ASSERT =================

    public boolean isMeetingScheduledSuccessfully() {

        try {

            WaitUtils.waitForVisible(driver, successAlert);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}