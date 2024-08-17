package Pages;
import Engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver ;

    public P01_LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private final By EMAIL_TEXT = By.xpath("//input[@id='user-name']");
    private final By PASSWORD_TEXT = By.xpath("//input[@id='password']");
    private final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");


    public P01_LoginPage inputEmail(String email){
        ActionsBot.sendKeysToElement(driver , this.EMAIL_TEXT,email);
        return this;
    }

    public P01_LoginPage inputPassword(String password){
        ActionsBot.sendKeysToElement(driver , this.PASSWORD_TEXT,password);
        return this;
    }

    public P01_LoginPage clickLoginButton(){
        ActionsBot.click(driver , this.LOGIN_BUTTON);
        return this;
    }

    public boolean loginButtonNotDisplayed() {
        return ActionsBot.elementNotDisplayed(driver,this.LOGIN_BUTTON);
    }


}
