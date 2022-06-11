package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _11_FileUpload extends Base{


    @Test(priority = 1, description = "File upload")
    public void testFileUpload1(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("File Upload");
        heroAppPage.chooseFileInputBox.sendKeys("/Users/tasniemhassan/IdeaProjects/testng_framework/myTasFile2.xls");
        heroAppPage.uploadFileButton.click();

        //Locate 2 more elements
        Assert.assertEquals(heroAppPage.fileUploadedH3.getText(), "File Uploaded!");
       // Assert.assertEquals(heroAppPage.uploadedFileText.getText(), "myFileTech2.xls");


    }

    @Test(priority = 2, description = "File download")
    public void testFileDownload(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("File Download");

        //heroAppPage.downLoadFileLink.click();
    }


}
