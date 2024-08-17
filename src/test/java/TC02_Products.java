import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import Util.Utility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Util.Utility.getJsonFilePath;
import static Util.Utility.getSingleJsonData;

public class TC02_Products extends TestBase {

    //define test data
    String validEmail = getSingleJsonData(getJsonFilePath("valid_login_credentials.json"), "validEmail");
    String validPassword = getSingleJsonData(getJsonFilePath("valid_login_credentials.json"), "validPassword");
    String sort = getSingleJsonData(getJsonFilePath("sortingValue.json"), "sorting");

    public TC02_Products() throws IOException, ParseException {
    }

    // check that each product item contain title
    @Test(priority = 1, description = "check that each item contain title")
    public void eachItemContainsTitle() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        Assert.assertEquals(
                new P02_ProductsPage(driver).totalProductNumber(),
                new P02_ProductsPage(driver).totalProductTitleNumber()
        );
    }

    // check that each product item contain price
    @Test(priority = 2, description = "check that each item contain price")
    public void eachItemContainsPrice() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        Assert.assertEquals(
                new P02_ProductsPage(driver).totalProductNumber(),
                new P02_ProductsPage(driver).totalProductPriceNumber()
        );
    }

    // check that each product item contain description
    @Test(priority = 3, description = "check that each item contain description")
    public void eachItemContainsDescription() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        Assert.assertEquals(
                new P02_ProductsPage(driver).totalProductNumber(),
                new P02_ProductsPage(driver).totalProductDescriptionNumber()
        );
    }

    // check that sorting is working
    @Test(priority = 4, description = "check that the sorting is working")
    public void sorting() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        new P02_ProductsPage(driver).clickSortDropdownList().selectByTextFromSorting(sort);
        Assert.assertTrue(
                Utility.isSortedAscending(
                        new P02_ProductsPage(driver)
                                .productPriceList()));
    }

}

