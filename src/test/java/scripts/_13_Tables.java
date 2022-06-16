package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _13_Tables extends Base {

    /*
Go to http://the-internet.herokuapp.com/
Click on "Sortable Data Tables" link
Validate the table 1 headers to be displayed as below
Last Name
First Name
Email
Due
Web Site
Action
 */

    @Test(priority = 1, description = "Tables | headers")
    public void testTableHeaders() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        List<WebElement> headers = driver.findElements(By.cssSelector("#table1 th"));

        String[] tableHeadersText = {"Last Name", "First Name", "Email", "Due", "Web Site", "Action"};
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(headers.get(i).getText(), tableHeadersText[i]);
        }
    }

    @Test(priority = 2, description = "Tables | first row")
    public void testFirstRow() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] table1FirstRowTexts = {"Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com", "edit delete"};
        for(int i = 0; i < 6; i++){
            Assert.assertEquals(heroAppPage.table1FirstRowCells.get(i).getText(), table1FirstRowTexts[i]);
        }

    }
    @Test(priority = 3, description = "Tables | 2nd column")
    public void testSecondColumn() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] table1SecondColumnTexts = {"John", "Frank", "Jason", "Tim"};
        for(int i = 0; i < 4; i++){
            Assert.assertEquals(heroAppPage.table1Column2Cells.get(i).getText(), table1SecondColumnTexts[i]);
        }

    }

    @Test(priority = 4, description ="Tables | all cells")
    public void testAllCells(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        List<WebElement> allCells = driver.findElements(By.cssSelector("#table1 td"));

        for(WebElement element : allCells){
            Assert.assertNotEquals(element.getText(),"");
        }
    }



}
