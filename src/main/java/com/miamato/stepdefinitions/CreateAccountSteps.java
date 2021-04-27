package com.miamato.stepdefinitions;

import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CreateAccountSteps {
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();


    @And("Open Create your Amazon account page")
    public void openCreateYourAmazonAccountPage() {
        pageManager.loginPage().clickCreateAccountButton();
    }

    @And("Click Create your Amazon account button")
    public void clickCreateYourAmazonAccountButton() {
        pageManager.loginPage().clickContinueButton();
    }

    @Then("Check if there is validation of fields")
    public void checkIfThereIsValidationOfFields() {
        Assert.assertFalse(pageManager.loginPage().validationAlerts.isEmpty());
    }
}
