package org.fasttrackit.login;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.Header;
import org.fasttrackit.LoginModal;
import org.fasttrackit.config.BaseTestConfig;
import org.fasttrackit.dataprovider.User;
import org.fasttrackit.dataprovider.UserDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.*;

@Feature("Login With Valid And Invalid Credentials")
@Test(suiteName = "Login")

public class LoginTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        this.page = new DemoShopPage();
        page.OpenDemoShopApp();
    }

    @AfterMethod
    public void reset() {
        Selenide.refresh();
        page.getFooter().resetPage();
    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "validUserDataProvider")
    @Description("User Can Login On Demoshop Page With Valid Credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void userCanLoginOnDemoshopPage(User user) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername(user.getUsername());
        loginModal.fillInPassword(user.getPassword());
        loginModal.clickSubmitButton();

        assertEquals(page.getHeader().getGreetingsElement(), user.getExpectedGreetingsMsg(), "The greeting message is: " + user.getExpectedGreetingsMsg());
    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "invalidUserDataProvider")
    @Description("User Can Not Login On Demoshop Page With Invalid User")
    public void userCanNotLoginOnDemoshopPageWithInvalidUser(User user) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername(user.getUsername());
        loginModal.fillInPassword(user.getPassword());
        loginModal.clickSubmitButton();

        assertTrue(loginModal.isDisplayed());
        assertTrue(loginModal.isErrorMsgDisplayed(), "Login error message is displayed.");
        assertEquals(loginModal.getErrorMsg(), user.getErrorMsg());
        assertEquals(page.getHeader().getGreetingsElement(), user.getDefaultGreetingsMgs(), "The greeting message is: Hello guest!");
    }

   // @Test
    public void userCanLoginOnDemoshopPageWithDinoUser() {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername("dino");
        loginModal.fillInPassword("choochoo");
        loginModal.clickSubmitButton();

        assertEquals(page.getHeader().getGreetingsElement(), "Hi dino!", "The greeting message is: Hi dino!");
    }//
}
