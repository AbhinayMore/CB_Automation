package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupValidationTest extends BaseTest {
    @Test
    public void verifyInvalidEmailValidation() {

        SignupPage signup = new SignupPage(driver);

        signup.enterFirstName("Amit");
        signup.enterLastName("Patil");
        signup.enterEmail("amitgmail.com"); // ❌ invalid email
        signup.enterContactNumber(generateMobileNumber());
        signup.enterYearsInBusiness("3");
        signup.clickSignup();

        Assert.assertTrue(
                signup.isErrorMessageDisplayed(),
                "Error message should be shown for invalid email"
        );
    }

    @Test
    public void verifyInvalidMobileNumberValidation() {

        SignupPage signup = new SignupPage(driver);

        signup.enterFirstName("Amit");
        signup.enterLastName("Patil");
        signup.enterEmail(generateEmail());
        signup.enterContactNumber("12345"); // ❌ invalid mobile
        signup.enterYearsInBusiness("3");
        signup.clickSignup();

        Assert.assertTrue(
                signup.isErrorMessageDisplayed(),
                "Error message should be shown for invalid mobile number"
        );
    }

    // 🔹 Utility methods

    private String generateEmail() {
        return "user_" + System.currentTimeMillis() + "@testmail.com";
    }

    private String generateMobileNumber() {
        long timeStamp = System.currentTimeMillis();
        return "9" + String.valueOf(timeStamp).substring(4, 13);
    }

}
