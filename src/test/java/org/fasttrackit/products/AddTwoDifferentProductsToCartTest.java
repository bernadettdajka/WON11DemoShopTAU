package org.fasttrackit.products;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.CartPage;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.Footer;
import org.fasttrackit.Product;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.annotations.*;

import static org.testng.Assert.*;

@Feature("Two Different Products Can Be Added To Cart")
@Test(suiteName = "Adding Products To Cart")

public class AddTwoDifferentProductsToCartTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        page = new DemoShopPage();
        page.OpenDemoShopApp();
        Product metalMouse = new Product("7", "Practical Metal Mouse", "9.99");
        metalMouse.addToCart();
        Product gorgeousPizza = new Product("9", "Gorgeous Pizza", "19.99");
        gorgeousPizza.addToCart();
    }

//    @BeforeMethod
//    public void prerequisites() {
//        Product metalMouse = new Product("7", "Practical Metal Mouse", "9.99");
//        metalMouse.addToCart();
//        Product gorgeousPizza = new Product("9", "Gorgeous Pizza", "19.99");
//        gorgeousPizza.addToCart();
//    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        page.OpenDemoShopApp();
        Footer footer = new Footer();
        footer.resetPage();
    }

    @Test
    @Description("When adding Practical Metal Mouse and Gorgeous Soft Pizza to cart there are two products in cart")
    @Severity(SeverityLevel.BLOCKER)
    public void adding_metal_mouse_and_gorgeous_pizza_to_cart_two_products_are_in_cart() {
        String numberOfProductsInCart = page.getHeader().getNumberOfProductsInCart();

        assertEquals(numberOfProductsInCart, "2", "Adding 2 different products in cart.");
    }

    @Test
    @Description("When adding Practical Metal Mouse and Gorgeous Soft Pizza to cart and navigating to the cart page there are two products in cart")
    public void adding_metal_mouse_and_gorgeous_pizza_to_cart_navigating_to_cart_page_there_are_two_products_in_cart() {
        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        int numberOfDistinctProducts = cartPage.getNumberOfDistinctProducts();
        int totalProductsInCart = cartPage.getTotalProductsInCart();

        assertEquals(numberOfDistinctProducts, 2, "Adding two different products to cart");
        assertEquals(totalProductsInCart, 2, "Total products in cart are two");
    }

    @Test
    @Description("When adding Practical Metal Mouse and Gorgeous Soft Pizza Products to cart the total cost is correcty added")
    public void adding_metal_mouse_and_gorgeous_pizza_products_to_cart_total_cost_is_correctly_added() {
        page.getHeader().clickOnTheCartIcon();
        CartPage cartPage = new CartPage();
        double totalCardCost = cartPage.getTotalCartCostBasedOnProducts();
        double cartTotalAmount = cartPage.getCartTotalAmount();

        assertEquals(totalCardCost, 29.98, "The total products is 29.98.");
        assertEquals(cartTotalAmount, 29.98, "The cart total is 29.98.");
    }
}
