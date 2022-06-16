package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _14_Scrolling extends Base{

    @Test
    public void testScrolling(){
        driver.get("https://www.techglobalschool.com/");

        Waiter.pause(3);
       // actions.moveToElement(tgHomePage.registerForIntroLink).perform();
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
       // actions.sendKeys(Keys.PAGE_UP).perform();

       // js.executeScript("var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0); var elementTop = arguments[0].getBoundingClientRect().top; window.scrollBy(0, elementTop-(viewPortHeight/2));",tgHomePage.registerForIntroLink);
        //js.executeScript("arguments[0].scrollIntoView({block: 'center'})",tgHomePage.registerForIntroLink);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'})",tgHomePage.faceBookIcon);

        Waiter.pause(10);

    }
}
