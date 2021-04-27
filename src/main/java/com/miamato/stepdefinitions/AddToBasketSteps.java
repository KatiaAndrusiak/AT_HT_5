package com.miamato.stepdefinitions;

import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;;
import org.junit.Assert;

public class AddToBasketSteps {
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();

    @And("Open selected product item")
    public void openSelectedItem(){
        pageManager.basketPage().openSelectedProductItem();
    }

    @And("Add item to the basket")
    public void addItemToTheBasket() {
        pageManager.basketPage().addProductToBasket();
    }

    @Then("Check if item is added to the basket")
    public void checkIfItemIsAddedToTheBasket() {
        Assert.assertEquals(pageManager.basketPage().BASKET_TOTAL_QUANTITY.getText(),
                pageManager.basketPage().TARGET_BASKET_QUANTITY_1);
    }

    @Then("Open basket")
    public void openBasket() {
        pageManager.basketPage().openBasket();
    }

    @And("Remove product from basket")
    public void removeProductFromBasket() {
        pageManager.basketPage().removeProductFromBasket();
    }

    @Then("Check if item is removed from the basket")
    public void checkIfItemIsRemovedFromTheBasket() {
        Assert.assertEquals(pageManager.basketPage().BASKET_TOTAL_QUANTITY.getText(),
                pageManager.basketPage().TARGET_BASKET_QUANTITY_0);
    }
}
