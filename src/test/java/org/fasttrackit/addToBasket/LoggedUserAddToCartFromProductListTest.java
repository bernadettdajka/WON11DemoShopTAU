package org.fasttrackit.addToBasket;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.Footer;
import org.fasttrackit.LoginModal;
import org.fasttrackit.Product;
import org.fasttrackit.config.BaseTestConfig;
import org.fasttrackit.dataprovider.User;
import org.fasttrackit.dataprovider.UserDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Feature("Logged User Can Add To Cart From Product List")
@Test(suiteName = "Add to Cart")

public class LoggedUserAddToCartFromProductListTest extends BaseTestConfig {
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

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "validUserDataProvider")
    @Description("Logged user can add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    public void loggedUserAddProductToCart(User user) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername(user.getUsername());
        loginModal.fillInPassword(user.getPassword());
        loginModal.clickSubmitButton();

        Product metalMouse = new Product("7", "Practical Metal Mouse", "9.99");
        metalMouse.addToCart();

        boolean areProductsAdded = page.getHeader().areAddedProductsInCart();

        assertTrue(areProductsAdded, "Cart badge is displayed when products are added to cart.");

        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();

        assertEquals(numberOfProductsInCart, "1", "Logged in user adds 1 product in cart.");
        sleep(2*1000);
    }
}
