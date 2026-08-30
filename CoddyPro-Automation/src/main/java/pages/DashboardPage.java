package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Customers
    private By customersLink = By.cssSelector(
            "a[href='/clients']"
    );

    // Inventory
    private By inventoryDropdown = By.xpath(
            "//*[@id='root']/div[1]/div[2]/aside/div/div[3]/nav/div[5]/button"
    );

    private By inventoryLink = By.cssSelector(
            "a[href='/inventory']"
    );

    // Purchasing
    private By purchasingDropdown = By.xpath(
            "//nav/div[4]/button"
    );

    private By suppliersLink = By.cssSelector(
            "a[href='/suppliers']"
    );

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Navigate to Customers
    public void goToCustomers() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        customersLink
                )
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/clients")
        );
    }

    // Navigate to Inventory
    public void goToInventory() {

        // Open Inventory dropdown
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        inventoryDropdown
                )
        ).click();

        // Click Inventory
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        inventoryLink
                )
        ).click();

        // Verify Inventory page
        wait.until(
                ExpectedConditions.urlContains("/inventory")
        );
    }

    // Navigate to Suppliers
    public void goToSuppliers() {

        // Open Purchasing dropdown
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        purchasingDropdown
                )
        ).click();

        // Wait for Suppliers link
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        suppliersLink
                )
        );

        // Scroll Suppliers link into view
        WebElement suppliers = driver.findElement(
                suppliersLink
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                suppliers
        );

        // Click Suppliers
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        suppliersLink
                )
        ).click();

        // Verify Suppliers page
        wait.until(
                ExpectedConditions.urlContains("/suppliers")
        );
    }
}