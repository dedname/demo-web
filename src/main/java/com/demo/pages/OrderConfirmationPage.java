package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrderConfirmationPage {

    //region CONSTANTS
    public static String TEXT_ORDER_CONFIRMATION = "Order confirmation";
    public static String TEXT_YOUR_ORDER_IS_COMPLETE = "Your order on My Store is complete.";
    //endregion


    //region ELEMENTS
    public SelenideElement confirmationOrderHeader = $(By.cssSelector("h1"));
    public SelenideElement proceedToCheckoutButton = $(By.name("processAddress"));

    public SelenideElement orderStatusBankwireLabel = $(By.cssSelector(".cheque-indent .dark"));
    public SelenideElement orderStatusCheckLabel = $(By.className("alert-success"));
    //endregion


    //region ACTIONS

    //endregion

}
