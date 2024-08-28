import Factory.SignUpPage;
import Objects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest extends TestObject {

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"Shelby", "Shelby@gmail.com", "Shelby", "Shelby"},};
    }

    @Test(dataProvider = "getUser")
    public void signUpTest(String username, String email, String password, String confirmPassword){

        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPageO loginPage = new LoginPageO(webDriver);
        SignUpPage signUpPage = new SignUpPage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        signUpPage.clickButton();

        signUpPage.fillInUserName(username);

        signUpPage.fillInEmail(email);
        signUpPage.fillInPassword(password);
        signUpPage.fillInConfirmPassword(confirmPassword);

        signUpPage.clickSignUp();

        signUpPage.waitForErrorMessage();

        String actualText = signUpPage.waitForErrorMessage();
        String expectedText = "Username taken";
        Assert.assertEquals(actualText, expectedText,"Expected text is not equals with actual text!");
    }
}


