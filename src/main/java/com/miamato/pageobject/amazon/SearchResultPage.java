package com.miamato.pageobject.amazon;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class SearchResultPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultPage.class.getSimpleName());

    @FindAll(@FindBy(xpath = "//a[contains(@class,'search_result_row')]"))
    public static List<WebElement> SEARCH_RESULTS_PRODUCT_TILES;


    @FindAll(@FindBy(xpath = "//div[@id='departments']//span[@class='a-size-base a-color-base']"))
    public  List<WebElement> SEARCH_RESULTS_DEPARTMENTS_IN_LEFT_MENU;

    public  final Integer TARGET_DEPARTMENT_INDEX = 0;

    public SearchResultPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }


    public SearchResultPage selectProductByPosition(int position){
        logger.info("Trying to select product with position: " + position + " from search results");
        clickOnElement(SEARCH_RESULTS_PRODUCT_TILES, position, logger);
        return this;
    }

}
