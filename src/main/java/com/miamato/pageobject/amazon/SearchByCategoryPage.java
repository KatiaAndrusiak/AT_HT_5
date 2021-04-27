package com.miamato.pageobject.amazon;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchByCategoryPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultPage.class.getSimpleName());
    @FindBy(xpath = "//select[@id=\"searchDropdownBox\"]")
    protected static WebElement DROP_DOWN_MENU;


    @FindBy(xpath = "//*[@class=\"nav-a-content\"]")
    public WebElement NAVIGATION_CONTENT;

    public SearchByCategoryPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }

    public SearchByCategoryPage selectCategory(String value){
        logger.info("Select currency from drop-down menu: " + DROP_DOWN_MENU+ " by value: "+ value);
        this.selectFromDropdownByValue(DROP_DOWN_MENU,value,logger);
        return this;
    }

    public SearchByCategoryPage selectCategoryByVisibleText(String value){
        logger.info("Select currency from drop-down menu: " + DROP_DOWN_MENU+ " by value: "+ value);
        this.selectFromDropdownByText(DROP_DOWN_MENU,value,logger);
        return this;
    }






}
