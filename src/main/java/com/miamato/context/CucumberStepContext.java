package com.miamato.context;

import com.miamato.PropertyManager;
import com.miamato.drivers.DriverManager;
import com.miamato.pageobject.PageManager;
import org.openqa.selenium.WebDriver;

public class CucumberStepContext {

    WebDriver driver;
    PageManager pageManager;
    private static CucumberStepContext instance;

    private CucumberStepContext(){}

    public static CucumberStepContext getInstance(){
        if(instance == null)
            instance = new CucumberStepContext();
        return instance;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    public void setPageManager(PageManager pageManager) {
        this.pageManager = pageManager;
    }

}
