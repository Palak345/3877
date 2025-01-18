package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PerformancePage {
    WebDriver driver;

    // Web elements for Performance functionality
    @FindBy(id = "menu__Performance")
    private WebElement performanceMenu;

    @FindBy(id = "btnAdd")
    private WebElement addReviewButton;

    @FindBy(name = "performanceReview[employeeName][empName]")
    private WebElement employeeNameField;

    @FindBy(name = "performanceReview[reviewPeriod][from]")
    private WebElement reviewPeriodFromField;

    @FindBy(name = "performanceReview[reviewPeriod][to]")
    private WebElement reviewPeriodToField;

    @FindBy(name = "performanceReview[comments]")
    private WebElement commentsField;

    @FindBy(id = "saveBtn")
    private WebElement saveButton;

    @FindBy(xpath = "//table[@id='resultTable']//tbody//tr")
    private List<WebElement> performanceRecords;

    @FindBy(name = "performanceSearch[employeeName][empName]")
    private WebElement searchEmployeeNameField;

    @FindBy(id = "searchBtn")
    private WebElement searchButton;

    @FindBy(xpath = "//table[@id='resultTable']//tbody//tr/td[2]")
    private List<WebElement> searchResults;

    // Constructor for PageFactory initialization
    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to the Performance section
    public void navigateToPerformanceSection() {
        performanceMenu.click();
    }

    // Add a new Performance review
    public void addPerformanceReview(String employeeName, String fromDate, String toDate, String comments) {
        addReviewButton.click();
        employeeNameField.sendKeys(employeeName);
        reviewPeriodFromField.sendKeys(fromDate);
        reviewPeriodToField.sendKeys(toDate);
        commentsField.sendKeys(comments);
        saveButton.click();
    }

    // Check if performance reviews are displayed
    public boolean arePerformanceReviewsDisplayed() {
        return performanceRecords.size() > 0;
    }

    // Search for Performance records
    public void searchPerformanceRecords(String employeeName) {
        searchEmployeeNameField.sendKeys(employeeName);
        searchButton.click();
    }

    // Verify search results
    public boolean isSearchResultDisplayed(String employeeName) {
        for (WebElement result : searchResults) {
            if (result.getText().equals(employeeName)) {
                return true;
            }
        }
        return false;
    }
}
