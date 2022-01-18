package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrderSummaryPage {


    //region CONSTANTS
    public static String TEXT_ORDER_SUMMARY = "Order summary";
    //endregion


    //region ELEMENTS
    public SelenideElement orderSummaryHeader = $(By.cssSelector("h1"));
    public SelenideElement confirmOrderButton = $(By.cssSelector("#cart_navigation button[type='submit']"));
    //endregion


    //region ACTIONS

    //endregion

}
