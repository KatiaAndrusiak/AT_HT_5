package com.miamato.pageobject;

import com.miamato.pageobject.amazon.*;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageManager {

    private static final Logger logger = LogManager.getLogger(PageManager.class.getSimpleName());

    public WebDriver driver;
    private HomePage homePage;
    private ChangeCurrencyPage changeCurrencyPage;
    private BasketPage basketPage;
    private SearchResultPage searchResultPage;
    private CookiesPopUp cookiesPopUp;
    private Searching searching;
    private SearchByCategoryPage searchByCategoryPage;
    private LoginPage loginPage;


    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        if(homePage == null)
            homePage = new HomePage(driver, this);
        return homePage;
    }

    public BasketPage basketPage(){
        if(basketPage == null)
            basketPage = new BasketPage(driver, this);
        return basketPage;
    }


    public ChangeCurrencyPage changeCurrencyPage(){
        if(changeCurrencyPage == null)
            changeCurrencyPage = new ChangeCurrencyPage(driver, this);
        return changeCurrencyPage;
    }

    public SearchResultPage searchResultPage(){
        if(searchResultPage == null)
            searchResultPage = new SearchResultPage(driver, this);
        return searchResultPage;
    }

    public CookiesPopUp cookiesPopUp(){
        if(cookiesPopUp == null)
            cookiesPopUp = new CookiesPopUp(driver, this);
        return cookiesPopUp;
    }
    public Searching searching(){
        if(searching == null)
            searching = new Searching(driver, this);
        return searching;
    }

    public SearchByCategoryPage searchByCategoryPage(){
        if(searchByCategoryPage == null)
            searchByCategoryPage = new SearchByCategoryPage(driver, this);
        return searchByCategoryPage;
    }

    public LoginPage loginPage(){
        if(loginPage == null)
            loginPage = new LoginPage(driver, this);
        return loginPage;
    }

    public PageManager open(String url){
        logger.info("Opening page with url: " + url);
        driver.navigate().to(url);
        return this;
    }

    public PageManager waitForPageToLoad(){
        logger.info("Waiting till next page is loaded");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(
            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
