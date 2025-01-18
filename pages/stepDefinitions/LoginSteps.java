package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.LoginPage;

import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I navigate to the OrangeHRM login page")
    public void iNavigateToTheOrangeHRMLoginPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("I log in with {string} and {string}")
    public void iLogInWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see the dashboard page")
    public void iShouldSeeTheDashboardPage() {
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
        driver.quit();
    }

    @Then("I should see an error message saying {string}")
    public void iShouldSeeAnErrorMessageSaying(String errorMessage) {
        assertTrue(loginPage.isErrorDisplayed());
        driver.quit();
    }
}
