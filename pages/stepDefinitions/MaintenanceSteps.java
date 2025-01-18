package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MaintenancePage;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class MaintenanceSteps {
    WebDriver driver;
    MaintenancePage maintenancePage;

    @Given("User navigates to the {string} section")
    public void userNavigatesToSection(String section) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/maintenance");
        maintenancePage = new MaintenancePage(driver);
        if (section.equalsIgnoreCase("Maintenance")) {
            maintenancePage.navigateToMaintenanceSection();
        }
    }

    @Then("The {string} page should be displayed")
    public void thePageShouldBeDisplayed(String pageName) {
        Assert.assertTrue(maintenancePage.isRecordAdded());
    }

    @When("User adds a maintenance record with type {string} and description {string}")
    public void userAddsMaintenanceRecord(String type, String description) {
        maintenancePage.addMaintenanceRecord(type, description);
    }

    @Then("The record should be successfully added")
    public void theRecordShouldBeSuccessfullyAdded() {
        Assert.assertTrue(maintenancePage.isRecordAdded());
    }

    @When("User deletes a maintenance record with type {string}")
    public void userDeletesMaintenanceRecord(String type) {
        maintenancePage.deleteMaintenanceRecord();
    }

    @Then("The record should no longer be listed")
    public void theRecordShouldNoLongerBeListed() {
        Assert.assertFalse(maintenancePage.isRecordVisible("System Check"));
    }
}
