package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;

    private By choseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public FileUploadPage uploadFile(String absoluteFilePath)
    {
        driver.findElement(choseFileButton).sendKeys(absoluteFilePath);
        return this;
    }

    public FileUploadPage clickUploadButton()
    {
        driver.findElement(uploadButton).click();
        return this;
    }

    public String getUploadedFileName()
    {
        return driver.findElement(uploadedFile).getText();
    }
}