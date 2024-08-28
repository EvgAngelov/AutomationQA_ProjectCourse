import Factory.Header;
import Factory.LikeButton;
import Objects.HomePage;
import Objects.LoginPageO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LikeButtonTest extends TestObject {

    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{{"Shelby","Shelby"},};
    }

    @Test (dataProvider = "getUser")
    public void LikeButton(String username, String password){
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPageO loginPage = new LoginPageO(webDriver);
        LikeButton likeButton = new LikeButton(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);

        loginPage.checkRememberMe();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");

        loginPage.clickSignIn();

        likeButton.clickLikeButton();

        likeButton.waitForMessage();

        String actualText = likeButton.waitForMessage();
        String expectedText = "Post liked";
        Assert.assertEquals(actualText,expectedText, "The actual text is not matching the expected text");
        }
}