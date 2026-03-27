package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidebarPage;
import pages.MemberMeetingPage;

public class MemberMeetingPositiveTest extends BaseTest {

    @Test
    public void verifyUserCanScheduleMemberMeetingSuccessfully() {

        // 1️⃣ Open application
        driver.get("https://nell.nellinfotech.com/");

        // 2️⃣ Login
        LoginPage login = new LoginPage(driver);
        login.login(
                "adujagtap1399@gmail.com",
                "Aditya123"
        );

        // 3️⃣ Sidebar → Meetings → Member Meetings
        SidebarPage sidebar = new SidebarPage(driver);
        sidebar.openMemberMeetings();

        // 4️⃣ Schedule Meeting
        MemberMeetingPage meeting =
                new MemberMeetingPage(driver);

        meeting.clickScheduleMeetingButton();

        meeting.enterSubject("Weekly Member Connect");

        meeting.selectParticipant("Aditya Jagtap");

        meeting.selectDate("02-12-2026");

        meeting.selectMeetingMode(
                "Virtual",
                "https://meet.google.com/abc-defg-hij"
        );

        meeting.selectStartTime("10:00:AM");
        meeting.selectEndTime("11:00:AM");

        meeting.enterDescription(
                "Automation scheduled meeting"
        );

        meeting.clickScheduleButton();

        // 5️⃣ Assertion
        Assert.assertTrue(
                meeting.isMeetingScheduledSuccessfully(),
                "Meeting should be scheduled successfully"
        );
    }
}