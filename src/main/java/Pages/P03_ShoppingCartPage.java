package Pages;

import Engine.ActionsBot;
import Util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class P03_ShoppingCartPage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;


    public P03_ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By CART_CONTAINER = By.xpath("//div[@data-test='inventory-item'] // div[@class='cart_item_label']");
    private final By REMOVE_BUTTON_LIST = By.xpath("//div[@class='item_pricebar'] // button");
    private final By SHOPPING_CART_BADGE = By.xpath("//span[@data-test='shopping-cart-badge']");


    public boolean shoppingCartIsNotEmpty() {

        return ActionsBot.elementDisplayed(driver, this.CART_CONTAINER);

    }

    public P03_ShoppingCartPage emptyTheCart() {

        int totalRemoveItems = ActionsBot.getSizeOfElementList(driver, this.REMOVE_BUTTON_LIST);
        for (int x = 0; x < totalRemoveItems; x++) {
            ActionsBot.clickOnItemInList(driver, this.REMOVE_BUTTON_LIST, x);
        }

        return this;
    }

    public boolean shoppingCartIsEmpty() {
        return ActionsBot.elementNotDisplayed(driver, this.CART_CONTAINER);

    }

    public boolean shoppingCartBadgeIsNotZero() {

        return ActionsBot.elementDisplayed(driver, this.SHOPPING_CART_BADGE);

    }

    public boolean shoppingCartBadgeZero() {
        return ActionsBot.elementNotDisplayed(driver, this.SHOPPING_CART_BADGE);

    }
}
