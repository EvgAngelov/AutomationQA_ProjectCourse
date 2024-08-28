package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UploadPagO {
    private final WebDriver webDriver;
    public UploadPagO(WebDriver driver){
        this.webDriver = driver;
    }

    public boolean isNewPostLoaded(){
        WebDriverWait waitTwo = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement displayedText = waitTwo.until(ExpectedConditions.visibilityOf(webDriver.findElement
                (By.xpath("/html/body/app-root/div[2]/app-create-post/div/div/div/form/h3"))));
        return displayedText.isDisplayed();
    }

    public void uploadPicture(File file){
        WebElement uploadFile = webDriver.findElement(By.xpath("//*[@class='form-group']/input[@type='file']"));

        //Path imagePath = Paths.get("src/test/resources/upload/1qwe.jpg");
        //String absolutePath = imagePath.toAbsolutePath().toString();
        //uploadFile.click();
        uploadFile.sendKeys(file.getAbsolutePath());
        //uploadFile.sendKeys(file.getAbsolutePath());
    }

    public boolean isImageLoaded(String fileName) {
        WebElement uploadPictureText = webDriver.findElement(By.xpath("//input[@class='form-control input-lg'][@type='text']"));
        String actualText = uploadPictureText.getAttribute("placeholder");
        if (actualText == fileName){
            return true;
        }
        return false;
    }
    public String uploadedImageText(){
        WebElement uploadPictureText = webDriver.findElement(By.xpath("//input[@class='form-control input-lg'][@type='text']"));
        return uploadPictureText.getAttribute("placeholder");
    }
    public void typePostCaption(String text){
        WebElement uploadPictureText = webDriver.findElement(By.name("caption"));
        uploadPictureText.sendKeys(text);
    }

    public void submitButton(){
        WebElement createPostButton = webDriver.findElement(By.id("create-post"));
        createPostButton.isEnabled();
        createPostButton.click();
    }
}
