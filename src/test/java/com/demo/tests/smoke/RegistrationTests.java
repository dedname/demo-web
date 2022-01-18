package com.demo.tests.smoke;

import com.demo.models.User;
import com.demo.pages.MainPage;
import com.demo.pages.MyAccountPage;
import com.demo.pages.RegAuthPage;
import com.demo.pages.RegistrationPage;
import com.demo.tests.BaseTest;
import com.demo.utils.Constants;
import com.demo.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.demo.pages.MainPage.TEXT_SIGN_IN;
import static com.demo.pages.MyAccountPage.TEXT_MY_ACCOUNT;
import static com.demo.pages.RegAuthPage.TEXT_AUTHENTICATION;
import static com.demo.pages.RegistrationPage.TEXT_CREATE_AN_ACCOUNT;

public class RegistrationTests extends BaseTest {

    MainPage mainPage = new MainPage();
    RegAuthPage regAuthPage = new RegAuthPage();
    RegistrationPage registrationPage = new RegistrationPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    Utils utils = new Utils();

    @Test
    @DisplayName("Register new user")
    public void registerNewUserTest() {

        User user = utils.generateNewUser();

        mainPage.logInButton.shouldHave(text(TEXT_SIGN_IN));
        mainPage.logInButton.click();

        regAuthPage.authenticationHeader.shouldHave(text(TEXT_AUTHENTICATION));
        regAuthPage.registrationEmailInput.setValue(user.getEmail());
        regAuthPage.createAnAccountButton.click();

        registrationPage.createAnAccountHeader.shouldHave(text(TEXT_CREATE_AN_ACCOUNT));
        registrationPage.mrRadio.click();
        registrationPage.firstNamePersonalInput.setValue(user.getFirstName());
        registrationPage.lastNamePersonalInput.setValue(user.getLastName());
        registrationPage.emailInput.shouldHave(value(user.getEmail()));
        registrationPage.passwordInput.setValue(Constants.defaultPassword);

        registrationPage.selectBdDay(user.getBdDay());
        registrationPage.selectBdMonth(user.getBdMonth());
        registrationPage.selectBdYear(user.getBdYear());

        registrationPage.firstNameAddressInput.shouldHave(value(user.getFirstName()));
        registrationPage.lastnameNameAddressInput.shouldHave(value(user.getLastName()));

        registrationPage.companyInput.setValue(user.getCompany());
        registrationPage.address1Input.setValue(user.getAddress());
        registrationPage.cityInput.setValue(user.getCity());

        registrationPage.selectState(user.getState());

        registrationPage.postcodeInput.setValue(user.getPostcode());

        //TODO: should create enum for country?
        registrationPage.selectCountry("21");

        registrationPage.additionalInformationInput.setValue(user.getAdditionalInformation());
        registrationPage.homePhoneInput.setValue(user.getHomePhone());
        registrationPage.mobilePhoneInput.setValue(user.getMobilePhone());
        registrationPage.addressAliasInput.setValue(user.getAlias());

        registrationPage.registerButton.click();

        myAccountPage.authenticationHeader.shouldHave(text(TEXT_MY_ACCOUNT));

    }

    @Test
    @DisplayName("Register new user without required fields")
    public void registerNewUserWithoutRequiredFieldsTest() {

        User user = utils.generateNewUser();

        mainPage.logInButton.shouldHave(text(TEXT_SIGN_IN));
        mainPage.logInButton.click();

        regAuthPage.authenticationHeader.shouldHave(text(TEXT_AUTHENTICATION));
        regAuthPage.registrationEmailInput.setValue(user.getEmail());
        regAuthPage.createAnAccountButton.click();

        regAuthPage.authenticationHeader.shouldHave(text(TEXT_AUTHENTICATION));

        registrationPage.fillAllRequiredFields(user);

        registrationPage.checkRegistrationWithoutRequiredFields(user);

    }

}
