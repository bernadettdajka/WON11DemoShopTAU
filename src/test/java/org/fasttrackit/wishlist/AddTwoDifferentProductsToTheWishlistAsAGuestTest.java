package org.fasttrackit.wishlist;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fasttrackit.DemoShopPage;
import org.fasttrackit.Footer;
import org.fasttrackit.Header;
import org.fasttrackit.Product;
import org.fasttrackit.config.BaseTestConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Products Can Be Added To The Wishlist")
@Test(suiteName = "Wishlist")

public class AddTwoDifferentProductsToTheWishlistAsAGuestTest extends BaseTestConfig {

    DemoShopPage page;

    @BeforeMethod
    public void setup() {
        this.page = new DemoShopPage();
        page.OpenDemoShopApp();
        Product metalMouse = new Product("7", "Practical Metal Mouse", "9.99");
        metalMouse.addToWishlist();
        Product gorgeousPizza = new Product("9", "Gorgeous Soft Pizza", "19.99");
        gorgeousPizza.addToWishlist();
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("Cleaning up after the test.");
        Footer footer = new Footer();
        footer.resetPage();
    }

    @Test
    @Description("Guest can add Practical Metal Mouse and Gorgeous Soft Pizza to the wishlist")
    @Severity(SeverityLevel.MINOR)
    public void adding_practical_metal_mouse_and_gorgeous_soft_pizza_to_the_wishlist_as_a_guest() {
        Header header = new Header();

        Assert.assertTrue(header.areAddedProductsInWishlist());
        Assert.assertEquals(header.getNumberOfProductsInWishlist(), "2", "2 products are added to the wishlist.");
    }
}
