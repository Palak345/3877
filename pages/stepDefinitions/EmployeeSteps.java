package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pages.EmployeePage;

import static org.junit.Assert.assertTrue;

public class EmployeeSteps {
    WebDriver driver;
    EmployeePage employeePage;

    @When("I navigate to {string}")
    public void iNavigateTo(String page) {
        employeePage = new EmployeePage(driver);
        employeePage.navigateToAddEmployee();
    }

    @When("I add an employee with first name {string}, last name {string}, and employee ID {string}")
    public void iAddAnEmployeeWithFirstNameLastNameAndEmployeeID(String fname, String lname, String empId) {
        employeePage.addEmployee(fname, lname, empId);
    }

    @Then("I should see the personal details page of the added employee")
    public void iShouldSeeThePersonalDetailsPageOfTheAddedEmployee() {
        assertTrue(employeePage.isEmployeeAdded());
        driver.quit();
    }
}
