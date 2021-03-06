package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.time.Duration;
import java.util.List;

public class _12_Actions_Class extends Base{

    @Test(priority = 1, description="Actions | move to element 1")
    public void moveToElementPractice1(){
        driver.get("https://www.techglobalschool.com/");

        WebElement address = driver.findElement(By.cssSelector("#comp-kixny3ro span>span"));

        actions.moveToElement(address).build().perform();
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
    }
    /*
Go to https://www.carvana.com/
Hover over "FINANCING" menu item (dropdown)
Validate below items are displayed

WHY FINANCE WITH CARVANA
GET PREQUALIFIED
AUTO LOAN CALCULATOR
 */


    @Test(priority = 2, description ="Actions | move to element 2")
    public void moveToElementPractice2() {
        driver.get("https://www.carvana.com/");
        Waiter.pause(3);
        WebElement financeDropdown = driver.findElement(By.cssSelector("div[data-cv-test='headerFinanceDropdown']"));

        actions.moveToElement(financeDropdown).perform();

        List<WebElement> financeDropdownOptions = driver.findElements(By.cssSelector("a[data-cv-test^='headerFinance']"));

        String[] optionsTexts = {"WHY FINANCE WITH CARVANA", "GET PREQUALIFIED", "AUTO LOAN CALCULATOR"};
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(financeDropdownOptions.get(i).isDisplayed());
            Assert.assertEquals(financeDropdownOptions.get(i).getText(), optionsTexts[i]);
        }
    }

    /*
    Go to https://www.techglobalschool.com/
    Click on "Register for Intro Session" link
    Validate the url is https://www.techglobalschool.com/apply-now-1
     */
        @Test(priority = 3 , description = "Actions | Click")
        public void clickOnElementPractice(){
            driver.get("https://www.techglobalschool.com/");

            WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5 a"));
            actions.click(registerForIntroLink).perform();

            //Second way to combine all action
           // actions.moveToElement(registerForIntroLink).pause(Duration.ofSeconds(2)).click().perform();

            Assert.assertTrue(driver.getCurrentUrl().equals("https://www.techglobalschool.com/apply-now-1"));

        }

        @Test(priority = 4, description = "Actions | Right click")
    public void rightClickPractice(){
            driver.get("https://www.techglobalschool.com/");

            WebElement registerForIntroLink = driver.findElement(By.cssSelector("#comp-kvjohd5t5 a"));

            actions.contextClick(registerForIntroLink).perform();

            Assert.assertTrue(driver.getCurrentUrl().equals("https://www.techglobalschool.com/"));

        }

    /*
Go to https://demoqa.com/droppable
Click and hold "Drag me" box and release it on "Drop here" box
Validate "Drop here" text is replaced with "Dropped!"
*/
        @Test(priority = 5, description = "Actions | Click - hold and release")
    public void clickHoldAndReleasePractice(){
            driver.get("https://demoqa.com/droppable");

            WebElement dragMeBox = driver.findElement(By.id("draggable"));
            WebElement dropHereBox = driver.findElement(By.id("droppable"));

            actions.clickAndHold(dragMeBox).moveToElement(dropHereBox).release().perform();

    Assert.assertEquals(dropHereBox.getText(), "Dropped!");
        }

    /*
Go to https://www.google.com/
Enter "Hello" to search input box
Validate value attribute is "Hello"

Method name = sendKeysToAnElement ()
Test name = Actions class | send keys to an element
*/
     @Test(priority = 6, description = "Actions class | send keys to an element")
    public void sendKeysToAnElement(){
            driver.get("https://www.google.com/");
         actions.sendKeys(googleSearchPage.searchInputBox, "Hello").perform();

         Assert.assertEquals(googleSearchPage.searchInputBox.getAttribute("value"), "Hello");

     }

    /*
Go to https://www.google.com/
Enter "techglobal" to search input box with uppercases
Validate the value attribute for search input box is "TECHGLOBAL"
Then, copy the text and paste again
Validate the value attribute for search input box is "TECHGLOBALTECHGLOBAL"
 */

    @Test(priority = 7, description = "Actions | key down and key up")
    public void practiceKeyDownAndKeyUp(){
        driver.get("https://www.google.com/");

        //googleSearchPage.searchInputBox.sendKeys("TECHGLOBALTECHGLOBAL");

        actions.keyDown(Keys.SHIFT)
                .sendKeys(googleSearchPage.searchInputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(5))
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .pause(Duration.ofSeconds(5))
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .pause(Duration.ofSeconds(5))
                .keyDown(Keys.COMMAND).sendKeys("v")
                .perform();

        Waiter.pause(5);
    }

   /*
Go to https://www.etsy.com/
Hover over on "Jewelry & Accessories" menu item
Validate below categories are displayed with their expected texts
Accessories
Bags & Purses
Necklaces
Rings
Earrings
Bracelets
Body Jewelry
All Jewelry
 */

    @Test(priority = 8, description = "Etsy | test")
    public void etsyTest(){

        driver.get("https://www.etsy.com/");

        actions.moveToElement(etsySearchPage.mainHeaderLinks.get(1)).perform();

        Waiter.pause(3);
        String[] jewleryAndAccessoryMenuItemsTexts = {"Accessories","Bags & Purses","Necklaces", "Rings", "Earrings", "Bracelets", "Body Jewelry" , "All Jewelry" };

        for(int i = 0; i < 8; i++){
            Waiter.waitUntilTextToBePresentInElement(driver, 10, etsySearchPage.jewelryAndAccessoriesItems.get(i), jewleryAndAccessoryMenuItemsTexts[i]);
        Assert.assertEquals(etsySearchPage.jewelryAndAccessoriesItems.get(i).getText(), jewleryAndAccessoryMenuItemsTexts[i]);
        }

    }
}
