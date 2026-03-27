package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import pages.TrainingPage;

public class CreateTrainingTest extends BaseTest{

    @Test
    public void chapterAdminShouldCreateTrainingSuccessfully(){

        driver.get("https://nell.nellinfotech.com/");

        // login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "pratikshamali5050@gmail.com",
                "Pratiksha123"
        );

        // sidebar training page
        SidebarPage sidebarPage =
                new SidebarPage(driver);

        sidebarPage.openTrainingPage();


        // training page
        TrainingPage trainingPage =
                new TrainingPage(driver);

        trainingPage.clickScheduleTraining();


        // create training
        trainingPage.createTraining(

                "AI Automation Training",

                "Nell Infotech Trainer",

                "2026-03-25",
                "2026-03-30",

                "2026-03-24",

                "5000",

                "10:00 AM",
                "12:30 PM",

                "Virtual Session",

                "This training program covers AI automation concepts, real world implementation, and hands-on exercises.",

                "G:\\CB_Automation\\utils img\\event.jpg"
        );



        // validation
        // verify success message
        String actualMessage =
                trainingPage.getSuccessMessage();

        System.out.println("Toast message = " + actualMessage);

        Assert.assertTrue(

                actualMessage.contains("Training scheduled successfully"),

                "Training creation failed!"
        );

    }
}
