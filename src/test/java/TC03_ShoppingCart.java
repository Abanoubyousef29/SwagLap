import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import Pages.P03_ShoppingCartPage;
import Util.Utility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Util.Utility.getJsonFilePath;
import static Util.Utility.getSingleJsonData;

public class TC03_ShoppingCart extends TestBase {

    //define test data
    String validEmail = getSingleJsonData(getJsonFilePath("valid_login_credentials.json"), "validEmail");
    String validPassword = getSingleJsonData(getJsonFilePath("valid_login_credentials.json"), "validPassword");


    public TC03_ShoppingCart() throws IOException, ParseException {
    }

    //when adding any product to the cart it got updated
    @Test(priority = 1, description = "when adding any product to the cart it got updated")
    public void cartUpdatedWhenAddingAProduct() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        new P02_ProductsPage(driver).addRandomProductToCart().clickOnCartButton();
        Assert.assertTrue(new P03_ShoppingCartPage(driver).shoppingCartIsNotEmpty());
    }


    //when removing any product to the cart it got updated
    @Test(priority = 2, description = "when removing any product to the cart it got updated")
    public void cartUpdatedWhenRemovingAProduct() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        new P02_ProductsPage(driver).addRandomProductToCart().clickOnCartButton();
        new P03_ShoppingCartPage(driver).emptyTheCart();
        Assert.assertTrue(new P03_ShoppingCartPage(driver).shoppingCartIsEmpty());
    }

    //when adding any product to the cart the cart bagde it got updated
    @Test(priority = 3, description = "when adding any product to the cart the cart bagde it got updated")
    public void cartBagdeUpdatedWhenAddingAProduct() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        new P02_ProductsPage(driver).addRandomProductToCart().clickOnCartButton();
        Assert.assertTrue(new P03_ShoppingCartPage(driver).shoppingCartBadgeIsNotZero());
    }

    //when removing any product to the cart the cart bagde it got updated
    @Test(priority = 4, description = "when removing any product to the cart the cart bagde it got updated")
    public void cartBagdeUpdatedWhenRemovingAProduct() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        new P02_ProductsPage(driver).addRandomProductToCart().clickOnCartButton();
        new P03_ShoppingCartPage(driver).emptyTheCart();
        Assert.assertTrue(new P03_ShoppingCartPage(driver).shoppingCartBadgeZero());
    }


}

