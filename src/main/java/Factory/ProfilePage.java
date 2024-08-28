package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static Objects.HomePage.HOME_URL;

public class ProfilePage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/";
    private final WebDriver webDriver;
    public ProfilePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//*[@alt='Profile Picture']")
    private WebElement buttonUplProfilePic;

    public void navigateTo(){
        this.webDriver.get(HOME_URL);
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlContains(PAGE_URL));
    }
    public boolean isUrlLoaded(String userId){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL+userId));
    }

//    public void clickButtonEditProfilePic(){
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.visibilityOf(buttonUplProfilePic));
//        buttonUplProfilePic.click();
//    }

    public void uploadProfilePicture(File file){
        buttonUplProfilePic.sendKeys(file.getAbsolutePath());
    }
}
