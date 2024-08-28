import Factory.UploadPage;
import Objects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class UploadPostTest extends TestObject {
    @DataProvider(name="getUser")
    public Object[][] getUsers(){
            File postPicture = new File("src\\test\\resources\\upload\\1qwe.jpg");
                    String caption = "Testing upload file";
        return new Object[][]{
            {"Shelby", "Shelby", "5465", postPicture, caption}
        };
    }

    @Test(dataProvider = "getUser")
    public void testCreatePost(String username, String password, String userId, File postPicture, String picture) {
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPageO loginPage = new LoginPageO(webDriver);
        ProfilePageO profilePage = new ProfilePageO(webDriver);
        UploadPage uploadPage = new UploadPage(webDriver);

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

        header.clickNewPost();
        Assert.assertTrue(uploadPage.isNewPostLoaded(),"The new post form not loaded");

        uploadPage.uploadPicture(postPicture);

        //String actualText = uploadPage.isImageLoaded("1qwe.jpg");
        Assert.assertTrue(uploadPage.isImageLoaded("1qwe.jpg"), "Image is not uploaded");
        Assert.assertEquals(uploadPage.uploadedImageText(), "1qwe.jpg", "Image is not uploaded");

        uploadPage.submitButton();

    }
}
