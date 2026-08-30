package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupplierPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Add Supplier button
    private By addSupplierButton = By.xpath(
            "//button[normalize-space()='Add Supplier']"
    );

    // Supplier / Company Name
    private By supplierNameField = By.name(
            "supplier_name"
    );

    // Supplier Group
    private By supplierGroupDropdown = By.name(
            "supplier_group"
    );

    // VAT / Tax ID
    private By taxIdField = By.name(
            "tax_id"
    );

    // Contact Name
    private By contactNameField = By.name(
            "contact_name"
    );

    // Email
    private By emailField = By.name(
            "email_id"
    );

    // Mobile Number
    private By mobileNumberField = By.name(
            "mobile_no"
    );

    // Company Phone
    private By companyPhoneField = By.name(
            "company_phone"
    );

    // Billing Address
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

    // Click Add Supplier
    public void clickAddSupplier() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addSupplierButton
                )
        ).click();
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
    }

    // Click Create Supplier
    public void clickCreateSupplier() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        createSupplierButton
                )
        ).click();
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

        // Click Add Supplier
        clickAddSupplier();

        // Enter supplier name
        enterSupplierName(supplierName);

        // Select supplier group
        selectSupplierGroup(supplierGroup);

        // Enter VAT / Tax ID
        enterTaxId(taxId);

        // Enter contact name
        enterContactName(contactName);

        // Enter email
        enterEmail(email);

        // Enter mobile number
        enterMobileNumber(mobileNumber);

        // Enter company phone
        enterCompanyPhone(companyPhone);

        // Enter billing address
        enterBillingAddress(address);

        // Select province
        selectProvince(province);

        // Select district
        selectDistrict(district);

        // Create supplier
        clickCreateSupplier();
    }
}