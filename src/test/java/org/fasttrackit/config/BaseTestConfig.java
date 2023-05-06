package org.fasttrackit.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseTestConfig {

    @BeforeTest
    public void setupConfig() {
        Configuration.browser = "Chrome";
        //Configuration.browserSize = "1080x2340";//
        Configuration.headless = true;
        //Configuration.screenshots = true;//

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterClass
    public void closeBrowser() {
        Selenide.closeWindow();
    }
}
