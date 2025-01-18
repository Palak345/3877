package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
    WebDriver driver;

    // Locators for User Management Page elements
    @FindBy(css = "a[href='/web/index.php/admin/saveSystemUser']")
    private WebElement addUserMenu;

    @FindBy(name = "systemUser[employeeName][empName]")
    private WebElement employeeName;

    @FindBy(name = "systemUser[userName]")
    private WebElement userName;

    @FindBy(name = "systemUser[password]")
    private WebElement password;

    @FindBy(name = "systemUser[confirmPassword]")
    private WebElement confirmPassword;

    @FindBy(css = "input[id='btnSave']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    private WebElement successMessage;

    // Constructor for initializing elements
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to the "Add User" menu
    public void navigateToAddUserMenu() {
        addUserMenu.click();
    }

    // Method to fill in employee name
    public void enterEmployeeName(String empName) {
        employeeName.sendKeys(empName);
    }

    // Method to fill in username
    public void enterUserName(String user) {
        userName.sendKeys(user);
    }

    // Method to fill in password
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    // Method to fill in confirm password
    public void enterConfirmPassword(String confirmPass) {
        confirmPassword.sendKeys(confirmPass);
    }

    // Method to click the "Save" button
    public void clickSaveButton() {
        saveButton.click();
    }

    // Method to check if the success message is displayed
    public boolean isUserSuccessfullySaved() {
        return successMessage.isDisplayed();
    }

    // Comprehensive method to add a new user
    public void addNewUser(String empName, String user, String pass, String confirmPass) {
        navigateToAddUserMenu();
        enterEmployeeName(empName);
        enterUserName(user);
        enterPassword(pass);
        enterConfirmPassword(confirmPass);
        clickSaveButton();
    }
}
