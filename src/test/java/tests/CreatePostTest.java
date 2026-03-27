package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CreatePostPage;

public class CreatePostTest extends BaseTest {

    @Test
    public void userCreatePostSuccessfully(){

        // open application
        driver.get("https://nell.nellinfotech.com/");

        // login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "abhim8768@gmail.com",
                "abhinay1"
        );

        // create post page
        CreatePostPage createPostPage =
                new CreatePostPage(driver);

        createPostPage.clickCreatePost();


        // create post
        createPostPage.createPost(

                "Automation Testing Post",

                "This post is created using Selenium automation framework for testing create post functionality.",

                "G:\\CB_Automation\\utils img\\event.jpg"
        );


        // validation
        String message =
                createPostPage.getSuccessMessage();

        Assert.assertTrue(

                message.contains("success")
                        || message.contains("Post")
                        || message.contains("created"),

                "Post creation failed!"
        );
    }

}
