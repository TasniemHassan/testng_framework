package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;


public class _06_RadioButtonTest extends Base{
    /*
Go to https://www.facebook.com/
Click on "Create New Account" link
Validate "Female", "Male" and "Custom" radio buttons are displayed, enabled and not selected
Select "Female" and validate it is selected
Select "Male" radio button and validate "Male" is selected and "Female" is deselected
 */

    @Test(priority = 1, description = "TC234: Validate Facebook gender radio buttons")
    public void testFacebookGenderRadioButtons(){
        driver.get("https://www.facebook.com/");

        faceBookPage.createNewAccountLink.click();

        for(WebElement element : faceBookPage.genderRadioButtons){
            Assert.assertTrue(element.isDisplayed(), "Element IS NOT displayed");
            Assert.assertTrue(element.isEnabled(), "Element IS NOT enabled");
            Assert.assertFalse(element.isSelected(), "Element IS selected");

            //message can be ended in arguments which is a custom message for failed test^^
        }

        faceBookPage.genderRadioButtons.get(0).click();
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(0).isSelected());

        faceBookPage.genderRadioButtons.get(1).click();
        Assert.assertTrue(faceBookPage.genderRadioButtons.get(1).isSelected());
        Assert.assertFalse(faceBookPage.genderRadioButtons.get(0).isSelected());


    }
}
