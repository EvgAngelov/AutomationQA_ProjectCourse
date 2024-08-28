package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutPageО {
    private final WebDriver webDriver;
    public LogOutPageО(WebDriver driver){
        this.webDriver = driver;
    }

    public void clickLogOut(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement exitButton = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg']"))));
        exitButton.click();
    }

    public String waitForMessage(){
        WebDriverWait waitForMessage = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement message = waitForMessage.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//*[@id='toast-container']//*[@aria-label='Successful logout!']"))));
        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(message).perform();

        return message.getText();
    }
}
