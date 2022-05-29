package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _04_GoogleSearchTest extends Base {

    /*
    TC765: Validate Google search
1. Go to "https://www.google.com/"
2. Search for "Selenium"
3. Validate the results are more than zero
     */
    @Test(priority = 1 , description = "TC765: Validate Google search")
    public void testGoogleSearch(){
        driver.get("https://www.google.com/");

        googleSearchPage.searchInputBox.sendKeys("Selenium" + Keys.ENTER);

        String results = googleSearchResultPage.resultTag.getText();
        Assert.assertTrue(Long.parseLong(results.substring(results.indexOf(" ") + 1, results.indexOf("results")-1).replaceAll(",", "")) > 0);
    }
    @Test(priority = 2, description = "TC123: Validate Google Store link")
    public void testGoogleStoreLink(){
        driver.get("https://www.google.com/");

        Waiter.waitForVisibilityOfElement(driver, googleSearchPage.storeLink, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //Wait wait = new FluentWait(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        //explicitWait.until(ExpectedConditions.visibilityOf(googleSearchPage.storeLink));

        googleSearchPage.storeLink.click();

        Waiter.waitUntilTitleIs(driver, 30, "Google Store for Google Made Devices & Accessories");

        Assert.assertEquals(driver.getTitle(), "Google Store for Google Made Devices & Accessories");
    }

}
