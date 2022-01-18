package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.demo.utils.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.demo.pages.MyAccountPage.TEXT_MY_ACCOUNT;
import static com.demo.pages.RegAuthPage.TEXT_AUTHENTICATION;

public class MainPage {

    RegAuthPage regAuthPage = new RegAuthPage();
    MyAccountPage myAccountPage = new MyAccountPage();


    //region CONSTANTS
    public static String TEXT_SIGN_IN = "Sign In";
    //endregion


    //region ELEMENTS
    public SelenideElement logInButton = $(By.className("login"));
    public SelenideElement goToAccountPage = $(By.className("account"));

    public SelenideElement womenButton = $(By.xpath("//ul[contains(@class, 'menu-content')]/li[1]"));
    public SelenideElement dressesButton = $(By.xpath("//ul[contains(@class, 'menu-content')]/li[2]"));
    public SelenideElement tShirtsButton = $(By.xpath("//ul[contains(@class, 'menu-content')]/li[3]"));

    public SelenideElement blousesButton = $(By.cssSelector("a[title='Blouses']"));
    //endregion


    //region ACTIONS
    @Step("Login")
    public void logIn() {
        logInButton.shouldHave(text(TEXT_SIGN_IN));
        logInButton.click();

        regAuthPage.authenticationHeader.shouldHave(text(TEXT_AUTHENTICATION));
        regAuthPage.authEmailInput.setValue(Constants.defaultEmail);
        regAuthPage.authPasswordInput.setValue(Constants.defaultPassword);
        regAuthPage.signInButton.click();

        myAccountPage.authenticationHeader.shouldHave(text(TEXT_MY_ACCOUNT));
    }

    //endregion

}
