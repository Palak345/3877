package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {
    WebDriver driver;

    // Web elements for interacting with the personal details page
    @FindBy(name = "personal[txtEmpFirstName]")
    private WebElement firstNameField;

    @FindBy(name = "personal[txtEmpLastName]")
    private WebElement lastNameField;

    @FindBy(name = "personal[txtEmployeeId]")
    private WebElement employeeIdField;

    @FindBy(css = "input[id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    private WebElement successMessage;

    // Constructor for PageFactory initialization
    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to enter first name
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    // Method to enter last name
    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    // Method to enter employee ID
    public void enterEmployeeId(String employeeId) {
        employeeIdField.sendKeys(employeeId);
    }

    // Method to click on save button
    public void clickSaveButton() {
        saveButton.click();
    }

    // Method to check if the success message is displayed
    public boolean isPersonalDetailsUpdated() {
        return successMessage.isDisplayed();
    }

    // Method to update personal details
    public void updatePersonalDetails(String firstName, String lastName, String employeeId) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmployeeId(employeeId);
        clickSaveButton();
    }
}
