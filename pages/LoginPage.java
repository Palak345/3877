package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "[type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(),'Invalid credentials')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String uname, String pass) {
        username.sendKeys(uname);
        password.sendKeys(pass);
        loginButton.click();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
}
