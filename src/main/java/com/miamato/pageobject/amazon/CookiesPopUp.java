package com.miamato.pageobject.amazon;
import com.miamato.LogUtil;
import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesPopUp extends BasePage {

    private static final Logger logger = LogManager.getLogger(CookiesPopUp.class.getSimpleName());

    @FindBy(xpath = "//input[@id='sp-cc-accept']")
    public WebElement acceptAllCookiesButton;

    public CookiesPopUp(WebDriver driver,
                        PageManager pageManager) {
        super(driver, pageManager);
    }

    public PageManager acceptAllCookies(){
        logger.info("Accepting all cookies");
        try{
            logger.info(BasePage.class.getName() + " Accept cookies");

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(acceptAllCookiesButton))
                    .click();
        } catch(Exception e) {
            logger.info(BasePage.class.getName() + " Cookie accept pop-up is not displayed");
            LogUtil.logStackTrace(e, logger);
        }
        return pageManager;
    }

}