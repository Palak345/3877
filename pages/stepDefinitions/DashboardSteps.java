package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

import static org.junit.Assert.assertTrue;

public class DashboardSteps {
    WebDriver driver;
    DashboardPage dashboardPage;

    @When("I click on the Admin Module")
    public void iClickOnTheAdminModule() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToAdminModule();
    }

    @When("I click on the PIM Module")
    public void iClickOnThePIMModule() {
        dashboardPage.navigateToPimModule();
    }

    @When("I click on the Leave Module")
    public void iClickOnTheLeaveModule() {
        dashboardPage.navigateToLeaveModule();
    }

    @Then("I should be on the Admin page")
    public void iShouldBeOnTheAdminPage() {
        assertTrue(driver.getCurrentUrl().contains("admin"));
        driver.quit();
    }

    @Then("I should be on the Employee List page")
    public void iShouldBeOnTheEmployeeListPage() {
        assertTrue(driver.getCurrentUrl().contains("pim"));
        driver.quit();
    }

    @Then("I should be on the Leave page")
    public void iShouldBeOnTheLeavePage() {
        assertTrue(driver.getCurrentUrl().contains("leave"));
        driver.quit();
    }
}
