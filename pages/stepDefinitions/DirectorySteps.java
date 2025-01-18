package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DirectoryPage;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class DirectorySteps {
    WebDriver driver;
    DirectoryPage directoryPage;

    @Given("User navigates to the {string} section")
    public void userNavigatesToSection(String section) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/directory");
        directoryPage = new DirectoryPage(driver);
        if (section.equalsIgnoreCase("Directory")) {
            directoryPage.navigateToDirectorySection();
        }
    }

    @When("User searches for an employee with name {string}")
    public void userSearchesForEmployee(String name) {
        directoryPage.searchForEmployee(name);
    }

    @Then("The employee's information should be displayed")
    public void theEmployeeInformationShouldBeDisplayed() {
        Assert.assertTrue(directoryPage.isEmployeeVisible("Palak Mangal"));
    }

    @Then("No results should be displayed")
    public void noResultsShouldBeDisplayed() {
        Assert.assertTrue(directoryPage.isNoRecordsFound());
    }
}
