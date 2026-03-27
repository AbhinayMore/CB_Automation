package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

import java.io.File;

public class CreateEventPage extends BasePage {

    // ---------- Buttons ----------
    private By createEventButton =
            By.xpath("//button[contains(.,'Create Event')]");

    private By finalizePublishBtn =
            By.cssSelector("button[type='submit']");

    private By discardBtn =
            By.xpath("//button[contains(.,'Discard')]");


    // ---------- Text Fields ----------
    private By eventTopic =
            By.cssSelector("input[placeholder='e.g. Annual Strategic Growth Summit']");

    private By organizerName =
            By.cssSelector("input[placeholder='Executive Lead Name']");

    private By venueAddress =
            By.cssSelector("input[placeholder='Grand Ballroom, Plaza Hotel']");

    private By investmentAmount =
            By.cssSelector("input[type='number']");

    private By narrativeOverview =
            By.xpath("//textarea");


    // ---------- Date Fields ----------
    private By launchDate =
            By.xpath("(//input[@type='date'])[1]");

    private By conclusionDate =
            By.xpath("(//input[@type='date'])[2]");


    // ---------- Date + Time ----------
    private By rsvpDeadline =
            By.cssSelector("input[type='datetime-local']");


    // ---------- Time Fields ----------
    private By commencementTime =
            By.xpath("(//input[@type='time'])[1]");

    private By adjournmentTime =
            By.xpath("(//input[@type='time'])[2]");


    // ---------- Atmosphere dropdown (HeadlessUI) ----------
    private By atmosphereDropdown =
            By.xpath("//button[@aria-haspopup='listbox']");

    private By modeOption(String mode){
        return By.xpath("//li[normalize-space()='"+mode+"'] | //div[normalize-space()='"+mode+"']");
    }


    // ---------- Image Upload ----------
    private By visualManifestUpload =
            By.xpath("//input[@type='file']");


    // ---------- Constructor ----------
    public CreateEventPage(WebDriver driver) {
        super(driver);
    }


    // ---------- Click Create Event button ----------
    public void clickCreateEventButton() {
        WaitUtils.waitForClickable(driver, createEventButton).click();
    }


    // ---------- Select Atmosphere ----------
    public void selectAtmosphere(String mode){

        WaitUtils.waitForClickable(driver, atmosphereDropdown).click();

        WaitUtils.waitForClickable(driver, modeOption(mode)).click();
    }

//    Succes mesaage
private By successMessage =
        By.cssSelector("div[role='alert']");


    // ---------- Create Event ----------
    public void createEvent(String topic,
                            String organizer,
                            String venue,
                            String launch,
                            String conclusion,
                            String rsvpDateTime,
                            String investment,
                            String startTime,
                            String endTime,
                            String mode,
                            String narrative,
                            String imagePath) {

        // Event topic
        WaitUtils.waitForVisible(driver, eventTopic).sendKeys(topic);

        // Organizer
        WaitUtils.waitForVisible(driver, organizerName).sendKeys(organizer);

        // Venue
        WaitUtils.waitForVisible(driver, venueAddress).sendKeys(venue);

        // Launch date
        WaitUtils.waitForVisible(driver, launchDate).sendKeys(launch);

        // Conclusion date
        WaitUtils.waitForVisible(driver, conclusionDate).sendKeys(conclusion);

        // RSVP deadline (date + time)
        WaitUtils.waitForVisible(driver, rsvpDeadline).sendKeys(rsvpDateTime);

        // Investment amount
        WaitUtils.waitForVisible(driver, investmentAmount).sendKeys(investment);

        // Commencement time
        WaitUtils.waitForVisible(driver, commencementTime).sendKeys(startTime);

        // Adjournment time
        WaitUtils.waitForVisible(driver, adjournmentTime).sendKeys(endTime);

        // Atmosphere
        selectAtmosphere(mode);

        // Narrative
        WaitUtils.waitForVisible(driver, narrativeOverview).sendKeys(narrative);

        // Image upload
        File img = new File(imagePath);

        driver.findElement(visualManifestUpload)
                .sendKeys(img.getAbsolutePath());

        // Finalize & Publish
        WaitUtils.waitForClickable(driver, finalizePublishBtn).click();


    }
    public String getSuccessMessage(){

        return WaitUtils.waitForVisible(driver, successMessage)
                .getText();
    }
}