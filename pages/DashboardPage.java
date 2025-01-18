package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath = "//h6[contains(text(),'Dashboard')]")
    private WebElement dashboardHeader;

    @FindBy(css = "a[href='/web/index.php/admin/viewAdminModule']")
    private WebElement adminModule;

    @FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
    private WebElement pimModule;

    @FindBy(css = "a[href='/web/index.php/leave/viewLeaveModule']")
    private WebElement leaveModule;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardVisible() {
        return dashboardHeader.isDisplayed();
    }

    public void navigateToAdminModule() {
        adminModule.click();
    }

    public void navigateToPimModule() {
        pimModule.click();
    }

    public void navigateToLeaveModule() {
        leaveModule.click();
    }
}
