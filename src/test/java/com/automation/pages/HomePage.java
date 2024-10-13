package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;
    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;
    @FindBy(id = "react-burger-menu-btn")
    WebElement hamBurgerMenu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;
    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    List<WebElement> listOfProductName;
    @FindBy(className = "product_sort_container")
    WebElement filterSelectBtn;
    @FindBy(xpath = "//button[contains(@id,'remove-sauce-')]")
    List<WebElement> listOfRemoveBtn;
    @FindBy(className = "inventory_item_price")
    List<WebElement> listOfPrice;


    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public String getCartIconQty() {
        return shoppingCartLink.findElement(By.xpath("./span")).getText();
    }

    public void clickOnHamburgerMenu() {
        hamBurgerMenu.click();
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    public List<String> givesListOfProducts() {
        List<String> product = new ArrayList<>();
        for (int i = 0; i < listOfProductName.size(); i++) {
            product.add(listOfProductName.get(i).getText());
        }
        return product;
    }

    public void clickOnFilterOptions(String value) {
        Select selectElement = new Select(filterSelectBtn);
        selectElement.selectByValue(value);
    }

    public List<Double> givesListOfPrices() {
        List<Double> price = new ArrayList<>();
        for (int i = 0; i < listOfPrice.size(); i++) {
            price.add(Double.parseDouble(listOfPrice.get(i).getText().replace("$", "")));
        }
        return price;
    }

    public void clickOnAddToCartBtn() {
        for (WebElement button : addToCartBtnList) {
            button.click();
        }
    }

    public int givesNoOfRemoveButton(){
        return listOfRemoveBtn.size();
    }
}
