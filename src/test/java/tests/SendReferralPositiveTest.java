package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import pages.ReferralPage;

public class SendReferralPositiveTest extends BaseTest {

    @Test
    public void verifyUserCanSendReferralSuccessfully() {

        // 1️⃣ Open application
        driver.get("https://nell.nellinfotech.com/");

        // 2️⃣ Login
        LoginPage login = new LoginPage(driver);
        login.login(
                "abhim8768@gmail.com",
                "abhinay1"
        );

        // 3️⃣ Sidebar → Referrals → Referrals Sent
        SidebarPage sidebar = new SidebarPage(driver);
        sidebar.openReferrals();
        sidebar.openReferralsSent();

        // 4️⃣ Click Send Referral button
        ReferralPage referral = new ReferralPage(driver);
        referral.clickSendReferralButton();

        // 5️⃣ Fill referral form
        referral.selectMember("Abhinay More");

        referral.enterClientName("Automation Lead");

        referral.enterContactNumber(generateMobileNumber());

        referral.selectPriorityLevel("Hot");

        referral.enterCompanyName("Test Company");

        referral.enterAdditionalNotes(
                "Referral created via automation"
        );

        referral.submitReferral();

        // 6️⃣ Assertion
        Assert.assertTrue(
                referral.isReferralSentSuccessfully(),
                "Referral was not sent successfully"
        );
    }


    // Dynamic mobile number generator
    private String generateMobileNumber() {

        long timestamp = System.currentTimeMillis();

        return "9" + String.valueOf(timestamp).substring(4, 13);
    }
}