package frames;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedFramesPage;

import static org.testng.Assert.assertEquals;

public class FramesTests extends BaseTests {
    private NestedFramesPage nestedFramesPage;
    private FramesPage framesPage;

    @BeforeMethod
    public void setUpFramesTests() {
        nestedFramesPage = new NestedFramesPage(driver);
        framesPage = new FramesPage(driver);
    }

    @Test
    public void testFrames() {
        homePage.clickFrames();
        framesPage.clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "The text is incorrect");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "The text is incorrect");
    }
}