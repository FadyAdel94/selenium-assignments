import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

import java.util.List;

public class BaseTest {
    private static WebDriver driver; // global field of WebDriver
    private static final By input = By.linkText("Inputs"); // global locator
    private static final By inputUpdate = By.xpath("//a[contains(text(), 'Inputs')]");

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/"); // navigate to the URL ⇒ opens the URL in the browser (Chrome)

//        driver.manage().window().fullscreen(); // full screen the browser window (F11)
//        driver.manage().window().maximize(); // maximize the browser window
        driver.manage().window().setSize(new Dimension(350, 400)); // set the size of the browser window

        String title = driver.getTitle(); //Reads the title of the page
        System.out.println(title);

        //Locate element
//        driver.findElement(By.tagName("a")); // returns the first element with the tag name "a"
//        WebElement input = driver.findElement(By.linkText("Inputs")); // returns the first element with the link text "inputs"
//        input.click();

//        WebElement inputLocatorLink = driver.findElement(input); // using the global locator
//        WebElement inputLocator = driver.findElement(input); // using the global locator
//        WebElement inputLocator = driver.findElement(inputUpdate); // using the global locator
//        inputLocator.click();

//        WebElement i = getInput(27);
//        if(i.equals(inputLocatorLink)) {
//            i.click();
//            System.out.println(i);
//        } else {
//            System.out.println("Locator is incorrect");
//        }


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links are " + links.size());
        for (WebElement link : links)
        {
            System.out.println(link.findElement(By.linkText("Inputs")).getText());
        }


//        driver.close(); // close the browser without terminate the session
//        driver.quit(); // close the browser and terminate the session
    }

    // dynamic locator
    public static WebElement getInput(int i)
    {
        return driver.findElement(By.xpath("//ul/li[" + i + "]//a"));
    }
}