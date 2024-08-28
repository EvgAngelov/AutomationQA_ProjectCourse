package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Header {

    private final WebDriver webDriver;

    public Header (WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(id = "nav-link-login")
    private WebElement loginLink;
    @FindBy(id = "nav-link-new-post")
    private WebElement clickNewPost;
    @FindBy(id = "nav-link-profile")
    private WebElement profilePageLink;


    public void clickLogin(){
        loginLink.click();
    }

    public void clickNewPost(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(clickNewPost));
        clickNewPost.click();
    }

    public  void clickProfile(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(profilePageLink));
        profilePageLink.click();
    }
}
