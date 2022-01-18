package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddressesPage {

    //region CONSTANTS
    public static String TEXT_ADDRESSES = "Addresses";
    //endregion


    //region ELEMENTS
    public SelenideElement addressHeader = $(By.cssSelector("h1"));
    public SelenideElement proceedToCheckoutButton = $(By.name("processAddress"));
    //endregion


    //region ACTIONS

    //endregion

}
