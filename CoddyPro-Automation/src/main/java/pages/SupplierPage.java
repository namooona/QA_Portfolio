package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestUtils;

public class SupplierPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Purchasing dropdown
    private By purchasingDropdown = By.xpath(
            "//nav/div[4]/button"
    );

    // Suppliers link
    private By suppliersLink = By.cssSelector(
            "a[href='/suppliers']"
    );

    // Add Supplier button
    private By addSupplierButton = By.xpath(
            "//button[normalize-space()='Add Supplier']"
    );

    // Supplier name
    private By supplierNameField = By.name(
            "supplier_name"
    );

    // Supplier group
    private By supplierGroupDropdown = By.name(
            "supplier_group"
    );

    // VAT / Tax ID
    private By taxIdField = By.name(
            "tax_id"
    );

    // Contact name
    private By contactNameField = By.name(
            "contact_name"
    );

    // Email
    private By emailField = By.name(
            "email_id"
    );

    // Mobile number
    private By mobileNumberField = By.name(
            "mobile_no"
    );

    // Company phone
    private By companyPhoneField = By.name(
            "company_phone"
    );

    // Billing address
    private By billingAddressField = By.name(
            "address_line1"
    );

    // Province
    private By provinceDropdown = By.xpath(
            "//select[option[normalize-space()='Select province']]"
    );

    // District
    private By districtDropdown = By.xpath(
            "//select[option[normalize-space()='Select district']]"
    );

    // Create Supplier button
    private By createSupplierButton = By.xpath(
            "//button[@form='supplier-form' and @type='submit']"
    );

    public SupplierPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // Open Purchasing dropdown
    public void clickPurchasingDropdown() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        purchasingDropdown
                )
        ).click();

        TestUtils.pause(500);
    }

    // Open Suppliers
    public void clickSuppliers() {

        WebElement suppliers = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        suppliersLink
                )
        );

        suppliers.click();

        wait.until(
                ExpectedConditions.urlContains("/suppliers")
        );

        TestUtils.pause(700);
    }

    // Click Add Supplier
    public void clickAddSupplier() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addSupplierButton
                )
        ).click();

        TestUtils.pause(500);
    }

    // Enter supplier name
    public void enterSupplierName(String supplierName) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        supplierNameField
                )
        );

        field.clear();
        field.sendKeys(supplierName);

        TestUtils.pause(300);
    }

    // Select supplier group
    public void selectSupplierGroup(String supplierGroup) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        supplierGroupDropdown
                )
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText(supplierGroup);

        TestUtils.pause(400);
    }

    // Enter VAT / Tax ID
    public void enterTaxId(String taxId) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        taxIdField
                )
        );

        field.clear();
        field.sendKeys(taxId);

        TestUtils.pause(300);
    }

    // Enter contact name
    public void enterContactName(String contactName) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        contactNameField
                )
        );

        field.clear();
        field.sendKeys(contactName);

        TestUtils.pause(300);
    }

    // Enter email
    public void enterEmail(String email) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        emailField
                )
        );

        field.clear();
        field.sendKeys(email);

        TestUtils.pause(300);
    }

    // Enter mobile number
    public void enterMobileNumber(String mobileNumber) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        mobileNumberField
                )
        );

        field.clear();
        field.sendKeys(mobileNumber);

        TestUtils.pause(300);
    }

    // Enter company phone
    public void enterCompanyPhone(String companyPhone) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        companyPhoneField
                )
        );

        field.clear();
        field.sendKeys(companyPhone);

        TestUtils.pause(300);
    }

    // Enter billing address
    public void enterBillingAddress(String address) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        billingAddressField
                )
        );

        field.clear();
        field.sendKeys(address);

        TestUtils.pause(300);
    }

    // Select province
    public void selectProvince(String province) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        provinceDropdown
                )
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText(province);

        TestUtils.pause(500);
    }

    // Select district
    public void selectDistrict(String district) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        districtDropdown
                )
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText(district);

        TestUtils.pause(500);
    }

    // Click Create Supplier
    public void clickCreateSupplier() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        createSupplierButton
                )
        ).click();

        TestUtils.pause(1000);
    }

    // Complete supplier creation flow
    public void addSupplier(
            String supplierName,
            String supplierGroup,
            String taxId,
            String contactName,
            String email,
            String mobileNumber,
            String companyPhone,
            String address,
            String province,
            String district
    ) {

        // Step 1: Click Add Supplier
        clickAddSupplier();

        // Step 2: Enter supplier name
        enterSupplierName(supplierName);

        // Step 3: Select supplier group
        selectSupplierGroup(supplierGroup);

        // Step 4: Enter VAT / Tax ID
        enterTaxId(taxId);

        // Step 5: Enter contact name
        enterContactName(contactName);

        // Step 6: Enter email
        enterEmail(email);

        // Step 7: Enter mobile number
        enterMobileNumber(mobileNumber);

        // Step 8: Enter company phone
        enterCompanyPhone(companyPhone);

        // Step 9: Enter billing address
        enterBillingAddress(address);

        // Step 10: Select province
        selectProvince(province);

        // Step 11: Select district
        selectDistrict(district);

        // Step 12: Create supplier
        clickCreateSupplier();
    }
}