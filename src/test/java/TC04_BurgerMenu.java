import Pages.P01_LoginPage;
import Pages.P03_ShoppingCartPage;
import Pages.P04_BurgerMenuPage;
import Util.SessionManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Util.Utility.getJsonFilePath;
import static Util.Utility.getSingleJsonData;
import static io.restassured.RestAssured.given;

public class TC04_BurgerMenu extends TestBase {

    //define test data
    String cookiesName = getSingleJsonData(getJsonFilePath("cookies.json"), "name");
    String cookiesValue = getSingleJsonData(getJsonFilePath("cookies.json"), "value");
    String URL = getSingleJsonData(getJsonFilePath("urls.json"), "productPage");

    public TC04_BurgerMenu() throws IOException, ParseException {
    }

    //when clicking on logout is should be redirecetd to login page
    @Test(priority = 1, description = "when clicking on logout is should be redirecetd to login page")
    public void logoutIsWorking() {
        // direct login without UI login
        SessionManager.setSessionCookie(driver, cookiesName, cookiesValue);
        driver.navigate().refresh();
        SessionManager.navigateToAuthenticatedPage(driver, URL);


        new P04_BurgerMenuPage(driver).clickOnBurgerMenu().clickOnLogout();
        Assert.assertTrue(new P04_BurgerMenuPage(driver).loginButtonDisplayed());
    }

}

