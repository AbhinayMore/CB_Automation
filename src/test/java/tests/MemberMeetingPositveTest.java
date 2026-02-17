package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import pages.MemberMeetingPage;

public class MemberMeetingPositveTest extends BaseTest {

    @Test
    public void verifyUserCanScheduleMemberMeetingSuccessfully() {

        // 1️⃣ Open app
        driver.get("https://nell.nellinfotech.com/");

        // 2️⃣ Login
        LoginPage login = new LoginPage(driver);
        login.login("abhim8768@gmail.com", "abhinay123");

        // 3️⃣ Menu → Meetings → Member Meetings
        SidebarPage sidebar = new SidebarPage(driver);
        sidebar.openMenu();
        sidebar.openMemberMeetings();

        // 4️⃣ Schedule meeting
        MemberMeetingPage meeting = new MemberMeetingPage(driver);

        meeting.clickScheduleMeets();

//        meeting.selectMeetsMode("Virtual");
        meeting.enterMeetLink("https://meet.google.com/abc-defg-hij");
        meeting.selectDate("2026-02-15");
        meeting.selectStartTime("10:00 AM");
        meeting.selectEndTime("11:00 AM");
        meeting.selectMember("Amol K");
        meeting.enterDescription("Automation scheduled meeting");

        meeting.clickSchedule();

        // 5️⃣ Validation
        Assert.assertTrue(
                meeting.waitForSuccessMessage(),
                "Member meeting should be scheduled successfully"
        );
    }

}
