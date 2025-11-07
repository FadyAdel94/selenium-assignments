package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    private LoginPage loginPage;
    private WebDriver driver;
    private HomePage homePage;

    String username = "tomsmith";
    String password = "SuperSecretPassword!";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @Test
    public void LoginForm() {
        /*
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        */
//        driver.get("https://the-internet.herokuapp.com/");
//        homePage = new HomePage(driver);
//        homePage.clickFormAuth();

        loginPage = new LoginPage(driver);

        // Method chaining
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}