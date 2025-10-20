package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "username")
    private By username;

    @FindBy(xpath = "//input[@type='password']")
    private By password;

    @FindBy(css = "#login > button")
    private By loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public LoginPage enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return this;
    }
}