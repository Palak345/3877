package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
    WebDriver driver;

    @FindBy(css = "a[href='/web/index.php/pim/addEmployee']")
    private WebElement addEmployeeMenu;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "employeeId")
    private WebElement employeeId;

    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//h6[contains(text(),'Personal Details')]")
    private WebElement personalDetailsHeader;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToAddEmployee() {
        addEmployeeMenu.click();
    }

    public void addEmployee(String fname, String lname, String empId) {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        employeeId.clear();
        employeeId.sendKeys(empId);
        saveButton.click();
    }

    public boolean isEmployeeAdded() {
        return personalDetailsHeader.isDisplayed();
    }
}
