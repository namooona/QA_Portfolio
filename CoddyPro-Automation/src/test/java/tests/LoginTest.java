package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                "testingforcoddy7@gmail.com",
                "Testingcoddy@123"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/dashboard"),
                "Dashboard was not displayed after login"
        );
    }
}
