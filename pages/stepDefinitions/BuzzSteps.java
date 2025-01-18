package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BuzzPage;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class BuzzSteps {
    WebDriver driver;
    BuzzPage buzzPage;
    int previousLikeCount;

    @Given("User navigates to the {string} section")
    public void userNavigatesToSection(String section) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");
        buzzPage = new BuzzPage(driver);
        if (section.equalsIgnoreCase("Buzz")) {
            buzzPage.navigateToBuzzSection();
        }
    }

    @Then("The {string} page should display a list of posts")
    public void thePageShouldDisplayPosts(String pageName) {
        Assert.assertTrue(driver.getTitle().contains(pageName));
        Assert.assertTrue(buzzPage.postContents.size() > 0);
    }

    @When("User adds a new Buzz post with content {string}")
    public void userAddsNewBuzzPost(String content) {
        buzzPage.addBuzzPost(content);
    }

    @Then("The post should be successfully added to the Buzz feed")
    public void thePostShouldBeSuccessfullyAdded(String content) {
        Assert.assertTrue(buzzPage.isPostAdded(content));
    }

    @When("User likes the first post in the Buzz feed")
    public void userLikesFirstPost() {
        previousLikeCount = Integer.parseInt(buzzPage.likeCounts.get(0).getText());
        buzzPage.likeFirstPost();
    }

    @Then("The like count for the post should increase")
    public void theLikeCountShouldIncrease() {
        Assert.assertTrue(buzzPage.isLikeCountIncreased(previousLikeCount));
    }
}
