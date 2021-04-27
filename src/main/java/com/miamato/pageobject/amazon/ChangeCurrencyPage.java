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

public class ChangeCurrencyPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(ChangeCurrencyPage.class.getSimpleName());

    @FindBy(xpath ="//a[@id='icp-nav-flyout']")
    protected static WebElement CHANGE_CURRENCY_BUTTON;

    @FindBy(xpath = "//select[@id='icp-sc-dropdown']")
    protected static WebElement DROP_DOWN_MENU;

    @FindBy(xpath = "//input[@class='a-button-input']")
    protected static WebElement SAVE_CURRENCY_CHANGES_BUTTON;

    @FindAll(@FindBy(xpath = "//*[@class='_p13n-desktop-carousel_price_p13n-sc-price__bCZQt' and contains(text(), 'PLN')]"))
    public List<WebElement> CHECKING_IF_CURRENCY_IS_CHANGED;


    public ChangeCurrencyPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }

    public ChangeCurrencyPage openChangeCurrencyPage(){
        logger.info("Clicking on element " + CHANGE_CURRENCY_BUTTON);
        this.clickOnElement(CHANGE_CURRENCY_BUTTON, logger);
        return this;
    }

    public ChangeCurrencyPage selectCurrency(String value){
        logger.info("Select currency from drop-down menu: " + DROP_DOWN_MENU+ " by value: "+ value);
        this.selectFromDropdownByValue(DROP_DOWN_MENU,value,logger);
        return this;
    }

    public void saveSelectedCurrency(){
        logger.info("Clicking on element " + SAVE_CURRENCY_CHANGES_BUTTON);
        this.clickOnElement(SAVE_CURRENCY_CHANGES_BUTTON, logger);
    }


}
