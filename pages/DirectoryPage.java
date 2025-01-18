package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DirectoryPage {
    WebDriver driver;

    // Web elements for Directory functionality
    @FindBy(id = "searchDirectory")
    private WebElement searchDirectoryButton;

    @FindBy(id = "employeeNameField")
    private WebElement employeeNameField;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(text(),'No Records Found')]")
    private WebElement noRecordsFoundMessage;

    @FindBy(xpath = "//table//tr[td[contains(text(),'John Doe')]]")
    private WebElement employeeRecord;

    // Constructor for PageFactory initialization
    public DirectoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to Directory section
    public void navigateToDirectorySection() {
        searchDirectoryButton.click();
    }

    // Search for an employee
    public void searchForEmployee(String name) {
        employeeNameField.sendKeys(name);
        searchButton.click();
    }

    // Check if employee record is visible
    public boolean isEmployeeVisible(String name) {
        return employeeRecord.getText().contains(name);
    }

    // Check if no records are found
    public boolean isNoRecordsFound() {
        return noRecordsFoundMessage.isDisplayed();
    }
}
