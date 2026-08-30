package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Add Warehouse button
    private By addWarehouseButton = By.xpath(
            "//button[contains(.,'Add Warehouse')]"
    );

    // Warehouse Name input
    private By warehouseNameField = By.xpath(
            "//input[@required and not(@type='checkbox')]"
    );

    // "Is Group Warehouse?" checkbox
    private By groupWarehouseCheckbox = By.id(
            "is_group"
    );

    // Parent Warehouse dropdown
    private By parentWarehouseDropdown = By.xpath(
            "//button[@role='combobox']" +
            "[.//span[normalize-space()='Select Parent (Optional)']]"
    );

    // Save button
    private By saveButton = By.xpath(
            "//button[@type='submit' and normalize-space()='Save']"
    );

        // Constructor
    public InventoryPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

        // Add Warehouse button
    public void clickAddWarehouse() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addWarehouseButton
                )
        ).click();
    }

        // Warehouse Name input
    public void enterWarehouseName(String warehouseName) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        warehouseNameField
                )
        ).sendKeys(warehouseName);
    }

    public void selectGroupWarehouse() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        groupWarehouseCheckbox
                )
        ).click();
    }

public void clickParentWarehouseDropdown() {

    wait.until(
            ExpectedConditions.elementToBeClickable(
                    parentWarehouseDropdown
            )
    ).click();
}


public void selectParentWarehouse(String warehouseName) {

    // Open Parent Warehouse dropdown
    clickParentWarehouseDropdown();

    // Locate the actual dropdown option
    By warehouseOption = By.xpath(
            "//div[@role='option' and normalize-space(.)='"
            + warehouseName
            + "']"
    );

    // Select the option
    wait.until(
            ExpectedConditions.elementToBeClickable(
                    warehouseOption
            )
    ).click();
}

    public void clickSave() {

        System.out.println(
                "###### CLICK SAVE METHOD ENTERED ######"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        saveButton
                )
        ).click();

        System.out.println("Save clicked");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
                "URL after save: " + driver.getCurrentUrl()
        );

        System.out.println(
                "Page text: " +
                driver.findElement(By.tagName("body")).getText()
        );
    }


    public void addWarehouse(
            String warehouseName,
            boolean isGroupWarehouse,
            String parentWarehouse
    ) {

        // Click Add Warehouse
        clickAddWarehouse();

        // Enter Warehouse Name
        enterWarehouseName(warehouseName);

        // Select Group Warehouse if required
        if (isGroupWarehouse) {

            selectGroupWarehouse();

            // Select Parent Warehouse
            selectParentWarehouse(parentWarehouse);
        }

        // Save Warehouse
        clickSave();
    }
}