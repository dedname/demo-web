package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {

    //region CONSTANTS
    public static String TEXT_MY_ACCOUNT = "My account";
    public static String TEXT_SIGN_OUT = "Sign out";
    //endregion


    //region ELEMENTS
    public SelenideElement authenticationHeader = $(By.cssSelector("h1"));
    public SelenideElement signOutButton = $(By.className("logout"));
    //endregion


    //region ACTIONS

    //endregion

}
