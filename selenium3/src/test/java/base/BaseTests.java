package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        goHome();
    }

    @Test
    public void goHome() {
        homePage = new HomePage(driver); // fix driver null issue
        homePage.clickFormAuth();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}