package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PerformancePage;

public class PerformanceSteps {

    WebDriver driver;
    PerformancePage performancePage;

    // Initialize WebDriver and PageFactory
    public PerformanceSteps() {
        driver = new ChromeDriver();
        performancePage = new PerformancePage(driver);
    }

    // Step for navigating to Performance section
    @When("I navigate to the Performance section")
    public void iNavigateToPerformanceSection() {
        performancePage.navigateToPerformanceSection();
    }

    // Step for adding a new Performance review
    @When("I add a performance review for {string} from {string} to {string} with comments {string}")
    public void iAddPerformanceReview(String employeeName, String fromDate, String toDate, String comments) {
        performancePage.addPerformanceReview(employeeName, fromDate, toDate, comments);
    }

    // Step to verify performance reviews are displayed
    @Then("I should see performance reviews displayed")
    public void iShouldSeePerformanceReviewsDisplayed() {
        Assert.assertTrue("Performance reviews are not displayed.", performancePage.arePerformanceReviewsDisplayed());
    }

    // Step for searching performance records
    @When("I search for performance records of {string}")
    public void iSearchForPerformanceRecords(String employeeName) {
        performancePage.searchPerformanceRecords(employeeName);
    }

    // Step to verify search result is displayed
    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResults(String employeeName) {
        Assert.assertTrue("Search result is not displayed for " + employeeName, performancePage.isSearchResultDisplayed(employeeName));
    }

    // Clean up after tests
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
