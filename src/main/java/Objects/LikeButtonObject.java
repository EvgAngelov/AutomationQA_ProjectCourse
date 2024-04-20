package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LikeButtonObject {
    private final WebDriver webDriver;
    public LikeButtonObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickLikeButton(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement likeButtonClick = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//div[@class='post-info']/div/i[@class='far fa-heart fa-2x']"))));
        likeButtonClick.click();
    }

    public String waitForMessage(){
        WebDriverWait waitTwo = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement message = waitTwo.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//*[@id='toast-container']//*[@aria-label='Post liked']"))));

        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(message).perform();

        return message.getText();
    }
}
