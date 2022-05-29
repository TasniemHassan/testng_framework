package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TGApplicationPage {
    public TGApplicationPage(WebDriver driver){
        PageFactory.initElements(driver, this); //this key word is reference to current object
    }
    @FindBy(xpath = "//div[@id='comp-kh9s3kyz3']//span/span")
    public WebElement heading1;
}
