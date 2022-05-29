package scripts;

import com.sun.javafx.scene.control.skin.TableHeaderRow;
import com.sun.prism.impl.BaseMesh;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    EtsySearchPage etsySearchPage;
    TGApplicationPage tgApplicationPage; //declare here
    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;
    HeroAppPage heroAppPage;
    FaceBookPage faceBookPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).
                pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        etsySearchPage = new EtsySearchPage(driver); // initialized here
        tgApplicationPage = new TGApplicationPage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        heroAppPage = new HeroAppPage(driver);
        faceBookPage = new FaceBookPage(driver);


    }


    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}