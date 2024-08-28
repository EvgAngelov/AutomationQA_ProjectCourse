import Factory.DeletePost;
import Factory.Header;
import Factory.HomePage;
import Objects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeletePostTest extends TestObject {



    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{{"Shelby", "Shelby", "5465"},};
    }

    @Test(dataProvider = "getUser")
    public void deletePost(String username, String password, String userId) {
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPageO loginPage = new LoginPageO(webDriver);
        ProfilePageO profilePage = new ProfilePageO(webDriver);
        DeletePost deletePost = new DeletePost(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);

        loginPage.checkRememberMe();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");

        loginPage.clickSignIn();

        header.clickProfile();

        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");

        deletePost.selectPicture();

        deletePost.clickDelete();

        deletePost.clickYes();

        deletePost.WaitForMessage();

        String actualText = deletePost.WaitForMessage();
        String expectedText = "Post Deleted!";
        Assert.assertEquals(actualText, expectedText,"Expected text is not equals with actual text!");
    }
}