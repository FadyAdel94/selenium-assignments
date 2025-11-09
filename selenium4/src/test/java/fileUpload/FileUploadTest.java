import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTests {
    private FileUploadPage fileUploadPage;
    String fileName;
    String filePath;

    @BeforeMethod
    public void setFileUploadPage() {
        fileUploadPage = new FileUploadPage(driver);
    }

    @Test
    public void testFileUpload()
    {
        fileName = "fady.txt";
        filePath = System.getProperty("user.dir") + "\\resources\\fady.txt";

        homePage.clickFileUpload();

        fileUploadPage.uploadFile(filePath)
                .clickUploadButton();

        assertEquals(fileUploadPage.getUploadedFileName(), fileName,
                "The file name is incorrect");
    }
}