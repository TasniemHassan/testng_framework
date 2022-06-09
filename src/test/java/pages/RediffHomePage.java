package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage {
        public RediffHomePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        /*DIFFERENT WAY
          @FindBy(css = "div[class^='cell']")
    public List<WebElement> moneyCells;
         */
    @FindBy(css=".cellone")
    public WebElement cellOne;


    @FindBy(css=".celltwo")
    public WebElement cellTwo;

    @FindBy(id = "moneyiframe")
    public WebElement moneyIFrame;

    }
