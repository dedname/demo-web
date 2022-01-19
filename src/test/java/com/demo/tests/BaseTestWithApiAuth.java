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

//This class extends from BaseTest. It need open URL previously for manage cookie. Test which need auth in precondition extend this class
public class BaseTestWithApiAuth extends BaseTest {

    //Creating objects
    MainPage mainPage = new MainPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    //Base test for auth via API. It's used as precondition for test which need auth previous. It's faster than auth via WEB. This method run before each test in class which extends it
    @BeforeEach
    @Step("Auth via API")
    public void authViaApi() {

        //Set cookie name variable
        String cookieName = "PrestaShop-a30a9934ef476d11b6cc3c983616e364";

        //Getting response from API auth method
        Response response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", Constants.defaultEmail)
                .formParam("passwd", Constants.defaultPassword)
                .formParam("SubmitLogin", "")
                .queryParam("controller", "authentication")
                .when()
                .post("http://automationpractice.com/index.php");

        //Get cookie from response
        Cookie cookie = new Cookie(cookieName, response.cookie(cookieName));

        //Delete cookie before setting otherwise there will be two same cookie
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed(cookieName);

        //Set cookie
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        //Go to start page and check that auth is ok
        openStartPage();
        mainPage.goToAccountPage.click();
        myAccountPage.authenticationHeader.shouldHave(text(TEXT_MY_ACCOUNT));

    }

}
