import Objects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogOutTest extends TestObject {

    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{{"Shelby", "Shelby", "5465"},};
    }

    @Test(dataProvider = "getUser")
    public void exitTest(String username, String password, String userId) {
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPageO loginPage = new LoginPageO(webDriver);
        ProfilePageO profilePage = new ProfilePageO(webDriver);
        LogOutPageО logOutPage = new LogOutPageО(webDriver);

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

        logOutPage.clickLogOut();

        logOutPage.waitForMessage();

        String actualText = logOutPage.waitForMessage();
        String expectedText = "Successful logout!";
        Assert.assertEquals(actualText, expectedText,"Expected text is not equals with actual text!");
    }
}
