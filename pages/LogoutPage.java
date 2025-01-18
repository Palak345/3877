package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "loginPage")
    private WebElement loginPage;

    // Constructor for PageFactory initialization
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click on the logout button
    public void clickLogoutButton() {
        logoutButton.click();
    }

    // Method to check if user is redirected to the login page
    public boolean isOnLoginPage() {
        return loginPage.isDisplayed();
    }
}
