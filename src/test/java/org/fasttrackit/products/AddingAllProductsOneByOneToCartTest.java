package org.fasttrackit.products;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.LoginModal;
import org.fasttrackit.Product;
import org.fasttrackit.config.BaseTestConfig;
import org.fasttrackit.dataprovider.ProductDataProvider;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

@Feature("Verifying Products On Page")
@Test(suiteName = "Adding Products To Cart")

public class AddingAllProductsOneByOneToCartTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        page = new DemoShopPage();
        page.OpenDemoShopApp();
    }

    @AfterMethod
    public void cleanUp() {
        this.page.getFooter().resetPage();
    }

    @Test(dataProviderClass = ProductDataProvider.class, dataProvider = "productsDataProvider")
    @Description("When a guest is on the home page can add all the products one by one to the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void adding_all_products_to_the_cart(Product product) {
        product.addToCart();
        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();

        assertEquals(numberOfProductsInCart, "1", "One product in cart when adding 1 product to cart.");
    }

    @Test(dataProviderClass = ProductDataProvider.class, dataProvider = "productsDataProvider")
    @Description("When beetle user is on the home page can add all the products one by one to the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void adding_all_products_to_the_cart_logged_in_as_beetle_user(Product product) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername("beetle");
        loginModal.fillInPassword("choochoo");
        loginModal.clickSubmitButton();

        product.addToCart();
        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();

        assertEquals(numberOfProductsInCart, "1", "One product in cart when adding 1 product to cart.");
    }

    @Test(dataProviderClass = ProductDataProvider.class, dataProvider = "productsDataProvider")
    @Description("When dino user is on the home page can add all the products one by one to the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void adding_all_products_to_the_cart_logged_in_as_dino_user(Product product) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername("dino");
        loginModal.fillInPassword("choochoo");
        loginModal.clickSubmitButton();

        product.addToCart();
        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();

        assertEquals(numberOfProductsInCart, "1", "One product in cart when adding 1 product to cart.");
    }

    @Test(dataProviderClass = ProductDataProvider.class, dataProvider = "productsDataProvider")
    @Description("When turtle user is on the home page can add all the products one by one to the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void adding_all_products_to_the_cart_logged_in_as_turtle_user(Product product) {
        page.getHeader().clickOnTheLoginButton();
        LoginModal loginModal = new LoginModal();
        loginModal.fillInUsername("turtle");
        loginModal.fillInPassword("choochoo");
        loginModal.clickSubmitButton();

        product.addToCart();
        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();

        assertEquals(numberOfProductsInCart, "1", "One product in cart when adding 1 product to cart.");
    }
}
