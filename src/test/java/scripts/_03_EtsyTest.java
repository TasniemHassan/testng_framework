package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EtsyTest extends Base{

    /*
1. Go to https://www.etsy.com/
2. Validate Etsy logo is displayed

testEtsyLogo
 */

//2. Validation of test - test
    @Test(priority = 1)
    public void testEtsyLogo(){
        driver.get("https://www.etsy.com/");
        //Get logo Web Element from EtsySearchPage
       // WebElement logo = driver.findElement(By.id("logo"));

        Assert.assertTrue(etsySearchPage.logo.isDisplayed());
    }

    /*
1. Go to https://www.etsy.com/
2. Validate Etsy search input box and search button is displayed

testEtsySearch
 */
    @Test(priority = 3)
    public void testEtsySearch(){
        driver.get("https://www.etsy.com/");
        //Get searchInputBox and searchButton from EtsySearchPage
       //WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));
       // WebElement searchButton = driver.findElement(By.xpath("//button[@data-id='gnav-search-submit-button']"));
       // WebElement searchButton = driver.findElement(cssSelector("button[data-id='gnav-search-submit-button']"));

        Assert.assertTrue(etsySearchPage.searchInputBox.isDisplayed());
        Assert.assertTrue(etsySearchPage.searchButton.isDisplayed());

    }
    /*

1. Go to https://www.etsy.com/
2. Search for "canvas painting"
3. Validate the results are more than zero
 */
    @Test(priority = 2 ,dependsOnMethods = "testEtsySearch" )
    public void testEtsySearchResult(){
        driver.get("https://www.etsy.com/");
        //WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));

        etsySearchPage.searchInputBox.sendKeys("canvas painting" + Keys.ENTER);

        //WebElement resultTag = driver.findElement(By.cssSelector(".wt-display-inline-flex-sm>span"));

        System.out.println(etsySearchPage.resultTag.getText());
        etsySearchPage.resultTag.getText().replaceAll("[^0-9]","");

        Assert.assertTrue(Integer.parseInt(etsySearchPage.resultTag.getText().replaceAll("[^0-9]","")) > 0);

    }
    @Test(priority = 4, description = "TC905: Validate Etsy main header")
    public void testMainHeader(){
        driver.get("https://www.etsy.com/");

        String[] expectedTexts = {
                "Shop Home Sales!",
                "Jewelry & Accessories",
                "Clothing & Shoes",
                "Home & Living",
                "Wedding & Party",
                "Toys & Entertainment",
                "Art & Collectibles",
                "Craft Supplies",
                "Gifts & Gift Cards"};

        for(int i = 0; i < 9; i++){
            Assert.assertEquals(etsySearchPage.mainHeaderLinks.get(i).getText().trim(), expectedTexts[i], "The expected text is not displayed");
            //trim() not necessary here but if needed, if test fails bc there are spaces before and after then can trim()
        }

    }
}
