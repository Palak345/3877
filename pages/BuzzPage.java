package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class BuzzPage {
    WebDriver driver;

    // Web elements for Buzz functionality
    @FindBy(id = "menu_buzz_viewBuzz")
    private WebElement buzzMenu;

    @FindBy(id = "createPostContent")
    private WebElement postContentField;

    @FindBy(id = "postSubmitBtn")
    private WebElement postSubmitButton;

    @FindBy(xpath = "//div[@class='postContent']")
    private List<WebElement> postContents;

    @FindBy(xpath = "//button[contains(@class, 'likeButton')]")
    private List<WebElement> likeButtons;

    @FindBy(xpath = "//div[contains(@class, 'likeCount')]")
    private List<WebElement> likeCounts;

    // Constructor for PageFactory initialization
    public BuzzPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to the Buzz section
    public void navigateToBuzzSection() {
        buzzMenu.click();
    }

    // Add a new Buzz post
    public void addBuzzPost(String content) {
        postContentField.sendKeys(content);
        postSubmitButton.click();
    }

    // Check if a post is added successfully
    public boolean isPostAdded(String content) {
        for (WebElement post : postContents) {
            if (post.getText().equals(content)) {
                return true;
            }
        }
        return false;
    }

    // Like the first post in the feed
    public void likeFirstPost() {
        if (!likeButtons.isEmpty()) {
            likeButtons.get(0).click();
        }
    }

    // Verify the like count has increased
    public boolean isLikeCountIncreased(int previousCount) {
        int currentCount = Integer.parseInt(likeCounts.get(0).getText());
        return currentCount > previousCount;
    }
}
