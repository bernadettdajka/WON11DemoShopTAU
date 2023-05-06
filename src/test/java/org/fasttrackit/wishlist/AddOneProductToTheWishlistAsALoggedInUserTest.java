package org.fasttrackit.wishlist;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.fasttrackit.dataprovider.User;
import org.fasttrackit.dataprovider.UserDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Feature("One Product Can Be Added To The Wishlist")
@Test(suiteName = "Wishlist")

public class AddOneProductToTheWishlistAsALoggedInUserTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        page = new DemoShopPage();
        page.OpenDemoShopApp();
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        page.OpenDemoShopApp();
        Footer footer = new Footer();
        footer.resetPage();
    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "validUserDataProvider")
    @Description("When the user is logged in can add one product to the wishlist")
    @Severity(SeverityLevel.NORMAL)
    public void addOneProductToTheWishlistAsALoggedInUser(User user) {
        Header header = new Header();
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername(user.getUsername());
        loginModal.fillInPassword(user.getPassword());
        loginModal.clickSubmitButton();

        Product metalMouse = new Product("7", "Practical Metal Mouse", "9.99");
        metalMouse.addToWishlist();

        Selenide.sleep(2000);

        Assert.assertTrue(header.areAddedProductsInWishlist());
        Assert.assertEquals(header.getNumberOfProductsInWishlist(), "1", "1 product is added to the wishlist.");
    }
}