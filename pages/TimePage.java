package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimePage {
    WebDriver driver;

    // Web elements for Time functionality
    @FindBy(id = "menu_time_viewTimeModule")
    private WebElement timeMenu;

    @FindBy(id = "menu_time_viewMyTimesheet")
    private WebElement viewTimesheetButton;

    @FindBy(id = "btnAddTimesheet")
    private WebElement addTimesheetButton;

    @FindBy(id = "projectName")
    private WebElement projectNameField;

    @FindBy(id = "activityName")
    private WebElement activityDropdown;

    @FindBy(id = "timesheet_hours")
    private WebElement hoursField;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    private WebElement successMessage;

    @FindBy(xpath = "//table//tr[td[contains(text(),'Project X')]]")
    private WebElement timeEntryRecord;

    @FindBy(id = "deleteTimeEntryButton")
    private WebElement deleteTimeEntryButton;

    // Constructor for PageFactory initialization
    public TimePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to the Time section
    public void navigateToTimeSection() {
        timeMenu.click();
    }

    // View timesheets
    public void viewTimesheets() {
        viewTimesheetButton.click();
    }

    // Add a new time entry
    public void addTimeEntry(String project, String activity, String hours) {
        addTimesheetButton.click();
        projectNameField.sendKeys(project);
        activityDropdown.sendKeys(activity);
        hoursField.sendKeys(hours);
        saveButton.click();
    }

    // Check if a time entry is successfully added
    public boolean isTimeEntryAdded() {
        return successMessage.isDisplayed();
    }

    // Delete a time entry
    public void deleteTimeEntry() {
        deleteTimeEntryButton.click();
    }

    // Verify if a time entry is listed
    public boolean isTimeEntryVisible(String project) {
        return timeEntryRecord.getText().contains(project);
    }
}
