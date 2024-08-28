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

public class LogOut {
    private final WebDriver webDriver;

    public LogOut(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg']")
    private WebElement exitButton;
    @FindBy(xpath = "//*[@id='toast-container']//*[@aria-label='Successful logout!']")
    private WebElement message;

    public void clickLogOut(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(exitButton));
        exitButton.click();
    }

    public String waitForMessage(){
        WebDriverWait waitForMessage = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        waitForMessage.until(ExpectedConditions.visibilityOf(message));
        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(message).perform();

        return message.getText();
    }
}
