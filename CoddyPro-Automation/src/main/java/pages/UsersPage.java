package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestUtils;

public class UsersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By administrationButton = By.xpath(
            "//button[@aria-controls='sidebar-group-administration']"
    );

    private By usersLink = By.xpath(
            "//a[@title='Users' and @href='/users']"
    );

    private By addUserButton = By.xpath(
            "//button[contains(normalize-space(), 'Add user')]"
    );

    private By firstNameField = By.xpath(
            "//input[@required and not(@type='email') and not(@type='password')]"
    );

    private By emailField = By.cssSelector(
            "input[type='email']"
    );

    private By selectAllButton = By.xpath(
            "//button[@type='button' and normalize-space()='Select all']"
    );

    private By initialPasswordField = By.cssSelector(
            "input[type='password'][autocomplete='new-password']"
    );

    private By createUserButton = By.xpath(
            "//button[@type='submit' and normalize-space()='Create user']"
    );

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAdministration() {
        wait.until(ExpectedConditions.elementToBeClickable(administrationButton))
                .click();

        TestUtils.pause(400);
    }

    public void clickUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(usersLink))
                .click();

        wait.until(ExpectedConditions.urlContains("/users"));

        TestUtils.pause(700);
    }

    public void clickAddUser() {
        wait.until(ExpectedConditions.elementToBeClickable(addUserButton))
                .click();

        TestUtils.pause(500);
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField))
                .sendKeys(firstName);

        TestUtils.pause(400);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
                .sendKeys(email);

        TestUtils.pause(400);
    }

    public void clickSelectAll() {
        wait.until(ExpectedConditions.elementToBeClickable(selectAllButton))
                .click();

        TestUtils.pause(500);
    }

    public void enterInitialPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(initialPasswordField))
                .sendKeys(password);

        TestUtils.pause(500);
    }

    public void clickCreateUser() {
        wait.until(ExpectedConditions.elementToBeClickable(createUserButton))
                .click();

        TestUtils.pause(1000);
    }
}