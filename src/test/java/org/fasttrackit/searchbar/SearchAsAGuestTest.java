package org.fasttrackit.searchbar;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.Footer;
import org.fasttrackit.config.BaseTestConfig;
import org.fasttrackit.dataprovider.KeyWords;
import org.fasttrackit.dataprovider.SearchBarDataProvider;
import org.fasttrackit.dataprovider.UserDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Guest Can Search Using Valid Keywords Through The Searchbar")
@Test(suiteName = "Searchbar")


public class SearchAsAGuestTest extends BaseTestConfig {

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
    @Description("The guest can search using valid keywords")
    @Severity(SeverityLevel.NORMAL)
    public void search_as_a_guest_test(KeyWords keyWords) {
        DemoShopPage page = new DemoShopPage();
        page.fillSearchBar(keyWords.getKeyword1(), keyWords.getKeyword2());
        page.clickSearchButton();
        Selenide.sleep(2*1000);

        Assert.assertEquals(page.getDistinctProductSize(),1);
    }
}
