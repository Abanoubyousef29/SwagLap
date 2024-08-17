package Pages;

import Engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_BurgerMenuPage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;


    public P04_BurgerMenuPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By BURGER_MENU_BUTTON = By.xpath("//div[@class='bm-burger-button']");
    private final By LOGOUT_BUTTON = By.xpath("//a[@data-test='logout-sidebar-link']");
    private final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");


    public P04_BurgerMenuPage clickOnBurgerMenu() {

        ActionsBot.click(driver, this.BURGER_MENU_BUTTON);
        return this;
    }

    public P04_BurgerMenuPage clickOnLogout() {
        ActionsBot.click(driver, this.LOGOUT_BUTTON);
        return this;
    }


    public boolean loginButtonDisplayed() {
        return ActionsBot.elementDisplayed(driver,this.LOGIN_BUTTON);
    }
}
