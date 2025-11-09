package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {

    private WebDriver driver;
    private By alertTriggerButton = By.xpath("//button[contains(., 'Alert')]"); // static shape ⇒ change to dynamic
    private By confirmTriggerButton = By.xpath("//button[contains(., 'Confirm')]");
    private By promptTriggerButton = By.xpath("//button[contains(., 'Prompt')]");
    private By resultText = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public JavaScriptAlertsPage triggerAlert()
    {
        // Eslam's way to use dynamic locator
        getAlertTriggerButtonLocator(alertTriggerButton);
        return this;
    }

    public JavaScriptAlertsPage triggerConfirm()
    {
        getAlertTriggerButtonLocator(confirmTriggerButton);
        return this;
    }

    public JavaScriptAlertsPage triggerPrompt()
    {
        getAlertTriggerButtonLocator(promptTriggerButton);
        return this;
    }

//    public void clickTriggerButton(){
//        driver.findElement(alertTriggerButton).click();
//    }

    public JavaScriptAlertsPage alertClickToAccept(){
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage alertClickToCancel(){
        driver.switchTo().alert().dismiss();
        return this;
    }

    public JavaScriptAlertsPage alertSetText(String text){
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public String alertGetText(){
        return driver.switchTo().alert().getText();
    }

    public String getResultText(){
       return driver.findElement(resultText).getText();
    }

    private void getAlertTriggerButtonLocator(By button){
        driver.findElement(button).click();
    }
}