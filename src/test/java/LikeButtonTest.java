import Objects.Header;
import Objects.HomePage;
import Objects.LoginPage;
import Objects.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.bouncycastle.cms.RecipientId.password;

public class LikeButtonTest extends Screenshot{

    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{{"Shelby","Shelby"},};
    }

    @Test (dataProvider = "getUser")
    public void LikeButton(String username, String password){
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);

        loginPage.checkRememberMe();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");

        loginPage.clickSignIn();

        WebDriverWait wait = new WebDriverWait(this.getWebDriver(), Duration.ofSeconds(15));
        WebElement likeButton = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//div[@class='post-info']/div/i[@class='far fa-heart fa-2x']"))));

        likeButton.click();

        WebDriverWait waitTwo = new WebDriverWait(this.getWebDriver(), Duration.ofSeconds(15));
        WebElement postLikeMessage = waitTwo.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//*[@id='toast-container']//*[@aria-label='Post liked']"))));

        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(postLikeMessage).perform();

        String expectedText = "Post liked";
        String actualText = postLikeMessage.getText();
        Assert.assertEquals(actualText,expectedText, "The actual text is not matching the expected text");
        }
}