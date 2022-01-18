package com.demo.tests.smoke;

import com.demo.pages.MainPage;
import com.demo.pages.MyAccountPage;
import com.demo.pages.RegAuthPage;
import com.demo.tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.demo.pages.MyAccountPage.TEXT_SIGN_OUT;
import static com.demo.pages.RegAuthPage.TEXT_AUTHENTICATION;

public class LogOutTest extends BaseTest {

    MainPage mainPage = new MainPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    RegAuthPage regAuthPage = new RegAuthPage();

    @Test
    @DisplayName("User logout")
    public void logOutTest() {

        mainPage.logIn();

        myAccountPage.signOutButton.shouldHave(text(TEXT_SIGN_OUT));
        myAccountPage.signOutButton.click();

        regAuthPage.authenticationHeader.shouldHave(text(TEXT_AUTHENTICATION));

    }

}
