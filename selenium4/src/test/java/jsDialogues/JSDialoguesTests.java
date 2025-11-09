package jsDialogues;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptAlertsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JSDialoguesTests extends BaseTests {
    private HomePage homePage;
    private JavaScriptAlertsPage javaScriptAlertsPage;
    String resultText;

    @BeforeMethod
    public void setUpPages()
    {
        homePage = new HomePage(driver);
        javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        homePage.javaScriptAlerts();
    }

    @Test
    public void testAlerts()
    {
        resultText = "You successfully clicked an alert";

        javaScriptAlertsPage.triggerAlert().alertClickToAccept();

        assertEquals(javaScriptAlertsPage.getResultText(), resultText, "Hi Fady");
    }

    @Test
    public void testConfirm()
    {
        resultText = "I am a JS Confirm";

        javaScriptAlertsPage.triggerConfirm();
        assertEquals(javaScriptAlertsPage.alertGetText(), resultText, "The text is incorrect" );

        javaScriptAlertsPage.alertClickToCancel();
        assertEquals(javaScriptAlertsPage.alertGetText(), "You clicked: Cancel", "The text is incorrect" );

    }

    @Test
    public void testPrompt()
    {
        String text = "Route";
        resultText = "I am a JS prompt";

        javaScriptAlertsPage.triggerPrompt()
                .alertSetText(text);

        assertEquals(javaScriptAlertsPage.alertGetText(), resultText, "The text is incorrect");

        javaScriptAlertsPage.alertClickToAccept();

         assertTrue(javaScriptAlertsPage.getResultText().contains(text), "The text is incorrect");
    }
}