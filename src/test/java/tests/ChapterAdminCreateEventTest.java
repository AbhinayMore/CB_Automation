package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import pages.CreateEventPage;

public class ChapterAdminCreateEventTest extends BaseTest {

    @Test
    public void chapterAdminShouldCreateEventSuccessfully() {

        // 1️⃣ Open application
        driver.get("https://nell.nellinfotech.com/");

        // 2️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                "pratikshamali5050@gmail.com",
                "Pratiksha123"
        );

        // 3️⃣ Open Event page from sidebar
        SidebarPage sidebarPage = new SidebarPage(driver);
        sidebarPage.openEventPage();

        // 4️⃣ Click Create Event button
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.clickCreateEventButton();

        // 5️⃣ Fill Create Event form
        createEventPage.createEvent(

                "Automation Chapter Event",
                "Nell Infotech",
                "Grand Ballroom Pune",

                "30-03-2026",        // type=date
                "30-03-2026",        // type=date

                "2026-03-24T18:30",  // type=datetime-local

                "500",

                "10:00:AM",             // type=time
                "12:00:AM",             // type=time

                "In-Person Experience",

                "This event is created using Selenium automation framework.",

                "G:\\CB_Automation\\utils img\\event.jpg"
        );

// verify success message
        String actualMessage = createEventPage.getSuccessMessage();

        Assert.assertTrue(
                actualMessage.contains("Event created successfully"),
                "Event creation failed!"
        );
    }
}