package hovers;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTest extends BaseTests {
    private HomePage homePage;
    private HoversPage hoversPage;

    @Test
    public void testHovers() {
        homePage = new HomePage(driver);
        hoversPage = new HoversPage(driver);

        homePage.clickHovers();

        var figureCaption = hoversPage.hoverOverFigure(2); // index of 1 for user2
        assertTrue(figureCaption.isCaptionDisplayed(), "The caption is not displayed");
        assertEquals(figureCaption.getName(), "name: user2", "The name is incorrect");
        assertEquals(figureCaption.getLinkText(), "view profile");
        assertTrue(figureCaption.getLink().endsWith("/users/2"), "The link is incorrect");
    }
}