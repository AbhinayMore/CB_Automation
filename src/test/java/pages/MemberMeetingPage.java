package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;



public class MemberMeetingPage  extends BasePage {

    // ================= BUTTONS =================

    private By scheduleMeetBtn =
            By.xpath("//*[@id=\"content-page\"]/div/div/div/div/div[1]/div[2]/button");

    private By scheduleBtn =
            By.xpath("//*[@id=\"content-page\"]/div/div/div/div/div[2]/form/div[2]/button[2]");

    // ================= FIELDS =================

    // Meets Mode (normal select)
//    private By meetsModeDropdown =
//            By.name("meeting_mode");


    private By meetsLink =
            By.name("meets_link");

    private By meetsDate =
            By.xpath("//input[@type='date']");

    // Start & End time (select)
    private By startTime =
            By.name("meets_start_time");

    private By endTime =
            By.name("meets_end_time");

    // Member (react-select)
    private By selectMemberInput =
            By.xpath("//input[@role='combobox']");

    private By description =
            By.name("meets_description");

    // ================= SUCCESS =================

    private By successAlert =
            By.xpath("//div[@role='alert' and contains(@class,'alert-success')]");

    public MemberMeetingPage(WebDriver driver) {
        super(driver);
    }

    // ================= ACTIONS =================

    public void clickScheduleMeets() {
        WaitUtils.waitForClickable(driver, scheduleMeetBtn).click();
    }

//    public void selectMeetsMode(String mode) {
//        Select select =
//                new Select(WaitUtils.waitForVisible(driver, meetsModeDropdown));
//        select.selectByVisibleText(mode);
//    }


    public void enterMeetLink(String link) {
        WaitUtils.waitForVisible(driver, meetsLink).sendKeys(link);
    }

    public void selectDate(String date) {
        WaitUtils.waitForVisible(driver, meetsDate).sendKeys(date);
    }

    public void selectStartTime(String time) {
        Select select = new Select(WaitUtils.waitForVisible(driver, startTime));
        select.selectByVisibleText(time);
    }

    public void selectEndTime(String time) {
        Select select = new Select(WaitUtils.waitForVisible(driver, endTime));
        select.selectByVisibleText(time);
    }

    public void selectMember(String member) {
        WebElement input = WaitUtils.waitForVisible(driver, selectMemberInput);
        input.click();
        input.sendKeys(member);
        input.sendKeys(Keys.ENTER);
    }

    public void enterDescription(String text) {
        WaitUtils.waitForVisible(driver, description).sendKeys(text);
    }

    public void clickSchedule() {
        WaitUtils.waitForClickable(driver, scheduleBtn).click();
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
