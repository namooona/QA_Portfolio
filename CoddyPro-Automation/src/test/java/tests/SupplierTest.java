package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.SupplierPage;

public class SupplierTest extends BaseTest {

    @Test
    public void createNewSupplier() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "testingforcoddy7@gmail.com",
                "Testingcoddy@123"
        );

        // Navigate to Suppliers
        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.goToSuppliers();

        // Verify Suppliers page is opened
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/suppliers"),
                "Suppliers page was not opened"
        );

        // Create a new supplier
        SupplierPage supplierPage = new SupplierPage(driver);

        supplierPage.addSupplier(
                "Meowsii Supplier",
                "Electrical",
                "VAT12345",
                "Meow Kumari",
                "Meowsikumari@example.com",
                "9827435223",
                "014825256",
                "cat street, Kathmandu",
                "Bagmati",
                "Kathmandu"
        );

        // Verify that the user remains on the Suppliers page
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/suppliers"),
                "Supplier was not created successfully"
        );
    }
}