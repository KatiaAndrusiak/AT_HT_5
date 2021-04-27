package com.miamato.pageobject.amazon;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class BasketPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(BasketPage.class.getSimpleName());

    @FindAll(@FindBy(xpath = "(//*[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//a[@class='a-link-normal a-text-normal'])"))
    public static List<WebElement> PRODUCT_LINK_TO_CLICK;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    protected static WebElement ADD_TO_BASKET_BUTTON;

    @FindBy(xpath = "//*[@id='nav-cart-count']")
    public WebElement BASKET_TOTAL_QUANTITY;

    public  final String TARGET_BASKET_QUANTITY_1 = "1";

    @FindBy(xpath = "//a[@id=\"nav-cart\"]")
    protected static WebElement BASKET_AREA_TO_CLICK;

    @FindBy(xpath = "//input[@data-action='delete'][1]")
    protected static WebElement DELETE_ITEM_FROM_BASKET_BUTTON;

    public  final String TARGET_BASKET_QUANTITY_0 = "0";

    protected  final int INDEX_OF_PRODUCT_TO_ADD = 3;
    public BasketPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }

    public BasketPage openSelectedProductItem(){
        logger.info("Clicking on element " + PRODUCT_LINK_TO_CLICK.get(INDEX_OF_PRODUCT_TO_ADD));
        PRODUCT_LINK_TO_CLICK.get(INDEX_OF_PRODUCT_TO_ADD).click();
        return this;
    }

    public void addProductToBasket(){
        logger.info("Clicking on element " + ADD_TO_BASKET_BUTTON);
        ADD_TO_BASKET_BUTTON.click();
    }

    public BasketPage openBasket(){
        logger.info("Clicking on element " + BASKET_AREA_TO_CLICK);
        this.clickOnElement(BASKET_AREA_TO_CLICK, logger);
        return this;
    }

    public void removeProductFromBasket(){
        logger.info("Clicking on element " + DELETE_ITEM_FROM_BASKET_BUTTON);
        DELETE_ITEM_FROM_BASKET_BUTTON.click();
    }
}
