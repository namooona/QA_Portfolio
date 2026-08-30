package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addCustomerButton = By.xpath("//button[contains(.,'Add customer')]");

    private By customerNameField = By.name("customer_name");
    private By customerGroupDropdown = By.name("customer_group");
    private By taxIdField = By.name("tax_id");
    private By contactNameField = By.name("contact_name");
    private By emailField = By.name("email_id");
    private By mobileField = By.name("mobile_no");
    private By companyPhoneField = By.name("company_phone");
    private By addressLine1Field = By.name("address_line1");

    private By provinceDropdown = By.xpath("//select[option[text()='Select province']]");
    private By districtDropdown = By.xpath("//select[option[text()='Select district']]");

    private By saveButton = By.cssSelector("button[form='customer-form'][type='submit']");

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton)).click();
    }

    public void enterCustomerName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameField))
                .sendKeys(name);
    }

    public void selectCustomerGroup(String group) {
        Select select = new Select(
                wait.until(ExpectedConditions.visibilityOfElementLocated(customerGroupDropdown))
        );
        select.selectByVisibleText(group);
    }

    public void enterTaxId(String taxId) {
        driver.findElement(taxIdField).sendKeys(taxId);
    }

    public void enterContactName(String contactName) {
        driver.findElement(contactNameField).sendKeys(contactName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterMobile(String mobile) {
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void enterCompanyPhone(String phone) {
        driver.findElement(companyPhoneField).sendKeys(phone);
    }

    public void enterAddressLine1(String address) {
        driver.findElement(addressLine1Field).sendKeys(address);
    }

    public void selectProvince(String province) {
        Select select = new Select(
                wait.until(ExpectedConditions.visibilityOfElementLocated(provinceDropdown))
        );
        select.selectByVisibleText(province);
    }

    public void selectDistrict(String district) {
        Select select = new Select(
                wait.until(ExpectedConditions.visibilityOfElementLocated(districtDropdown))
        );
        select.selectByVisibleText(district);
    }

    public void clickSave() {
        System.out.println("###### CLICKSAVE METHOD ENTERED ######");

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        System.out.println("Save clicked");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("URL after save: " + driver.getCurrentUrl());
        System.out.println("Page text: " + driver.findElement(By.tagName("body")).getText());
    }

    public void addCustomer(String name, String group, String taxId, String contactName,
                             String email, String mobile, String companyPhone,
                             String addressLine1, String province, String district) {
        clickAddCustomer();
        enterCustomerName(name);
        selectCustomerGroup(group);
        enterTaxId(taxId);
        enterContactName(contactName);
        enterEmail(email);
        enterMobile(mobile);
        enterCompanyPhone(companyPhone);
        enterAddressLine1(addressLine1);
        selectProvince(province);
        selectDistrict(district);
        clickSave();
    }
}
