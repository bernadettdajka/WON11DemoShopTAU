package org.fasttrackit.products;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.*;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

@Feature("Practical Metal Mouse Product Can Be Added To Cart And The Price Is Added Correctly")
@Test(suiteName = "Adding Products To Cart")
public class AddPracticalMetalMouseProductToCartTest extends BaseTestConfig {
    DemoShopPage page;

    @BeforeMethod
    public void setup() {
    this.page = new DemoShopPage();
    page.OpenDemoShopApp();

    Product metalMagicMouse = new Product("7", "Practical Metal Mouse", "9.99");
    metalMagicMouse.clickOnTheProductLink();
}
    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        Footer footer = new Footer();
        footer.resetPage();
    }

    @Test
    @Description("When adding Practical Metal Mouse product in Cart, number of products in cart is one")
    @Severity(SeverityLevel.CRITICAL)
    public void add_practical_metal_mouse_product_in_cart_number_of_Products_in_cart_is_one(){
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();

        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();
        assertEquals(numberOfProductsInCart, "1", "Adding one product to cart, the cart badge is 1");
    }

    @Test
    @Description("When adding two Practical Metal Mouse products in cart, number of products in cart is two")
    public void add_two_practical_metal_mouse_products_in_cart_number_of_products_in_cart_is_two(){
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();
        detailsPage.clickOnTheAddToBasketButton();

        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();
        assertEquals(numberOfProductsInCart, "2", "Adding two products to cart, the cart badge is 2");
    }

    @Test
    @Description("When adding Practical Metal Mouse product to cart the total cost is correctly added")
    public void adding_metal_mouse_product_to_cart_total_cost_is_correctly_added() {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();

        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        double totalCardCost = cartPage.getTotalCartCostBasedOnProducts();
        double cartTotalAmount = cartPage.getCartTotalAmount();

        assertEquals(totalCardCost, 9.99, "The total products is 9.99.");
        assertEquals(cartTotalAmount, 9.99, "The cart total is 9.99.");
    }

    @Test(description = "When adding two Practical Metal Mouse products to cart the total cost is correctly added")
    @Severity(SeverityLevel.BLOCKER)
    @Description("When adding a product to cart, the total cost of the product is correctly calculated in the cart page")
    public void adding_two_metal_mouse_products_to_cart_total_cost_is_correctly_added() {
        ProductDetailsPage detailsPage = new ProductDetailsPage();
        detailsPage.clickOnTheAddToBasketButton();
        detailsPage.clickOnTheAddToBasketButton();

        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        double totalCartCost = cartPage.getTotalCartCostBasedOnProducts();
        totalCartCost = cartPage.getTotalCartCostBasedOnProducts();
        double cartTotalAmount = cartPage.getCartTotalAmount();

        assertEquals(totalCartCost, 19.98, "The total products is 19.98.");
        assertEquals(cartTotalAmount, 19.98, "The cart total is 19.98.");
    }
}
