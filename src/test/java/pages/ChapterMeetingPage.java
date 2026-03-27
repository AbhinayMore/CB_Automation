package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class ChapterMeetingPage extends BasePage {

    // ---------- Buttons ----------

    private By scheduleMeetingBtn =
            By.xpath("//button[contains(.,'Schedule Chapter Meeting')]");

    private By submitMeetingBtn =
            By.xpath("//button[contains(.,'Schedule Meeting')]");


    // ---------- Text fields ----------

    private By meetingSubject =
            By.cssSelector("input[placeholder='e.g. Monthly Strategy Review']");

    private By meetingPlace =
            By.cssSelector("input[placeholder='Hotel Royal, Conference Hall A']");

    private By charges =
            By.xpath("//label[contains(text(),'Charges')]/following::input[@type='number'][1]");

    private By paymentLink =
            By.cssSelector("input[placeholder='Razorpay Link']");

    private By description =
            By.cssSelector("textarea[placeholder='Detailed agenda...']");


    // ---------- Date fields ----------

    private By meetingDate =
            By.xpath("(//input[@type='date'])[1]");

    private By cutoffDate =
            By.xpath("(//input[@type='date'])[2]");


    // ---------- Time fields (AM/PM supported) ----------

    private By startTime =
            By.xpath("(//input[@type='time'])[1]");

    private By endTime =
            By.xpath("(//input[@type='time'])[2]");


    // ---------- Meeting mode ----------

    private By inPersonMode =
            By.xpath("//*[normalize-space()='In-Person']");

    private By virtualMode =
            By.xpath("//*[normalize-space()='Virtual']");


    // ---------- Success toast ----------

    private By successToast =
            By.cssSelector("div[role='alert']");


    // constructor
    public ChapterMeetingPage(WebDriver driver) {
        super(driver);
    }


    // click Schedule Chapter Meeting button
    public void clickScheduleMeetingButton(){

        WaitUtils.waitForClickable(driver, scheduleMeetingBtn)
                .click();
    }


    // select meeting mode
    public void selectMeetingMode(String mode){

        if(mode.equalsIgnoreCase("In-Person")){

            WaitUtils.waitForClickable(driver, inPersonMode)
                    .click();
        }
        else{

            WaitUtils.waitForClickable(driver, virtualMode)
                    .click();
        }
    }


    // create meeting
    public void createMeeting(String subject,
                              String mode,
                              String place,
                              String meetingDt,
                              String cutoffDt,
                              String start,
                              String end,
                              String fee,
                              String payLink,
                              String agenda){

        // subject
        WaitUtils.waitForVisible(driver, meetingSubject)
                .sendKeys(subject);


        // mode
        selectMeetingMode(mode);


        // place
        WaitUtils.waitForVisible(driver, meetingPlace)
                .sendKeys(place);


        // meeting date
        WaitUtils.waitForVisible(driver, meetingDate)
                .sendKeys(meetingDt);


        // cutoff date
        WaitUtils.waitForVisible(driver, cutoffDate)
                .sendKeys(cutoffDt);


        // start time (AM/PM)
        WebElement startElement =
                WaitUtils.waitForVisible(driver, startTime);

        startElement.clear();
        startElement.sendKeys(start);


        // end time (AM/PM)
        WebElement endElement =
                WaitUtils.waitForVisible(driver, endTime);

        endElement.clear();
        endElement.sendKeys(end);


        // charges
        WebElement chargesElement =
                WaitUtils.waitForVisible(driver, charges);

        chargesElement.clear();
        chargesElement.sendKeys(fee);


        // payment link
        WaitUtils.waitForVisible(driver, paymentLink)
                .sendKeys(payLink);


        // description
        WaitUtils.waitForVisible(driver, description)
                .sendKeys(agenda);


        // submit meeting
        WaitUtils.waitForClickable(driver, submitMeetingBtn)
                .click();
    }


    // success message
    public String getSuccessMessage(){

        return WaitUtils.waitForVisible(driver, successToast)
                .getText();
    }

}