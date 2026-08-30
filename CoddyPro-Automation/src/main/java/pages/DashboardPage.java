package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Customers link
    private By customersLink = By.cssSelector(
            "a[href='/clients']"
    );

    // Inventory dropdown button
    // We target the button that contains the chevron-down SVG.
    private By inventoryDropdown = By.xpath(
            "//*[@id='root']/div[1]/div[2]/aside/div/div[3]/nav/div[5]/button"
    );

    // Inventory link inside the dropdown
    private By inventoryLink = By.cssSelector(
            "a[href='/inventory']"
    );


    public DashboardPage(WebDriver driver) {

        this.driver = driver;

        // Explicit wait of 10 seconds
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }


    // =========================================================
    // CUSTOMERS
    // =========================================================

    public void goToCustomers() {

        // Click Customers
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        customersLink
                )
        ).click();

        // Verify Customers page opened
        wait.until(
                ExpectedConditions.urlContains("/clients")
        );
    }


    // =========================================================
    // INVENTORY
    // =========================================================

    public void goToInventory() {

        // Step 1: Open Inventory dropdown
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        inventoryDropdown
                )
        ).click();

        // Step 2: Click Inventory
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        inventoryLink
                )
        ).click();

        // Step 3: Verify Inventory page opened
        wait.until(
                ExpectedConditions.urlContains("/inventory")
        );
    }
}