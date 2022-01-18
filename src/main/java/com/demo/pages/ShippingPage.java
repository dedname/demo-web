package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShippingPage {

    //region CONSTANTS
    public static String TEXT_SHIPPING = "Shipping";
    //endregion


    //region ELEMENTS
    public SelenideElement shippingHeader = $(By.cssSelector("h1"));
    public SelenideElement agreeWithTermsCheckbox = $(By.id("cgv"));
    public SelenideElement proceedToCheckoutButton = $(By.className("standard-checkout"));

    //endregion


    //region ACTIONS

    //endregion

}
