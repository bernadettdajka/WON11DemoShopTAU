package org.fasttrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Product {
    private final SelenideElement productCard;
    private final SelenideElement productLink;
    private final SelenideElement addToBasketButton;

    private final SelenideElement addToWishlistButton;
    private String name;
    private String price;

    public Product(String productId, String name, String price) {
        String selector = "[href='#/product/" + productId + "']"; // This also works.
        String productSelector = String.format("[href='#/product/%s']", productId);
        System.out.println(productSelector);
        this.productLink = $(productSelector);
        this.productCard = this.productLink.parent().parent();
        this.addToBasketButton = productCard.$(".fa-cart-plus");
        this.addToWishlistButton = productCard.$(".fa-heart");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getPrice(){
        return price;
    }

    public void clickOnTheProductLink()
    {
        productLink.click();
    }

    public void addToCart() {
        System.out.println("Clicked on the " + addToBasketButton + " on " + name);
        this.addToBasketButton.scrollTo();
        this.addToBasketButton.click();
    }

    public void addToWishlist() {
        this.addToWishlistButton.click();
    }
}
