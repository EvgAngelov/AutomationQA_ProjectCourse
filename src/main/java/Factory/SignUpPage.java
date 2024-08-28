package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class SignUpPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver webDriver;

    public SignUpPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);
    }
    //public static String usernameTextField;
    //public Label errorMessage;

    @FindBy(xpath = "/html/body/app-root/div[2]/app-login/div/div/form/p[2]/a")
    private WebElement registerButton;
    @FindBy(xpath = "/html/body/app-root/div[2]/app-register/div/div/form/div[1]/input")
    private WebElement usernameTextField;
    @FindBy(xpath = "/html/body/app-root/div[2]/app-register/div/div/form/div[2]/input")
    private WebElement emailTextField;
    @FindBy(id = "defaultRegisterFormPassword")
    private WebElement passwordTextField;
    @FindBy(id = "defaultRegisterPhonePassword")
    private WebElement confirmPassTextField;
    @FindBy(id = "sign-in-button")
    private WebElement signUpButton;
    @FindBy(xpath = "//*[@id='toast-container']//*[@aria-label='Username taken']")
    private WebElement errorMessage;


    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void clickButton(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }

    public void fillInUserName(String username){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(usernameTextField));
        usernameTextField.sendKeys(username);
    }

    public void fillInEmail(String email){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emailTextField));
        emailTextField.sendKeys(email);
    }

    public void fillInPassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        passwordTextField.sendKeys(password);
    }

    public void fillInConfirmPassword(String confirmPassword){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(confirmPassTextField));
        confirmPassTextField.sendKeys(confirmPassword);
    }

    public void clickSignUp(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
    }

    public String waitForErrorMessage(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));

        Actions actionsForElements = new Actions(webDriver);
        actionsForElements.moveToElement(errorMessage).perform();

        return errorMessage.getText();
    }
}
