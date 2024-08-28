package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DeletePost {
    private final WebDriver webDriver;

    public DeletePost(WebDriver driver){

        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//*[@class='post-img']//img")
    private WebElement clickOnPicture;
    @FindBy(xpath = "//*[@class='ng-star-inserted']//*[@class='delete-ask']")
    private WebElement clickDeleteButton;
    @FindBy(xpath = "//button[contains(., 'Yes')]")
    private WebElement clickYesButton;
    @FindBy(xpath = "//*[@id='toast-container']//*[@aria-label='Post Deleted!']")
    private WebElement message;

    public void selectPicture(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(clickOnPicture));
        clickOnPicture.click();
    }

    public void clickDelete(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(clickDeleteButton));
        clickDeleteButton.click();
    }

    public void clickYes(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(clickYesButton));
        clickYesButton.click();
    }

    public String WaitForMessage(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(message));

        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(message).perform();

        return message.getText();
    }
}
