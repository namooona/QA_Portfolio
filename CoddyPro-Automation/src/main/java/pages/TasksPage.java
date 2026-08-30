package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestUtils;

public class TasksPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Tasks & Reminders navigation link
    private By tasksLink = By.xpath(
            "//a[@href='/tasks' and .//span[contains(normalize-space(), 'Tasks & Reminders')]]"
    );

    // New Task button
    private By newTaskButton = By.xpath(
            "//button[@data-shortcut='new' and normalize-space()='New Task']"
    );

    // Task title field
    private By titleField = By.xpath(
            "//input[@placeholder='Follow up payment from ABC Traders']"
    );

    // Task description field
    private By descriptionField = By.xpath(
            "//textarea[@placeholder='Add context or next steps…']"
    );

    // Category dropdown
    private By categoryDropdown = By.xpath(
            "//select[option[normalize-space()='General'] "
            + "and option[normalize-space()='Payment Follow-up'] "
            + "and option[normalize-space()='Customer Follow-up']]"
    );

    // Status dropdown
    private By statusDropdown = By.xpath(
            "//select[option[normalize-space()='Open'] "
            + "and option[normalize-space()='In Progress']]"
    );

    // Urgent priority button
    private By urgentPriorityButton = By.xpath(
            "//button[@type='button' and normalize-space()='Urgent']"
    );

    // Assign To dropdown
    private By assignToDropdown = By.xpath(
            "//button[@aria-haspopup='listbox' "
            + "and .//span[contains(normalize-space(), 'Me (Testing for Coddy 7)')]]"
    );

    // User search field inside the Assign To dropdown
    private By userSearchFields = By.cssSelector(
            "input[placeholder='Search users by name or email...']"
    );

    // Meowsii user option
    private By meowsiiOption = By.xpath(
            "//button[@role='option' "
            + "and .//span[normalize-space()='Meowsii']]"
    );

    // Today button
    private By todayButton = By.xpath(
            "//button[@type='button' and normalize-space()='Today']"
    );

    // Frequency dropdown
    private By frequencyDropdown = By.xpath(
            "//select[option[normalize-space()='Never'] "
            + "and option[normalize-space()='Daily'] "
            + "and option[normalize-space()='Weekly'] "
            + "and option[normalize-space()='Monthly']]"
    );

    // Repeat interval field
    private By repeatIntervalField = By.cssSelector(
            "input[type='number'][min='1']"
    );

    // Create Task button
    private By createTaskButton = By.xpath(
            "//button[@data-shortcut='submit' "
            + "and normalize-space()='Create task']"
    );

    // Constructor
    public TasksPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Opens the Tasks & Reminders page
    public void clickTasks() {

        WebElement tasks = wait.until(
                ExpectedConditions.elementToBeClickable(tasksLink)
        );

        tasks.click();

        wait.until(
                ExpectedConditions.urlContains("/tasks")
        );

        TestUtils.pause(700);
    }

    // Opens the New Task form
    public void clickNewTask() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(newTaskButton)
        );

        button.click();

        TestUtils.pause(500);
    }

    // Enters the task title
    public void enterTitle(String title) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(titleField)
        );

        field.sendKeys(title);

        TestUtils.pause(400);
    }

    // Enters the task description
    public void enterDescription(String description) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(descriptionField)
        );

        field.sendKeys(description);

        TestUtils.pause(400);
    }

    // Selects the task category
    public void selectCategory(String category) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(categoryDropdown)
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText(category);

        TestUtils.pause(400);
    }

    // Selects the task status
    public void selectStatus(String status) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(statusDropdown)
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText(status);

        TestUtils.pause(400);
    }

    // Selects Urgent as the task priority
    public void selectUrgentPriority() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(urgentPriorityButton)
        );

        button.click();

        TestUtils.pause(400);
    }

    // Assigns the task to Meowsii
    public void assignToMeowsii() {

        // Locate the Assign To dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.presenceOfElementLocated(assignToDropdown)
        );

        // Scroll the dropdown into view
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                dropdown
        );

        TestUtils.pause(500);

        // Open the dropdown using JavaScript because normal click
        // can be intercepted by another page element
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                dropdown
        );

        TestUtils.pause(700);

        // Find the visible and enabled search field
        WebElement searchField = wait.until(driver -> {

            for (WebElement element : driver.findElements(userSearchFields)) {

                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                }
            }

            return null;
        });

        // Scroll the search field into view
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                searchField
        );

        TestUtils.pause(300);

        // Click the search field
        searchField.click();

        // Search for Meowsii
        searchField.sendKeys("meowsi");

        TestUtils.pause(1000);

        // Select Meowsii from the search results
        WebElement meowsii = wait.until(
                ExpectedConditions.elementToBeClickable(meowsiiOption)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                meowsii
        );

        TestUtils.pause(300);

        meowsii.click();

        TestUtils.pause(700);
    }

    // Selects Today as the due date
    public void selectToday() {

        WebElement today = wait.until(
                ExpectedConditions.elementToBeClickable(todayButton)
        );

        today.click();

        TestUtils.pause(400);
    }

    // Selects the task frequency
    public void selectFrequency(String frequency) {

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(frequencyDropdown)
        );

        Select select = new Select(dropdown);

        select.selectByVisibleText(frequency);

        TestUtils.pause(400);
    }

    // Enters the repeat interval
    public void enterRepeatInterval(String interval) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(repeatIntervalField)
        );

        field.clear();

        field.sendKeys(interval);

        TestUtils.pause(400);
    }

    // Creates the task
    public void clickCreateTask() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(createTaskButton)
        );

        button.click();

        TestUtils.pause(1000);
    }
}