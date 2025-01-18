package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TimePage;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class TimeSteps {
    WebDriver driver;
    TimePage timePage;

    @Given("User navigates to the {string} section")
    public void userNavigatesToSection(String section) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewMyTimesheet");
        timePage = new TimePage(driver);
        if (section.equalsIgnoreCase("Time")) {
            timePage.navigateToTimeSection();
        }
    }

    @Then("The {string} page should be displayed")
    public void thePageShouldBeDisplayed(String pageName) {
        timePage.viewTimesheets();
        Assert.assertTrue(driver.getTitle().contains(pageName));
    }

    @When("User adds a new time entry with project {string}, activity {string}, and hours {string}")
    public void userAddsNewTimeEntry(String project, String activity, String hours) {
        timePage.addTimeEntry(project, activity, hours);
    }

    @Then("The time entry should be successfully added")
    public void theTimeEntryShouldBeSuccessfullyAdded() {
        Assert.assertTrue(timePage.isTimeEntryAdded());
    }

    @When("User deletes a time entry with project {string} and activity {string}")
    public void userDeletesTimeEntry(String project, String activity) {
        timePage.deleteTimeEntry();
    }

    @Then("The time entry should no longer be listed")
    public void theTimeEntryShouldNoLongerBeListed() {
        Assert.assertFalse(timePage.isTimeEntryVisible("Project X"));
    }
}
