package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChangeCurrencySteps {
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();

    @When("Open change currency page")
    public void openChangeCurrencyPage() {
        pageManager.changeCurrencyPage().openChangeCurrencyPage();
    }

    @And("Select currency {string}")
    public void selectCurrencyCurrencyValueToChange(String value) {
        pageManager.changeCurrencyPage().selectCurrency(PropertyManager.getProperty(value));
    }

    @And("Save selected currency")
    public void saveSelectedCurrency() {
        pageManager.changeCurrencyPage().saveSelectedCurrency();
    }

    @Then("Check if currency is changed")
    public void checkIfCurrencyIsChanged() {
        Assert.assertFalse( pageManager.changeCurrencyPage().CHECKING_IF_CURRENCY_IS_CHANGED.isEmpty());
    }

}
