package org.fasttrackit.searchbar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.Footer;
import org.fasttrackit.LoginModal;
import org.fasttrackit.config.BaseTestConfig;
import org.fasttrackit.dataprovider.KeyWords;
import org.fasttrackit.dataprovider.SearchBarDataProvider;
import org.fasttrackit.dataprovider.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Logged In User Can Search With Valid Keywords Using The Searchbar")
@Test(suiteName = "Searchbar")

public class SearchAsALoggedInUserTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        this.page = new DemoShopPage();
        page.OpenDemoShopApp();
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        Footer footer = new Footer();
        footer.resetPage();
    }

    @Test(dataProviderClass = SearchBarDataProvider.class, dataProvider = "searchBarDataProvider")
    @Description("When the beetle user is logged in can make search using valid keywords")
    @Severity(SeverityLevel.NORMAL)
    public void search_as_beetle_user_test(KeyWords keyWords) {
        this.page = new DemoShopPage();
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername("beetle");
        loginModal.fillInPassword("choochoo");
        loginModal.clickSubmitButton();

        Selenide.sleep(1000);

        page.fillSearchBar(keyWords.getKeyword1(), keyWords.getKeyword2());
        page.clickSearchButton();

        Assert.assertEquals(page.getDistinctProductSize(),1);
    }

    @Test(dataProviderClass = SearchBarDataProvider.class, dataProvider = "searchBarDataProvider")
    @Description("When the dino user is logged in can make search using valid keywords")
    public void search_as_dino_user_test(KeyWords keyWords) {
        DemoShopPage page = new DemoShopPage();
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername("dino");
        loginModal.fillInPassword("choochoo");
        loginModal.clickSubmitButton();

        Selenide.sleep(1000);

        page.fillSearchBar(keyWords.getKeyword1(), keyWords.getKeyword2());
        page.clickSearchButton();

        Assert.assertEquals(page.getDistinctProductSize(),1);
    }

    @Test(dataProviderClass = SearchBarDataProvider.class, dataProvider = "searchBarDataProvider")
    @Description("When turtle user is logged in can make search using valid keywords")
    public void search_as_turtle_user_test(KeyWords keyWords) {
        DemoShopPage page = new DemoShopPage();
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername("turtle");
        loginModal.fillInPassword("choochoo");
        loginModal.clickSubmitButton();

        Selenide.sleep(1000);

        page.fillSearchBar(keyWords.getKeyword1(), keyWords.getKeyword2());
        page.clickSearchButton();


        Assert.assertEquals(page.getDistinctProductSize(),1);
    }
}
