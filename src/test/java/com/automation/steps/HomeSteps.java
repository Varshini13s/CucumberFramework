package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user click on add to cart button of the first item")
    public void user_click_on_add_to_cart_button_of_the_first_item() {
        homePage.clickOnAddToCartOfFirstItem();
    }

    @Then("verify cart icon displays quantity one")
    public void verify_cart_icon_displays_quantity_one() {
        Assert.assertEquals(homePage.getCartIconQty(),"1");
    }

    @When("user click on cart icon")
    public void user_click_on_cart_icon() {
        homePage.clickOnShoppingCartLink();
    }

    @When("user clicks on A to Z sort button")
    public void userClicksOnAToZSortButton() {
        homePage.clickOnFilterOptions(ConfigReader.getConfigValue("filter.productsZtoA"));
    }

    @Then("verify products are sorted by Z to A")
    public void verifyProductsAreSortedByZToA() {
        List<String> actualResult = homePage.givesListOfProducts();
        List<String> expectedResult = new ArrayList<>(actualResult);
        expectedResult.sort(Collections.reverseOrder());
        Assert.assertEquals(actualResult,expectedResult);
    }

    @When("user clicks on high to low sort button")
    public void userClicksOnHighToLowSortButton() {
        homePage.clickOnFilterOptions(ConfigReader.getConfigValue("filter.priceHighToLow"));
    }

    @Then("verify products are sorted from high to low price")
    public void verifyProductsAreSortedFromHighToLowPrice() {
        List<Double> actualResult = homePage.givesListOfPrices();
        List<Double> expectedResult = new ArrayList<>(actualResult);
        expectedResult.sort(Collections.reverseOrder());
        Assert.assertEquals(actualResult,expectedResult);
    }

    @When("user click on all the items to cart")
    public void userClickOnAllTheItemsToCart() {
        homePage.clickOnAddToCartBtn();
    }

    @Then("verify cart icon quantity is equal to number of items user added")
    public void verifyCartIconQuantityIsEqualToNumberOfItemsUserAdded() {
        Assert.assertEquals(homePage.getCartIconQty(),"6");
    }

    @And("verify remove button is not present")
    public void verifyRemoveButtonIsNotPresent() {
        Assert.assertEquals(homePage.givesNoOfRemoveButton(),0);
    }
}
