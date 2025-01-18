package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportToPage {
    WebDriver driver;

    // Locators for Report-to page
    @FindBy(xpath = "//a[contains(@href, 'viewReportToDetails')]")
    private WebElement reportToTab;

    @FindBy(xpath = "//h6[text()='Assigned Subordinates']")
    private WebElement assignedSubordinatesSection;

    @FindBy(xpath = "//a[text()='Add']")
    private WebElement addSubordinateButton;

    @FindBy(name = "subordinate[empName]")
    private WebElement subordinateNameField;

    @FindBy(name = "subordinate[reportingMethod]")
    private WebElement reportingMethodDropdown;

    @FindBy(css = "input[id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//table[@id='subordinateList']//td[contains(text(),'Sara Tencrady')]")
    private WebElement subordinateRecord;

    @FindBy(css = "input[id='ohrmList_chkSelectRecord_1']")
    private WebElement subordinateCheckbox;

    @FindBy(css = "input[id='btnDelete']")
    private WebElement deleteSubordinateButton;

    @FindBy(xpath = "//div[contains(text(),'Successfully Deleted')]")
    private WebElement deleteSuccessMessage;

    @FindBy(xpath = "//h6[text()='Attachments']")
    private WebElement attachmentsSection;

    @FindBy(css = "input[type='file']")
    private WebElement fileUploadInput;

    @FindBy(css = "input[id='btnAddAttachment']")
    private WebElement addAttachmentButton;

    @FindBy(xpath = "//table[@id='tblAttachments']//td[contains(text(),'No Records Found')]")
    private WebElement noAttachmentsFoundMessage;

    // Constructor for initializing elements
    public ReportToPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to Report-to section
    public void navigateToReportToTab() {
        reportToTab.click();
    }

    // Method to verify the assigned subordinates section is visible
    public boolean isAssignedSubordinatesSectionVisible() {
        return assignedSubordinatesSection.isDisplayed();
    }

    // Method to add a subordinate
    public void addSubordinate(String empName, String reportingMethod) {
        addSubordinateButton.click();
        subordinateNameField.sendKeys(empName);
        reportingMethodDropdown.sendKeys(reportingMethod); // Simulate dropdown selection
        saveButton.click();
    }

    // Method to check if a subordinate record exists
    public boolean isSubordinateRecordVisible(String subordinateName) {
        return subordinateRecord.isDisplayed();
    }

    // Method to delete a subordinate
    public void deleteSubordinate() {
        subordinateCheckbox.click();
        deleteSubordinateButton.click();
    }

    // Method to verify successful deletion
    public boolean isSubordinateDeletedSuccessfully() {
        return deleteSuccessMessage.isDisplayed();
    }

    // Method to check if the attachments section is visible
    public boolean isAttachmentsSectionVisible() {
        return attachmentsSection.isDisplayed();
    }

    // Method to upload an attachment
    public void uploadAttachment(String filePath) {
        fileUploadInput.sendKeys(filePath); // Provide the full path of the file
        addAttachmentButton.click();
    }

    // Method to verify no attachments message
    public boolean isNoAttachmentsMessageVisible() {
        return noAttachmentsFoundMessage.isDisplayed();
    }
}
