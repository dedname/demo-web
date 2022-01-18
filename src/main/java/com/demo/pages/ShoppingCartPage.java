package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {

    //region CONSTANTS
    public static String TEXT_SHOPPING_CART_SUMMARY= "Shopping-cart summary";
    //endregion


    //region ELEMENTS
    public SelenideElement shoppingCartHeader = $(By.cssSelector("h1"));
    public SelenideElement proceedToCheckoutButton = $(By.className("standard-checkout"));
    //endregion


    //region ACTIONS

    //endregion

}
