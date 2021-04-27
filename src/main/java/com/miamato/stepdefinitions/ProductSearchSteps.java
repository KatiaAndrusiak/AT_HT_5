package com.miamato.stepdefinitions;

import com.miamato.PropertyManager;
import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ProductSearchSteps {

    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();

    @Given("Customer is on page with url {string}")
    public void customerIsOnPageWithUrlHomePageUrl(String pageName) {
        pageManager.open(PropertyManager.getProperty(pageName))
                .waitForPageToLoad()
                .cookiesPopUp().acceptAllCookies();
    }

    @When("Customer performs search for {string}")
    public void customer_performs_search_for(String searchTermPropertyName) {
        pageManager.searching().enterSearchTerm(PropertyManager.getProperty(searchTermPropertyName))
            .searching().initiateSearch();
    }

    @Then("Check text {string} in department field")
    public void checkTextSearch_expected_departmentInDepartmentField(String searchDepartmentName) {
        Assert.assertEquals(pageManager.searchResultPage().SEARCH_RESULTS_DEPARTMENTS_IN_LEFT_MENU.get(pageManager.searchResultPage().TARGET_DEPARTMENT_INDEX).getText(),
                PropertyManager.getProperty(searchDepartmentName));
    }

    @When("Customer selects category {string}")
    public void customerSelectsCategorySearchCategoryValue(String value) {
        pageManager.searchByCategoryPage().selectCategory(PropertyManager.getProperty(value));
    }

    @And("Search by category")
    public void searchByCategory() {
        pageManager.searching().initiateSearch();
    }


    @Then("Check if category is right {string}")
    public void checkIfCategoryIsRightSearchCategoryText(String searchCategoryText) {
        Assert.assertEquals(pageManager.searchByCategoryPage().NAVIGATION_CONTENT.getText().trim(),
                PropertyManager.getProperty(searchCategoryText).trim());
    }

    @When("Customer selects category by visible text {string}")
    public void customerSelectsCategoryByVisibleTextSearch_category_by_text(String text) {
        pageManager.searchByCategoryPage().selectCategoryByVisibleText(PropertyManager.getProperty(text));
    }
}





