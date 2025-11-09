package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown"); //Locator for dropdown

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public DropdownPage selectFromDropdown(String option) {
        findDropdownElement().selectByVisibleText(option);
        return this;
    }

    /**
     * Alternative implementation using streams
     *
     * Stream is a sequence of elements supporting sequential and parallel aggregate operations.
     * The stream API allows us to process collections of objects in a functional style.
     * In this case, we are using streams to transform a list of WebElement objects into a list of their text representations.
     */
    public List<String> getSelectedOptions() {
        return findDropdownElement().getAllSelectedOptions()     // List<WebElement>
                .stream()                                            // Stream<WebElement>
                .map(WebElement::getText)                            // Stream<String>
                .collect(Collectors.toList());                       // List<String>
    }

    private Select findDropdownElement() {
        return new Select(driver.findElement(dropdown));
    }
}