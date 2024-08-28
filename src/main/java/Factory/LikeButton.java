package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LikeButton {

    private final WebDriver webDriver;

    public LikeButton(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//img[@src='https://i.imgur.com/xRMqVL6.jpeg']/ancestor::div" +
            "[@class='post-feed-img']/following-sibling::div//i[contains(@class, 'fa-heart')]")
    private WebElement likeButtonClick;
    @FindBy(xpath = "//*[@id='toast-container']//*[@aria-label='Post liked']")
    private WebElement message;

    public void clickLikeButton(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(likeButtonClick));
        likeButtonClick.click();
    }

    public String waitForMessage(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(message));

        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(message).perform();

        return message.getText();
    }
}
