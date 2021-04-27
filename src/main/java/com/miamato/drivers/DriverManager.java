package com.miamato.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static final Logger log = LogManager.getLogger(DriverManager.class.getSimpleName());


    public static WebDriver getDriver(String driverType) {
        WebDriver requestedDriver = null;
        switch (driverType.toUpperCase(Locale.ROOT)) {
            case "CHROME": {
                log.info("Chrome driver selected");
                requestedDriver = initChrome();
            }
//            case "FIREFOX" : {
//                log.info("Firefox driver selected");
//                requestedDriver = initFirefox();
//            }
//            case "EDGE": {
//                log.info("Edge driver selected");
//                requestedDriver = initEdge();
//            }
        }

        return requestedDriver;
    }
    private static WebDriver initChrome(){
        log.info("Setting up new ChromeDriver");
        System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
        return new ChromeDriver();
    }
//    private WebDriver initFirefox(){
//        //firefox requires not only browser to be installed but also profile to be created.
//        log.info("Setting up new FirefoxDriver");
//        System.setProperty("webdriver.gecko.driver", System.getProperty("driver.path") + "/geckodriver.exe");
//        FirefoxProfile profile = new ProfilesIni().getProfile("TestAutomation");
//        FirefoxOptions ffOptions = new FirefoxOptions();
//        ffOptions.setProfile(profile);
//        return new FirefoxDriver(ffOptions);
//    }

    private static WebDriver initEdge(){
        log.info("Setting up new EdgeDriver");
        System.setProperty("webdriver.edge.driver", System.getProperty("driver.folder") + "/msedgedriver.exe");
        return new EdgeDriver();
    }

}
