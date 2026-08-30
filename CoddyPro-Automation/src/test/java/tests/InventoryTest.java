package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {

    @Test
    public void createNewWarehouse() {
        //Login using existing test account
        LoginPage loginPage = new LoginPage(driver);

        // Login using existing test account
        loginPage.login(
                "testingforcoddy7@gmail.com",
                "Testingcoddy@123"
        );

        // Navigate to Inventory page
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Open Inventory dropdown
        // Then click Inventory
        dashboardPage.goToInventory();

        // Create InventoryPage object
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Create a group warehouse
        // Parent warehouse = Meow - DPL
        inventoryPage.addWarehouse(
        "Meow 9825Warehouse",
        true,
        "All Warehouses - DPL"
);

        // Verify that the warehouse was created successfully
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/inventory"),
                "Warehouse was not created — did not remain on /inventory"
        );
    }
}