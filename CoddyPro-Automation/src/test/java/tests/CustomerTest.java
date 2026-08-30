package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CustomerTest extends BaseTest {

    @Test
    public void createNewCustomer() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                "testingforcoddy7@gmail.com",
                "Testingcoddy@123"
        );

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.goToCustomers();

        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.addCustomer(
                "Meow Trading Pvt. Ltd.",
                "Commercial",
                "0925173862",
                "Meow Kumari",
                "meow@meow.com",
                "9812309876",
                "01-4123456",
                "Cat Street, Kathmandu",
                "Bagmati",
                "Kathmandu"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/clients"),
                "Customer was not created — did not redirect to /clients"
        );
    }
}
