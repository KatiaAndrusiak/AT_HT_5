package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InvalidLoginSteps {
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();


    @When("Customer opens Sing In page")
    public void customerOpensSingInPage() {
        pageManager.loginPage().openSingInPage();
    }

    @And("Fill login field with {string}")
    public void fillLoginFieldWithLogin(String login) {
        pageManager.loginPage().enterLogin(PropertyManager.getProperty(login));
    }

    @And("Click on Continue button")
    public void clickOnContinueButton() {
        pageManager.loginPage().clickContinueButton();
    }

    @Then("Check if there is error message")
    public void checkIfThereIsErrorMessage() {
        Assert.assertTrue(pageManager.loginPage().errorMessageBox.isDisplayed());
    }
}
