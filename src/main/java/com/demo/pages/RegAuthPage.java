package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegAuthPage {

    //region CONSTANTS
    public static String TEXT_AUTHENTICATION = "Authentication";
    public static String TEXT_INVALID_PASSWORD = "Invalid password.";
    //endregion


    //region ELEMENTS
    public SelenideElement authenticationHeader = $(By.cssSelector("h1"));

    public SelenideElement registrationEmailInput = $(By.id("email_create"));
    public SelenideElement createAnAccountButton = $(By.id("SubmitCreate"));

    public SelenideElement authEmailInput = $(By.id("email"));
    public SelenideElement authPasswordInput = $(By.id("passwd"));
    public SelenideElement signInButton = $(By.id("SubmitLogin"));

    public SelenideElement errorLabel = $(By.cssSelector("div.alert-danger li"));
    //endregion


    //region ACTIONS

    //endregion

}
