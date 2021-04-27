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

public class LoginPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class.getSimpleName());

    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
    protected WebElement SING_IN_AREA_TO_CLICK;

    @FindBy(xpath = "//input[@id=\"continue\"]")
    protected WebElement continueButton;

    @FindBy(xpath = "//input[@id=\"ap_email\"]")
    protected WebElement loginField;

    @FindBy(xpath = " //*[@id=\"auth-error-message-box\"]")
    public WebElement errorMessageBox;

    @FindBy(xpath = "//a[@id=\"createAccountSubmit\"]")
    protected WebElement createAccountButton;

    @FindAll(@FindBy(xpath = "//*[@class=\"a-alert-content\"]"))
    public List<WebElement> validationAlerts;


    public LoginPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }


    public LoginPage openSingInPage(){
        logger.info("Clicking on element " + SING_IN_AREA_TO_CLICK);
        this.clickOnElement(SING_IN_AREA_TO_CLICK, logger);
        return this;
    }

    public LoginPage enterLogin(String login){
        logger.info("Enterting invalid login: " + login);
        loginField.sendKeys(login);
        return this;
    }
    public LoginPage clickContinueButton(){
        logger.info("Click continue button");
        continueButton.click();
        return this;
    }

    public LoginPage clickCreateAccountButton(){
        logger.info("Click Create your Amazon account button");
        this.clickOnElement(createAccountButton, logger);
        return this;
    }
}
