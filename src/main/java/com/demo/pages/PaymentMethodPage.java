package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PaymentMethodPage {

    //region CONSTANTS
    public static String TEXT_CHOOSE_YOUR_PAYMENT_METHOD = "Please choose your payment method";
    //endregion


    //region ELEMENTS
    public SelenideElement paymentMethodHeader = $(By.cssSelector("h1"));
    public SelenideElement paymentViaBankwireButton = $(By.className("bankwire"));
    public SelenideElement paymentViaCheckButton = $(By.className("cheque"));
    //endregion


    //region ACTIONS

    //endregion

}
