package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {
    private KeyPressesPage keyPressesPage;
    String expectedText = "You entered: A";

    @BeforeMethod
    public void setKeyPressesPage()
    {
        keyPressesPage = new KeyPressesPage(driver);
    }

    @Test
    public void testBackSpace()
    {
        homePage.clickKeyPresses();
//        keyPressesPage.setText(Keys.chord(Keys.BACK_SPACE, Keys.SHIFT ));
        keyPressesPage.setText(Keys.chord( Keys.SHIFT + "a"));
        assertEquals(keyPressesPage.getText(), expectedText, "The text is incorrect");
    }
}