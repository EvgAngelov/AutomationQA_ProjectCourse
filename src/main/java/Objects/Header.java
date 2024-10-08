package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver webDriver;

//    @FindBy(id = "nav-link-login")
//    private WebElement newPost;

    public Header(WebDriver driver){
        this.webDriver = driver;
    }

    public void clickLogin(){
        WebElement loginLink = this.webDriver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    public void clickNewPost(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement clickNewPost = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.id("nav-link-new-post"))));
        clickNewPost.click();
    }

    public  void clickProfile(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement profilePageLink = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement
                (By.id("nav-link-profile"))));
        profilePageLink.click();
    }
}
