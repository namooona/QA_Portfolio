package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.TasksPage;

public class TasksTest extends BaseTest {

    @Test
    public void createTaskTest() {

        // Login to the application
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "testingforcoddy7@gmail.com",
                "Testingcoddy@123"
        );

        // Open Tasks & Reminders
        TasksPage tasksPage = new TasksPage(driver);

        tasksPage.clickTasks();

        // Open the New Task form
        tasksPage.clickNewTask();

        // Enter task title
        tasksPage.enterTitle(
                "President Meow Contact"
        );

        // Enter task description
        tasksPage.enterDescription(
                "Contact President Meow from Meow company."
        );

        // Select task category
        tasksPage.selectCategory(
                "Other"
        );

        // Select task status
        tasksPage.selectStatus(
                "Open"
        );

        // Select task priority
        tasksPage.selectUrgentPriority();

        // Assign task to Meowsii
        tasksPage.assignToMeowsii();

        // Set due date to today
        tasksPage.selectToday();

        // Select task frequency
        tasksPage.selectFrequency(
                "Daily"
        );

        // Set repeat interval
        tasksPage.enterRepeatInterval(
                "2"
        );

        // Create the task
        tasksPage.clickCreateTask();
    }
}