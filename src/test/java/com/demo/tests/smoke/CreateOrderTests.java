package com.demo.tests.smoke;

import com.codeborne.selenide.Condition;

import com.demo.pages.*;
import com.demo.tests.BaseTestWithApiAuth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.demo.pages.AddressesPage.TEXT_ADDRESSES;
import static com.demo.pages.OrderConfirmationPage.TEXT_ORDER_CONFIRMATION;
import static com.demo.pages.OrderConfirmationPage.TEXT_YOUR_ORDER_IS_COMPLETE;
import static com.demo.pages.OrderSummaryPage.TEXT_ORDER_SUMMARY;
import static com.demo.pages.PaymentMethodPage.TEXT_CHOOSE_YOUR_PAYMENT_METHOD;
import static com.demo.pages.ShippingPage.TEXT_SHIPPING;
import static com.demo.pages.ShoppingCartPage.TEXT_SHOPPING_CART_SUMMARY;

public class CreateOrderTests extends BaseTestWithApiAuth {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    AddressesPage addressesPage = new AddressesPage();
    ShippingPage shippingPage = new ShippingPage();
    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
    PaymentMethodPage paymentMethodPage = new PaymentMethodPage();

    @Test
    @DisplayName("Create order with payment by bankwire")
    public void createOrderWithPaymentByBankwire() {

        mainPage.womenButton.hover();
        mainPage.blousesButton.shouldBe(Condition.visible);
        mainPage.blousesButton.click();

        catalogPage.addRandomItemToCart();
        catalogPage.proceedToCheckoutButton.click();

        shoppingCartPage.shoppingCartHeader.shouldHave(text(TEXT_SHOPPING_CART_SUMMARY));
        shoppingCartPage.proceedToCheckoutButton.click();

        addressesPage.addressHeader.shouldHave(text(TEXT_ADDRESSES));
        addressesPage.proceedToCheckoutButton.click();

        shippingPage.shippingHeader.shouldHave(text(TEXT_SHIPPING));
        shippingPage.agreeWithTermsCheckbox.click();
        shippingPage.proceedToCheckoutButton.click();

        paymentMethodPage.paymentMethodHeader.shouldHave(text(TEXT_CHOOSE_YOUR_PAYMENT_METHOD));
        paymentMethodPage.paymentViaBankwireButton.click();

        orderSummaryPage.orderSummaryHeader.shouldHave(text(TEXT_ORDER_SUMMARY));
        orderSummaryPage.confirmOrderButton.click();

        orderConfirmationPage.confirmationOrderHeader.shouldHave(text(TEXT_ORDER_CONFIRMATION));
        orderConfirmationPage.orderStatusBankwireLabel.shouldHave(text(TEXT_YOUR_ORDER_IS_COMPLETE));

    }

    @Test
    @DisplayName("Create order with payment by check")
    public void createOrderWithPaymentByCheck() {

        mainPage.womenButton.hover();
        mainPage.blousesButton.shouldBe(Condition.visible);
        mainPage.blousesButton.click();

        catalogPage.addRandomItemToCart();
        catalogPage.proceedToCheckoutButton.click();

        shoppingCartPage.shoppingCartHeader.shouldHave(text(TEXT_SHOPPING_CART_SUMMARY));
        shoppingCartPage.proceedToCheckoutButton.click();

        addressesPage.addressHeader.shouldHave(text(TEXT_ADDRESSES));
        addressesPage.proceedToCheckoutButton.click();

        shippingPage.shippingHeader.shouldHave(text(TEXT_SHIPPING));
        shippingPage.agreeWithTermsCheckbox.click();
        shippingPage.proceedToCheckoutButton.click();

        paymentMethodPage.paymentMethodHeader.shouldHave(text(TEXT_CHOOSE_YOUR_PAYMENT_METHOD));
        paymentMethodPage.paymentViaCheckButton.click();

        orderSummaryPage.orderSummaryHeader.shouldHave(text(TEXT_ORDER_SUMMARY));
        orderSummaryPage.confirmOrderButton.click();

        orderConfirmationPage.confirmationOrderHeader.shouldHave(text(TEXT_ORDER_CONFIRMATION));
        orderConfirmationPage.orderStatusCheckLabel.shouldHave(text(TEXT_YOUR_ORDER_IS_COMPLETE));

    }

}
