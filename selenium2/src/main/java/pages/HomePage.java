package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private final WebDriver driver;

    // Locators
    @FindBy(linkText = "Form Authentication")
    private By formAuth;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickFormAuth() {
        driver.findElement(formAuth).click();
    }
}