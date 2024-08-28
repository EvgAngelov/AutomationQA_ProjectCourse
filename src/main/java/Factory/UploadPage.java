package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UploadPage {
        private final WebDriver webDriver;

//        public UploadPagO(WebDriver driver){
//            this.webDriver = driver;
//        }

        @FindBy(xpath = "//*[@class='form-group']/input[@type='file']")
        private WebElement uploadImageText;
        @FindBy(name = "caption")
        private WebElement postCaption;
        @FindBy(xpath = "//input[@class='form-control input-lg'][@type='text']")
        private WebElement actualText;
        @FindBy(xpath = "/html/body/app-root/div[2]/app-create-post/div/div/div/form/h3")
        private WebElement displayedText;
        @FindBy(xpath = "//*[@class='form-group']/input[@type='file']")
        private WebElement uploadFile;
        @FindBy(name = "create-post")
        private WebElement createPostButton;

        public UploadPage(WebDriver driver){
            this.webDriver = driver;
            PageFactory.initElements(webDriver,this);
        }

        public boolean isNewPostLoaded(){
//            WebDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
//            WebElement displayedText = waitTwo.until(ExpectedConditions.visibilityOf(webDriver.findElement
//                    (By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/h3"))));
            return displayedText.isDisplayed();
        }

        public void uploadPicture(File file){
            //WebElement uploadFile = webDriver.findElement(By.xpath("//*[@class='form-group']/input[@type='file']"));
            uploadFile.sendKeys(file.getAbsolutePath());
        }

        public boolean isImageLoaded(String fileName) {
            String actualText = uploadImageText.getAttribute("placeholder");
            if (actualText == fileName){
                return true;
            }
            return false;
        }
        public String uploadedImageText(){
            return uploadImageText.getAttribute("placeholder");
        }
        public void typePostCaption(String text){
            uploadImageText.sendKeys(text);
        }

        public void submitButton(){
            //WebElement createPostButton = webDriver.findElement(By.id("create-post"));
            createPostButton.isEnabled();
            createPostButton.click();
        }
}

