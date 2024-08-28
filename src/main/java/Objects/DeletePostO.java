package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeletePostO {
    private final WebDriver webDriver;
    public DeletePostO(WebDriver driver){
        this.webDriver = driver;
    }

    public void selectPicture(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement clickOnPicture = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//*[@class='post-img']//img"))));
        clickOnPicture.click();
    }

    public void clickDelete(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement clickDeleteButton = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//*[@class='ng-star-inserted']//*[@class='delete-ask']"))));
        clickDeleteButton.click();
    }

    public void clickYes(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement clickYesButton = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//button[contains(., 'Yes')]"))));
        clickYesButton.click();
    }

    public String WaitForMessage(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement message = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("//*[@id='toast-container']//*[@aria-label='Post Deleted!']"))));

        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(message).perform();

        return message.getText();
    }
}
