package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    @FindBy(linkText = "Form Authentication")
    private WebDriver formAuthLink;

    // Constructor
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Methods
    public void clickFormAuth() {
        clickLink("Form Authentication");
    }

    public void clickDropdown() {
        clickLink("Dropdown");
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickHovers() {
        clickLink("Hovers");
    }
}