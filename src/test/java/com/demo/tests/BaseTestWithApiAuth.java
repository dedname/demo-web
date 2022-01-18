package com.demo.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.demo.pages.MainPage;
import com.demo.pages.MyAccountPage;
import com.demo.utils.Constants;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.demo.pages.MyAccountPage.TEXT_MY_ACCOUNT;

public class BaseTestWithApiAuth extends BaseTest{

    MainPage mainPage = new MainPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @BeforeEach
    @Step("Auth via API")
    public void authViaApi() {

        String cookieName = "PrestaShop-a30a9934ef476d11b6cc3c983616e364";

        Response response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", Constants.defaultEmail)
                .formParam("passwd", Constants.defaultPassword)
                .formParam("SubmitLogin", "")
                .queryParam("controller", "authentication")
                .when()
                .post("http://automationpractice.com/index.php");

        System.out.println(response.prettyPrint());

//        if (response.statusCode() == 302) {
            Cookie cookie = new Cookie(cookieName, response.cookie(cookieName));

            WebDriverRunner.getWebDriver().manage().deleteCookieNamed(cookieName);
            WebDriverRunner.getWebDriver().manage().addCookie(cookie);

            openStartPage();

            mainPage.goToAccountPage.click();

            myAccountPage.authenticationHeader.shouldHave(text(TEXT_MY_ACCOUNT));

        System.out.println(response.prettyPrint());
//        }



    }

}
