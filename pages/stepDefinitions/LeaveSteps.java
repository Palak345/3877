package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pages.LeavePage;

import static org.junit.Assert.assertTrue;

public class LeaveSteps {
    WebDriver driver;
    LeavePage leavePage;

    @When("I navigate to {string}")
    public void iNavigateTo(String page) {
        leavePage = new LeavePage(driver);
        leavePage.navigateToAssignLeave();
    }

    @When("I assign leave to {string} with type {string} from {string} to {string}")
    public void iAssignLeaveToWithTypeFromTo(String empName, String leaveType, String fromDate, String toDate) {
        leavePage.assignLeave(empName, leaveType, fromDate, toDate);
    }

    @Then("I should see a success message confirming the leave was assigned")
    public void iShouldSeeASuccessMessageConfirmingTheLeaveWasAssigned() {
        assertTrue(leavePage.isLeaveAssigned());
        driver.quit();
    }
}
