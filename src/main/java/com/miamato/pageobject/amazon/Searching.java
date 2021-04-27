package com.miamato.pageobject.amazon;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searching extends BasePage {

    private static final Logger logger = LogManager.getLogger(Searching.class.getSimpleName());

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchField;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchButton;


    public Searching(WebDriver driver,
                  PageManager pageManager) {
        super(driver, pageManager);
    }

    public PageManager enterSearchTerm(String searchTerm){
        logger.info("Enterting search term: " + searchTerm);
        searchField.sendKeys(searchTerm);
        return pageManager;
    }

    public PageManager initiateSearch(){
        logger.info("Initiating search");
        searchButton.click();
        return pageManager;
    }

}