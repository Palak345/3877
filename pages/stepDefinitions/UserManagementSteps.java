package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PersonalDetailsPage;
import pages.ReportsPage;
import pages.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UserManagementSteps {

    WebDriver driver;
    PersonalDetailsPage personalDetailsPage;
    ReportsPage reportsPage;
    LogoutPage logoutPage;

    @Given("User is on the Personal Details page")
    public void userIsOnPersonalDetailsPage() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        personalDetailsPage = new PersonalDetailsPage(driver);
    }

    @When("User updates personal details with first name {string}, last name {string}, and employee ID {string}")
    public void userUpdatesPersonalDetails(String firstName, String lastName, String employeeId) {
        personalDetailsPage.updatePersonalDetails(firstName, lastName, employeeId);
    }

    @Then("A success message should be displayed saying {string}")
    public void successMessageShouldBeDisplayed(String expectedMessage) {
        Assert.assertTrue(personalDetailsPage.isPersonalDetailsUpdated());
    }

    @Given("User is on the Reports page")
    public void userIsOnReportsPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewReportToDetails/empNumber/7");
        reportsPage = new ReportsPage(driver);
    }

    @When("User generates a report")
    public void userGeneratesReport() {
        reportsPage.generateReport();
    }

    @Then("The report status should be {string}")
    public void reportStatusShouldBe(String expectedStatus) {
        String actualStatus = reportsPage.getReportStatus();
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @Given("User is logged into the application")
    public void userIsLoggedIn() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("User clicks on the logout button")
    public void userClicksOnLogoutButton() {
        logoutPage = new LogoutPage(driver);
        logoutPage.clickLogoutButton();
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToLoginPage() {
        Assert.assertTrue(logoutPage.isOnLoginPage());
    }
}
