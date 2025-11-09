package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTest extends BaseTests {
    private DropdownPage dropdownPage;
    private HomePage homePage;
    private String option = "Option 2";

    @Test
    public void testDropdown() {
        homePage = new HomePage(driver);
        dropdownPage = new DropdownPage(driver);

        homePage.clickDropdown();
        dropdownPage.selectFromDropdown(option);

        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "The size is incorrect");
        assertTrue(selectedOptions.contains(option), "The option is not selected");
    }
}