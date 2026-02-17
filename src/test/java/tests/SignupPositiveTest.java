package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignupPage;


public class SignupPositiveTest extends BaseTest {
	@DataProvider(name = "validSignupData")
	public Object[][] validSignupData() {
		return new Object[][] { { "jack", "Sparrow", generateEmail(), generateMobileNumber(), "5" },
				 };
	}

	@Test(dataProvider = "validSignupData")
	public void signupWithValidData(String firstName, String lastName, String email, String contactNumber,
			String yearsInBusiness) {

		SignupPage signupPage = new SignupPage(driver);

		signupPage.enterFirstName(firstName);
		signupPage.enterLastName(lastName);
		signupPage.enterEmail(email);
		signupPage.enterContactNumber(contactNumber);
		signupPage.enterYearsInBusiness(yearsInBusiness);
		signupPage.clickSignup();

		Assert.assertTrue(signupPage.isSignupSuccessful(), "Signup should be successful with valid data");
	}

	// 🔹 Utility method for unique email
	private String generateEmail() {
		return "user_" + System.currentTimeMillis() + "@testmail.com";
	}
	// 🔹 Utility method for unique mobile number
	private String generateMobileNumber() {
		long timeStamp = System.currentTimeMillis();
		String mobile = "9" + String.valueOf(timeStamp).substring(4, 13);
		return mobile;
	}

}
