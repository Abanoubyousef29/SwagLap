package Pages;

import Engine.ActionsBot;
import Util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P02_ProductsPage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;
    public static float totalPrice;
    public static float roundedTotalPrice;

    public P02_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By PRODUCT_ITEM_LIST = By.xpath("//div[@data-test='inventory-item']");
    private final By PRODUCT_ITEM_PRICE_LIST = By.xpath("//div[@data-test='inventory-item'] //child :: div[@data-test='inventory-item-price']");
    private final By PRODUCT_ITEM_TITLE_LIST = By.xpath("//div[@data-test='inventory-item'] //child :: div[@data-test='inventory-item-name']");
    private final By PRODUCT_ITEM_DESCRIPTION_LIST = By.xpath("//div[@data-test='inventory-item'] //child :: div[@data-test='inventory-item-desc']");
    private final By SORT_CONTAINER_DROPDOWN_LIST = By.xpath("//select[@data-test='product-sort-container']");


    private final By PRODUCT_ITEM_ADD_TO_CART = By.xpath("//div[@class='pricebar'] // button");
    private final By OPEN_CART_BUTTON = By.xpath("//div[@id='shopping_cart_container']");


    public int totalProductNumber() {
        return ActionsBot.getSizeOfElementList(driver, this.PRODUCT_ITEM_LIST);
    }

    public int totalProductTitleNumber() {
        return ActionsBot.getSizeOfElementList(driver, this.PRODUCT_ITEM_TITLE_LIST);
    }

    public int totalProductPriceNumber() {
        return ActionsBot.getSizeOfElementList(driver, this.PRODUCT_ITEM_PRICE_LIST);
    }

    public int totalProductDescriptionNumber() {
        return ActionsBot.getSizeOfElementList(driver, this.PRODUCT_ITEM_DESCRIPTION_LIST);
    }

    public P02_ProductsPage clickSortDropdownList() {
        ActionsBot.click(driver, this.SORT_CONTAINER_DROPDOWN_LIST);
        return this;
    }

    public P02_ProductsPage selectByTextFromSorting(String sorting) {
        Select objSelect = new Select(driver.findElement(this.SORT_CONTAINER_DROPDOWN_LIST));
        objSelect.selectByVisibleText(sorting);
        return this;
    }

    public List<String> productPriceList() {
        List<WebElement> priceElements = driver.findElements(PRODUCT_ITEM_PRICE_LIST);
        List<String> priceTexts = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            priceTexts.add(priceElement.getText());
        }

        return priceTexts;
    }

    public P02_ProductsPage addRandomProductToCart() {
        int randomnumber;
        randomnumber = Utility.generateRandomNumberBasedOnMaxNumberList(driver.findElements(this.PRODUCT_ITEM_ADD_TO_CART).size());
        driver.findElements(this.PRODUCT_ITEM_ADD_TO_CART).get(randomnumber).click();

        return this;
    }

    public P02_ProductsPage clickOnCartButton() {
        ActionsBot.click(driver, this.OPEN_CART_BUTTON);
        return this;
    }

}
