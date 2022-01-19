package com.demo.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demo.selenide.SelenideListener;
import com.demo.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

//Base test class which sets driver params and has setUp and tearDown methods. Test which doesn't need auth in precondition extend this class
public class BaseTest {

    //Driver params are set with this method. It runs one time before all tests
    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();

        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.baseUrl = Constants.baseUrl;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;

        System.setProperty("chromeoptions.args",
                "--disable-gpu, --no-sandbox, --disable-notifications,--ignore-certificate-errors, --allow-running-insecure-content");

        //Set listener which handle Selenide actions and prettify they for allure report
        SelenideLogger.addListener("allure", new SelenideListener());

    }

    //Method opens start page before each test. Also it need for BaseTestWithApiAuth class
    @BeforeEach
    @Step("Open start page")
    public void openStartPage() {
        open("/");
    }

    //Close driver after each test
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
