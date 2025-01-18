package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimPage {
    WebDriver driver;

    // WebElement for viewing claims
    @FindBy(id = "viewClaimsButton")
    private WebElement viewClaimsButton;

    // WebElement for submitting a new claim
    @FindBy(id = "submitClaimButton")
    private WebElement submitClaimButton;

    // WebElement for selecting claim type
    @FindBy(id = "claimType")
    private WebElement claimTypeDropdown;

    // WebElement for entering claim amount
    @FindBy(id = "claimAmount")
    private WebElement claimAmountField;

    // WebElement for saving claim
    @FindBy(id = "saveClaim")
    private WebElement saveClaimButton;

    // Success message after submission
    @FindBy(xpath = "//div[contains(text(),'Claim successfully submitted')]")
    private WebElement successMessage;

    // WebElement for specific claim record
    @FindBy(xpath = "//table//tr[td[contains(text(),'Medical')]]")
    private WebElement claimRecord;

    // WebElement for deleting claim
    @FindBy(id = "deleteClaim")
    private WebElement deleteClaimButton;

    // Constructor initializes the PageFactory elements
    public ClaimPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to the Claims section
    public void navigateToClaimsSection() {
        viewClaimsButton.click();
    }

    // Method to submit a claim
    public void submitClaim(String type, String amount) {
        claimTypeDropdown.sendKeys(type);
        claimAmountField.sendKeys(amount);
        saveClaimButton.click();
    }

    // Method to verify if the claim is submitted
    public boolean isClaimSubmitted() {
        return successMessage.isDisplayed();
    }

    // Method to delete a claim
    public void deleteClaim() {
        deleteClaimButton.click();
    }

    // Method to check if a specific claim is visible
    public boolean isClaimVisible(String type) {
        return claimRecord.getText().contains(type);
    }
}
