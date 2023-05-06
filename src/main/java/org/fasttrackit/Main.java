package org.fasttrackit;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Open page and login
        DemoShopPage page = new DemoShopPage ();
        page.OpenDemoShopApp();
        String greetingsMsg = page.getHeader().getGreetingsElement();
        System.out.println("Validate that the greetings msg is: " + greetingsMsg);
        page.getHeader().clickOnTheLoginButton();
        LoginModal modal = new LoginModal();
        modal.fillInUsername("beetle");
        modal.fillInPassword("choochoo");
        modal.clickSubmitButton();
        Header header = new Header();
        String greetingsMessage = header.getGreetingsElement();
        System.out.println("Validate that the greetings msg is: " + greetingsMessage);

        System.out.println("......................................");

        //  Add a product to the Basket.
        CartPage cartDetails = new CartPage();
        Product metalMouseProduct = new Product("7", "Practical Metal Mouse", "9.99" );
        page.getHeader().clickOnTheCartIcon();
        List<Product> productInCart = cartDetails.getProductsInCart();
        System.out.println("Verify that the product practical Metal Mouse is in cart: " + productInCart.get(0).getName());
        System.out.println("Verify that the product practical Metal Mouse price is 9.99: " + cartDetails.getProductsInCart().get(0).getName());
        System.out.println("Verify that the total Price in cart is 9.99: " + cartDetails.getTotalCartCostBasedOnProducts());

//  Add 2 products to cart
        page.refresh();
        Product metalMouse2ndProduct = new Product("7", "Practical Metal Mouse", "9.99" );
        metalMouse2ndProduct.addToCart();
        Product softPizza = new Product("9","Gorgeous Soft Pizza", "19.99" );
        CartPage cart2ProductsDetails = new CartPage();
        page.getHeader().clickOnTheCartIcon();
        System.out.println("Products in cart: " + cart2ProductsDetails.getNumberOfDistinctProducts() );
    }
}




//  Add 2 different products to the Cart test.

//  1. Open application
//  2. Add Metal Mouse Product to cart.
//  3. Add Gorgeous Soft Pizza to cart.
//  4. Navigate to the cart page.
//  5. Validate that we have 2 products in cart.
//  6. Validate the sum of 2 products.

//  Add a product to the Basket.

//  1. (Click on the Basket Plus Icon on the Metal mouse product) Add Product Metal mouse to the Basket.
//  2. The Basket Icon will show one item in the basket.
//  3. (Click on the Basket Icon from the Header) Navigate to Cart page.
//  4. One Metal mouse item is added to the basket.
//  5. Metal mouse price is 9.99$
//  6. Verify total cart amount.













//  1. Open Application.
//  2. Click on the Login button.
//  3. Enter Username in the username field.
//  4. Enter password in the password field.
//  5. Click on the Login button.
//  - Validate that we logged in with the correct user.