package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import pages.ChapterMeetingPage;

public class ChapterAdminCreateMeetingTest extends BaseTest {

    @Test
    public void chapterAdminShouldScheduleMeetingSuccessfully(){

        driver.get("https://nell.nellinfotech.com/");

        // login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "pratikshamali5050@gmail.com",
                "Pratiksha123"
        );


        // open meeting page
        SidebarPage sidebarPage =
                new SidebarPage(driver);

        sidebarPage.openChapterMeetingsPage();


        // meeting page
        ChapterMeetingPage meetingPage =
                new ChapterMeetingPage(driver);

        meetingPage.clickScheduleMeetingButton();


        // create meeting
        meetingPage.createMeeting(

                "Monthly Strategy Meeting",

                "In-Person",

                "Hotel Royal, Conference Hall A",

                "28-03-2027",

                "27-03-2027",

                "10:00:AM",

                "11:00:AM",

                "1000",

                "https://rzp.io/l/test123",

                "Discussion about monthly goals, performance and strategy."
        );


        // assertion
        String actualMessage =
                meetingPage.getSuccessMessage();

        Assert.assertTrue(

                actualMessage.contains("Meeting scheduled successfully")
                        || actualMessage.contains("success"),

                "Meeting scheduling failed!"
        );

    }
}