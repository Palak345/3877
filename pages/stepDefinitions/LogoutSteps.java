package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutSteps {

    WebDriver driver;
    LogoutPage logoutPage;

    @Given("User is logged into the application")
    public void userIsLoggedIn() {
        // Initialize WebDriver and go to the logged-in page (adjust URL as needed)
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        logoutPage = new LogoutPage(driver);
    }

    @When("User clicks on the logout button")
    public void userClicksOnLogoutButton() {
        logoutPage.clickLogoutButton();
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToLoginPage() {
        // Verify that the login page is displayed after logout
        Assert.assertTrue(logoutPage.isOnLoginPage());
    }
}
