import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {

    WebDriver driver;

    @Parameters("browserName")
    @BeforeTest
    public void openDriver(@Optional("defaultBrowser") String browserName) throws Exception {

        driver = DriverFactory.getNewInstance(browserName);
        DriverHolder.setDriver(driver);

    }

    @BeforeMethod()
    public void openHomePage() throws Exception {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void clearSession() throws Exception {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");

    }

    @AfterTest
    public void tearDown() throws Exception {
        if (driver!= null){
            driver.quit();
        }
    }
}
