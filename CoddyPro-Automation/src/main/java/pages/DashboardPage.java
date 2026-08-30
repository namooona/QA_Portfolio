package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By customersLink = By.cssSelector("a[href='/clients']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToCustomers() {
        wait.until(ExpectedConditions.elementToBeClickable(customersLink)).click();
        wait.until(ExpectedConditions.urlContains("/clients"));
    }
}
