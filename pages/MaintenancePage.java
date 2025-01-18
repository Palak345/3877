package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenancePage {
    WebDriver driver;

    // Web elements for Maintenance functionality
    @FindBy(id = "viewMaintenanceButton")
    private WebElement viewMaintenanceButton;

    @FindBy(id = "addMaintenanceButton")
    private WebElement addMaintenanceButton;

    @FindBy(id = "maintenanceType")
    private WebElement maintenanceTypeDropdown;

    @FindBy(id = "maintenanceDescription")
    private WebElement maintenanceDescriptionField;

    @FindBy(id = "saveMaintenance")
    private WebElement saveMaintenanceButton;

    @FindBy(xpath = "//div[contains(text(),'Record successfully added')]")
    private WebElement successMessage;

    @FindBy(xpath = "//table//tr[td[contains(text(),'System Check')]]")
    private WebElement maintenanceRecord;

    @FindBy(id = "deleteMaintenanceButton")
    private WebElement deleteMaintenanceButton;

    // Constructor for PageFactory initialization
    public MaintenancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to the Maintenance section
    public void navigateToMaintenanceSection() {
        viewMaintenanceButton.click();
    }

    // Add a maintenance record
    public void addMaintenanceRecord(String type, String description) {
        addMaintenanceButton.click();
        maintenanceTypeDropdown.sendKeys(type);
        maintenanceDescriptionField.sendKeys(description);
        saveMaintenanceButton.click();
    }

    // Verify success message
    public boolean isRecordAdded() {
        return successMessage.isDisplayed();
    }

    // Delete a maintenance record
    public void deleteMaintenanceRecord() {
        deleteMaintenanceButton.click();
    }

    // Check if a record is visible
    public boolean isRecordVisible(String type) {
        return maintenanceRecord.getText().contains(type);
    }
}
