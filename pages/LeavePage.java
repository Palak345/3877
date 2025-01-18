package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {
    WebDriver driver;

    @FindBy(css = "a[href='/web/index.php/leave/assignLeave']")
    private WebElement assignLeaveMenu;

    @FindBy(name = "assignleave[txtEmployee][empName]")
    private WebElement employeeName;

    @FindBy(name = "assignleave[txtLeaveType]")
    private WebElement leaveType;

    @FindBy(name = "assignleave[txtFromDate]")
    private WebElement fromDate;

    @FindBy(name = "assignleave[txtToDate]")
    private WebElement toDate;

    @FindBy(css = "input[id='assignBtn']")
    private WebElement assignButton;

    @FindBy(xpath = "//div[contains(text(),'Successfully Assigned')]")
    private WebElement successMessage;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToAssignLeave() {
        assignLeaveMenu.click();
    }

    public void assignLeave(String empName, String leave, String from, String to) {
        employeeName.sendKeys(empName);
        leaveType.sendKeys(leave);
        fromDate.sendKeys(from);
        toDate.sendKeys(to);
        assignButton.click();
    }

    public boolean isLeaveAssigned() {
        return successMessage.isDisplayed();
    }
}
