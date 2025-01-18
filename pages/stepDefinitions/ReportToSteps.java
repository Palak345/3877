package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pages.ReportToPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ReportToSteps {

    WebDriver driver;
    ReportToPage reportToPage;

    @Given("User navigates to the {string} section")
    public void userNavigatesToSection(String section) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewReportToDetails/empNumber/7");
        reportToPage = new ReportToPage(driver);
        if (section.equalsIgnoreCase("Report-to")) {
            reportToPage.navigateToReportToTab();
        }
    }

    @Then("The {string} section should be displayed")
    public void theSectionShouldBeDisplayed(String sectionName) {
        if (sectionName.equalsIgnoreCase("Assigned Subordinates")) {
            Assert.assertTrue(reportToPage.isAssignedSubordinatesSectionVisible());
        } else if (sectionName.equalsIgnoreCase("Attachments")) {
            Assert.assertTrue(reportToPage.isAttachmentsSectionVisible());
        }
    }

    @When("User adds a subordinate with name {string} and reporting method {string}")
    public void userAddsASubordinate(String subordinateName, String reportingMethod) {
        reportToPage.addSubordinate(subordinateName, reportingMethod);
    }

    @Then("The subordinate {string} should be displayed in the list")
    public void theSubordinateShouldBeDisplayed(String subordinateName) {
        Assert.assertTrue(reportToPage.isSubordinateRecordVisible(subordinateName));
    }

    @When("User deletes the subordinate {string}")
    public void userDeletesTheSubordinate(String subordinateName) {
        reportToPage.deleteSubordinate();
    }

    @Then("The subordinate {string} should not be displayed in the list")
    public void theSubordinateShouldNotBeDisplayed(String subordinateName) {
        Assert.assertFalse(reportToPage.isSubordinateRecordVisible(subordinateName));
    }

    @When("User uploads an attachment with the file path {string}")
    public void userUploadsAnAttachment(String filePath) {
        reportToPage.uploadAttachment(filePath);
    }

    @Then("The attachment should be successfully uploaded")
    public void theAttachmentShouldBeSuccessfullyUploaded() {
        // Add a verification step for uploaded attachment
    }

    @Then("The message {string} should be displayed if no attachments exist")
    public void theMessageShouldBeDisplayedIfNoAttachmentsExist(String expectedMessage) {
        Assert.assertTrue(reportToPage.isNoAttachmentsMessageVisible());
    }
}
