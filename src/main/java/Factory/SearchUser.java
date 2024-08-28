package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchUser {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/8721";
    private final WebDriver webDriver;

    public SearchUser(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(id = "search-bar")
    WebElement searchField;
    @FindBy(xpath = "//*[@href='/users/8721']")
    WebElement searchResults;
    @FindBy(xpath = "//button[@class='btn btn-primary profile-edit-btn ng-star-inserted']")
    private WebElement buttonFollow;


    public void searchUserBar(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(searchField)).click();
    }

    public void typeUserName(String username){
        searchField.sendKeys(username);
    }

    public void waitForUserInDropdown(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
    }

    public void clickOnUser(){
        searchResults.click();
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void clickFollowButton(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(buttonFollow));
    }
}
