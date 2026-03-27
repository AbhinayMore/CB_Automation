package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

import java.io.File;
public class CreatePostPage extends BasePage{

    // -------- Buttons --------

    private By createPostButton =
            By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div/div/div[2]/div[3]");

    private By shareWithCommunityBtn =
            By.xpath("//button[contains(text(),'Share with Community')]");


    // -------- Headline --------

    private By headlineField =
            By.cssSelector("textarea[name='title']");


    // -------- Detailed Story --------

    private By detailedStory =
            By.cssSelector("textarea[name='description']");


    // -------- Image Upload --------

    private By galleryUpload =
            By.xpath("//input[@type='file']");


    // -------- Success Toast --------

    private By successToast =
            By.cssSelector("div[role='alert']");


    // constructor
    public CreatePostPage(WebDriver driver) {
        super(driver);
    }


    // click create post
    public void clickCreatePost() {

        WaitUtils.waitForClickable(driver, createPostButton).click();
    }


    // create post flow
    public void createPost(String headline,
                           String description,
                           String imagePath){

        // headline
        WaitUtils.waitForVisible(driver, headlineField)
                .sendKeys(headline);

        // upload image
        File img = new File(imagePath);

        driver.findElement(galleryUpload)
                .sendKeys(img.getAbsolutePath());

        // description
        WaitUtils.waitForVisible(driver, detailedStory)
                .sendKeys(description);

        // share post
        WaitUtils.waitForClickable(driver, shareWithCommunityBtn)
                .click();
    }


    // success message
    public String getSuccessMessage(){

        return WaitUtils.waitForVisible(driver, successToast)
                .getText();
    }

}
