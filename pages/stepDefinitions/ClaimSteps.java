package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClaimPage;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ClaimSteps {
    WebDriver driver;
    ClaimPage claimPage;

    @Given("User navigates to the {string} section")
    public void userNavigatesToSection(String section) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/claims/viewClaims");
        claimPage = new ClaimPage(driver);
        if (section.equalsIgnoreCase("Claims")) {
            claimPage.navigateToClaimsSection();
        }
    }

    @Then("The {string} page should be displayed")
    public void thePageShouldBeDisplayed(String pageName) {
        Assert.assertTrue(claimPage.isClaimSubmitted());
    }

    @When("User submits a claim with type {string} and amount {string}")
    public void userSubmitsClaim(String type, String amount) {
        claimPage.submitClaim(type, amount);
    }

    @Then("The claim should be successfully submitted")
    public void theClaimShouldBeSuccessfullySubmitted() {
        Assert.assertTrue(claimPage.isClaimSubmitted());
    }

    @When("User deletes a claim with type {string}")
    public void userDeletesClaim(String type) {
        claimPage.deleteClaim();
    }

    @Then("The claim should no longer be listed")
    public void theClaimShouldNoLongerBeListed() {
        Assert.assertFalse(claimPage.isClaimVisible("Medical"));
    }
}
