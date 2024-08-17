import Pages.P01_LoginPage;
import Pages.P04_BurgerMenuPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Util.Utility.getJsonFilePath;
import static Util.Utility.getSingleJsonData;

public class TC01_Login extends TestBase {

    //define test data
    String validEmail = getSingleJsonData(getJsonFilePath("valid_login_credentials.json"), "validEmail");
    String validPassword = getSingleJsonData(getJsonFilePath("valid_login_credentials.json"), "validPassword");

    String unValidEmail = getSingleJsonData(getJsonFilePath("unValid_login_credentials.json"), "unValidEmail");
    String unvalidPassword = getSingleJsonData(getJsonFilePath("unValid_login_credentials.json"), "unValidPassword");
    String errorMessage = getSingleJsonData(getJsonFilePath("unValid_login_credentials.json"), "errorMessage");

    public TC01_Login() throws IOException, ParseException {
    }

    // check login positive scenario
    @Test(priority = 1, description = "check that a user can login with valid credentials")
    public void validLogin() {
        new P01_LoginPage(driver).inputEmail(validEmail).inputPassword(validPassword).clickLoginButton();
        Assert.assertTrue(new P01_LoginPage(driver).loginButtonNotDisplayed());
    }

    // check login negative scenario
    @Test(priority = 2, description = "check that a user can not login with un valid credentials")
    public void unValidLogin() {
        new P01_LoginPage(driver).inputEmail(unValidEmail).inputPassword(unvalidPassword).clickLoginButton();
        Assert.assertTrue(driver.findElement(By.tagName("body")).
                getText().contains(errorMessage));
    }
}

