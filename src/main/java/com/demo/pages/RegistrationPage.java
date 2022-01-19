package com.demo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demo.models.StatesEnum;
import com.demo.models.User;
import com.demo.utils.Constants;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    //region CONSTANTS
    public static String TEXT_CREATE_AN_ACCOUNT = "Create an account";
    //endregion


    //region ELEMENTS
    public SelenideElement createAnAccountHeader = $(By.cssSelector("h1"));

    public SelenideElement mrRadio = $(By.id("uniform-id_gender1"));
    public SelenideElement mrsRadio = $(By.id("uniform-id_gender2"));

    public SelenideElement firstNamePersonalInput = $(By.id("customer_firstname"));
    public SelenideElement lastNamePersonalInput = $(By.id("customer_lastname"));
    public SelenideElement emailInput = $(By.id("email"));
    public SelenideElement passwordInput = $(By.id("passwd"));

    public SelenideElement daysBdSelector = $(By.id("days"));
    public SelenideElement monthsBdSelector = $(By.id("months"));
    public SelenideElement yearsBdSelector = $(By.id("years"));

    public SelenideElement firstNameAddressInput = $(By.id("firstname"));
    public SelenideElement lastnameNameAddressInput = $(By.id("lastname"));
    public SelenideElement companyInput = $(By.id("company"));
    public SelenideElement address1Input = $(By.id("address1"));
    public SelenideElement address2Input = $(By.id("address2"));
    public SelenideElement cityInput = $(By.id("city"));
    public SelenideElement stateSelector = $(By.id("id_state"));
    public SelenideElement postcodeInput = $(By.id("postcode"));
    public SelenideElement countrySelector = $(By.id("id_country"));
    public SelenideElement additionalInformationInput = $(By.id("other"));
    public SelenideElement homePhoneInput = $(By.id("phone"));
    public SelenideElement mobilePhoneInput = $(By.id("phone_mobile"));
    public SelenideElement addressAliasInput = $(By.id("alias"));
    public SelenideElement registerButton = $(By.id("submitAccount"));

    //This is list of required text fields. Selector elements aren't here
    public List<SelenideElement> requiredRegistrationFields= List.of(
            firstNamePersonalInput,
            lastNamePersonalInput,
            emailInput,
            passwordInput,
            firstNameAddressInput,
            lastnameNameAddressInput,
            address1Input,
            cityInput,
            postcodeInput,
            mobilePhoneInput,
            addressAliasInput
    );
    //endregion


    //region ACTIONS
    public void selectBdDay(int day) {
        daysBdSelector.click();
        daysBdSelector.$(By.cssSelector(String.format("option[value='%s']", day))).click();
    }

    public void selectBdMonth(int month) {
        monthsBdSelector.click();
        monthsBdSelector.$(By.cssSelector(String.format("option[value='%s']", month))).click();
    }

    public void selectBdYear(int year) {
        yearsBdSelector.click();
        yearsBdSelector.$(By.cssSelector(String.format("option[value='%s']", year))).click();
    }

    public void selectState(StatesEnum state) {
            stateSelector.click();
            stateSelector.$(By.cssSelector(String.format("option[value='%s']", state.getKey()))).click();
    }

    public void selectCountry(String country) {
        countrySelector.click();
        countrySelector.$(By.cssSelector(String.format("option[value='%s']", country))).click();
    }

    public void fillAllRequiredFields(User user) {
        firstNamePersonalInput.setValue(user.getFirstName());
        lastNamePersonalInput.setValue(user.getLastName());
        emailInput.shouldHave(value(user.getEmail()));
        passwordInput.setValue(Constants.defaultPassword);

        firstNameAddressInput.shouldHave(value(user.getFirstName()));
        lastnameNameAddressInput.shouldHave(value(user.getLastName()));

        companyInput.setValue(user.getCompany());
        address1Input.setValue(user.getAddress());
        cityInput.setValue(user.getCity());

        selectState(user.getState());

        postcodeInput.setValue(user.getPostcode());

        selectCountry("21");

        mobilePhoneInput.setValue(user.getMobilePhone());
        addressAliasInput.setValue(user.getAlias());
    }

    //Method for checking registration if one of required field isn't set
    public void checkRegistrationWithoutRequiredFields(User user) {

        selectState(StatesEnum.NULL);
        registerButton.click();
        createAnAccountHeader.shouldHave(Condition.text(TEXT_CREATE_AN_ACCOUNT));
        selectState(user.getState());

        //All required text fields has same actions for check
        requiredRegistrationFields.forEach(e ->
                {
                    if (passwordInput.getValue().equals("")) {
                        passwordInput.setValue(Constants.defaultPassword);
                    }
                    String tmp = e.getValue();
                    e.clear();

                    registerButton.click();
                    createAnAccountHeader.shouldHave(Condition.text(TEXT_CREATE_AN_ACCOUNT));
                    e.setValue(tmp);
                }
        );

        if (passwordInput.getValue().equals("")) {
            passwordInput.setValue(Constants.defaultPassword);
        }

        selectCountry("");
        registerButton.click();
        createAnAccountHeader.shouldHave(Condition.text(TEXT_CREATE_AN_ACCOUNT));
    }
    //endregion

}
