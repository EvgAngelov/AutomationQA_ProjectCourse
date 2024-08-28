import Factory.Header;
import Factory.SearchUser;
import Objects.HomePage;
import Objects.LoginPageO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FollowUserTest extends TestObject {
    @DataProvider(name="getUser")
    public Object[][] getUsers(){
        return new Object[][]{{"Shelby","Shelby"},};
    }

    @Test(dataProvider = "getUser")
    public void FollowUser(String username, String password) {
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPageO loginPage = new LoginPageO(webDriver);
        SearchUser searchUser = new SearchUser(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);

        loginPage.checkRememberMe();

        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember me checkbox is not checked.");

        loginPage.clickSignIn();

        searchUser.searchUserBar();
        searchUser.typeUserName("dianaaa");
        searchUser.waitForUserInDropdown();
        searchUser.clickOnUser();

        Assert.assertTrue(searchUser.isUrlLoaded(),"Current page in not profile page for 8721 user");

        searchUser.clickFollowButton();
    }
}

