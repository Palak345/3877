package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PersonalDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PersonalDetailsSteps {

    WebDriver driver;
    PersonalDetailsPage personalDetailsPage;

    @Given("User is on the Personal Details page")
    public void userIsOnPersonalDetailsPage() {
        // Launch the browser and go to the personal details page
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");
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
}
