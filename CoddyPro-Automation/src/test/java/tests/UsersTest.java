package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UsersPage;

public class UsersTest extends BaseTest {

    @Test
    public void createUserTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "testingforcoddy7@gmail.com",
                "Testingcoddy@123"
        );

        // Go to Users
        UsersPage usersPage = new UsersPage(driver);

        usersPage.clickAdministration();
        usersPage.clickUsers();

        // Add User
        usersPage.clickAddUser();

        // Enter user details
        usersPage.enterFirstName("Meowsii");
        usersPage.enterEmail("meowsi77@gmail.com");

        // Select all permissions
        usersPage.clickSelectAll();

        // Enter initial password
        usersPage.enterInitialPassword("Meowsii@12345");

        // Create user
        usersPage.clickCreateUser();
    }
}