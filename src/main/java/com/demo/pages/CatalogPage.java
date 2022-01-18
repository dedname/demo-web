package com.demo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {

    //region CONSTANTS

    //endregion


    //region ELEMENTS
    public SelenideElement categoryNameHeader = $(By.cssSelector("h1"));
    public SelenideElement categoryNameLabel = $(By.className("category-name"));

    public ElementsCollection productList = $$(By.cssSelector(".product_list > li"));
    public SelenideElement proceedToCheckoutButton = $(By.cssSelector(".layer_cart_cart .button-container > a"));
    //endregion


    //region ACTIONS
    public void addRandomItemToCart() {
        int randomItemNumber = (int) (Math.random() * productList.size());
        productList.get(randomItemNumber).hover();
        productList.get(randomItemNumber).$(By.className("button-container")).click();
    }

    public void addItemFromListToCart(SelenideElement item) {
        item.$(By.className("button-container")).click();
    }
    //endregion




}
