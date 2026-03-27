package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class TrainingPage extends BasePage {

    // ---------- Buttons ----------

    private By scheduleTrainingBtn =
            By.xpath("//button[contains(.,'Schedule Training')]");

    private By initializeProgramBtn =
            By.xpath("//button[normalize-space()='Initialize Program']");

//    private By discardBtn =
//            By.xpath("//button[contains(.,'Discard')]");


    // ---------- Text fields ----------

    private By trainingTitle =
            By.cssSelector("input[placeholder='e.g. Advanced AI Integration']");

    private By leadTrainer =
            By.cssSelector("input[placeholder='Full Professional Name']");

    private By sessionFee =
            By.cssSelector("input[name='training_charges']");

    private By curriculumOverview =
            By.xpath("//textarea[contains(@placeholder,'Provide a comprehensive')]");

    private By trainingLink =
            By.cssSelector("input[name='training_link']");


    // ---------- Date fields ----------

    private By commencesOn =
            By.xpath("(//input[@type='date'])[1]");

    private By concludesOn =
            By.xpath("(//input[@type='date'])[2]");

    private By registrationDeadline =
            By.xpath("(//input[@type='date'])[3]");


    // ---------- Time dropdowns ----------

    private By trainingStartTime =
            By.cssSelector("select[name='training_start_time']");

    private By trainingEndTime =
            By.cssSelector("select[name='training_end_time']");


    // ---------- Mode dropdown (normal select) ----------

    private By trainingMode =
            By.cssSelector("select[name='training_mode']");


    // ---------- Banner Upload ----------

    private By bannerUpload =
            By.cssSelector("input[type='file']");


    // ---------- Success message ----------

    private By trainingSuccessToast =
            By.xpath("//div[@role='alert' and contains(.,'Training')]");


    // constructor
    public TrainingPage(WebDriver driver) {
        super(driver);
    }


    // click Schedule Training button
    public void clickScheduleTraining(){

        WaitUtils.waitForClickable(driver, scheduleTrainingBtn)
                .click();
    }


    // create training
    public void createTraining(String title,
                               String trainer,
                               String startDate,
                               String endDate,
                               String deadline,
                               String fee,
                               String startTime,
                               String endTime,
                               String mode,
                               String curriculum,
                               String bannerPath){

        // title
        WaitUtils.waitForVisible(driver, trainingTitle)
                .sendKeys(title);

        // trainer
        WaitUtils.waitForVisible(driver, leadTrainer)
                .sendKeys(trainer);

        // dates
        WaitUtils.waitForVisible(driver, commencesOn)
                .sendKeys(startDate);

        WaitUtils.waitForVisible(driver, concludesOn)
                .sendKeys(endDate);

        WaitUtils.waitForVisible(driver, registrationDeadline)
                .sendKeys(deadline);

        // fee
        WaitUtils.waitForVisible(driver, sessionFee)
                .clear();

        WaitUtils.waitForVisible(driver, sessionFee)
                .sendKeys(fee);


        // start time dropdown
        new Select(
                WaitUtils.waitForVisible(driver, trainingStartTime)
        ).selectByVisibleText(startTime);


        // end time dropdown
        new Select(
                WaitUtils.waitForVisible(driver, trainingEndTime)
        ).selectByVisibleText(endTime);


        // training mode dropdown
        new Select(
                WaitUtils.waitForVisible(driver, trainingMode)
        ).selectByVisibleText(mode);


        // curriculum
        WaitUtils.waitForVisible(driver, curriculumOverview)
                .sendKeys(curriculum);

        // if virtual session then enter meeting link
        if(mode.equalsIgnoreCase("Virtual Session")){

            WaitUtils.waitForVisible(driver, trainingLink)
                    .sendKeys("https://zoom.us/j/123456789");
        }


        // banner upload
        File img = new File(bannerPath);

        driver.findElement(bannerUpload)
                .sendKeys(img.getAbsolutePath());


        // click Initialize Program
        WebElement btn =
                WaitUtils.waitForVisible(driver, initializeProgramBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", btn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", btn); }


    public String getSuccessMessage(){

        String msg = WaitUtils.waitForVisible(driver, trainingSuccessToast)
                .getText()
                .trim();

        return msg;
    }


}