package com.demo.tests.smoke;

import com.demo.pages.MainPage;
import com.demo.pages.MyAccountPage;
import com.demo.pages.RegAuthPage;
import com.demo.tests.BaseTest;
import com.demo.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.demo.pages.MainPage.TEXT_SIGN_IN;
import static com.demo.pages.MyAccountPage.TEXT_MY_ACCOUNT;
import static com.demo.pages.RegAuthPage.TEXT_AUTHENTICATION;
import static com.demo.pages.RegAuthPage.TEXT_INVALID_PASSWORD;

public class AuthTests extends BaseTest {

    MainPage mainPage = new MainPage();
    RegAuthPage regAuthPage = new RegAuthPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    @DisplayName("Log in")
    public void logInTest() {

        mainPage.logInButton.shouldHave(text(TEXT_SIGN_IN));
        mainPage.logInButton.click();

        regAuthPage.authenticationHeader.shouldHave(text(TEXT_AUTHENTICATION));
        regAuthPage.authEmailInput.setValue(Constants.defaultEmail);
        regAuthPage.authPasswordInput.setValue(Constants.defaultPassword);
        regAuthPage.signInButton.click();

        myAccountPage.authenticationHeader.shouldHave(text(TEXT_MY_ACCOUNT));

    }

    @Test
    @DisplayName("Log in with wrong password")
    public void logInWithWrongPasswordTest() {

        mainPage.logInButton.shouldHave(text(TEXT_SIGN_IN));
        mainPage.logInButton.click();

        regAuthPage.authenticationHeader.shouldHave(text(TEXT_AUTHENTICATION));
        regAuthPage.authEmailInput.setValue(Constants.defaultEmail);
        regAuthPage.authPasswordInput.setValue("123");
        regAuthPage.signInButton.click();

        regAuthPage.errorLabel.shouldHave(text(TEXT_INVALID_PASSWORD));

    }

}
