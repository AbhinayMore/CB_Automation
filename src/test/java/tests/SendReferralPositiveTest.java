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

        // 1️⃣ Open app
        driver.get("https://nell.nellinfotech.com/");

        // 2️⃣ Login
        LoginPage login = new LoginPage(driver);
        login.login("abhim8768@gmail.com", "abhinay123");

        // 3️⃣ Open menu → Referrals Sent
        SidebarPage sidebar = new SidebarPage(driver);
        sidebar.openMenu();
        sidebar.openReferrals();
        sidebar.openReferralsSent();

        // 4️⃣ Send Referral
        ReferralPage referral = new ReferralPage(driver);
        referral.clickSendReferral();

        referral.selectMember("Amol K");
        referral.selectFlag("Hot");

        referral.fillReferralForm(
                "Automation Lead",
                "lead@testmail.com",
                generateMobileNumber(),
                "Test Company",
                "Referral created via automation"
        );

        referral.submit();

        // 5️⃣ Validation
        Assert.assertTrue(
                referral.waitForSuccessMessage(),
                "Success alert was shown in UI but automation could not detect it"
        );

    }

    private String generateMobileNumber() {
        long ts = System.currentTimeMillis();
        return "9" + String.valueOf(ts).substring(4, 13);
    }
}
