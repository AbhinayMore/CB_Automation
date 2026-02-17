package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import pages.ThankYouNotePage;

public class SendThankYouNotePositiveTest extends BaseTest {

    @Test
    public void verifyUserCanSendThankYouNoteSuccessfully() {

        // 1️⃣ Open application
        driver.get("https://nell.nellinfotech.com/");

        // 2️⃣ Login
        LoginPage login = new LoginPage(driver);
        login.login("abhim8768@gmail.com", "abhinay123");

        // 3️⃣ Menu → Thank You Note
        SidebarPage sidebar = new SidebarPage(driver);
        sidebar.openMenu();
        sidebar.openThankYouNote();
        sidebar.clickTYNotesSent();

        // 4️⃣ Send Thank You Note
        ThankYouNotePage thankYou = new ThankYouNotePage(driver);

        thankYou.clickSendThankYouNote();
        thankYou.selectMember("Amol K");
        thankYou.enterBusinessAmount("50000");

        thankYou.submit();

        // 5️⃣ Validation
        Assert.assertTrue(
                thankYou.waitForSuccessMessage(),
                "Thank You Note should be sent successfully"
        );
    }
}
