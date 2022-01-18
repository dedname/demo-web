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

public class BaseTest {

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

        SelenideLogger.addListener("allure", new SelenideListener());

    }

    @BeforeEach
    @Step("Open start page")
    public void openStartPage() {
        open("/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
