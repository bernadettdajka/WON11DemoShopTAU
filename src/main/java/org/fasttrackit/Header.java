package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {
    private SelenideElement LoginButton = $("[data-icon=sign-in-alt]");
    private SelenideElement greetingsElement = $(".navbar-text span span");
    private final SelenideElement basketIcon = $(".fa-shopping-cart");
    private SelenideElement cartBadge = $(".shopping_cart_badge");
    private ElementsCollection cartBadges = $$(".shopping_cart_badge");

    private SelenideElement wishlistIcon = $("[href='#/wishlist']");

    private SelenideElement wishlistBadge = $("[href='#/wishlist'] .shopping_cart_badge");
    private ElementsCollection wishlistBadges = $$("[href='#/wishlist'] .shopping_cart_badge");


    public String getNumberOfProductsInCart() {
        return this.cartBadge.text();
    }

    public boolean areAddedProductsInCart() {
        return cartBadges.size() > 0;
    }
    public void clickOnTheLoginButton(){
        System.out.println("Clicked on the " + LoginButton);
        LoginButton.click();
    }
    public String getGreetingsElement() {
        return greetingsElement.text();
    }
    public void clickOnTheCartIcon() {
        basketIcon.click();
    }

    public String getNumberOfProductsInWishlist() {
        return this.wishlistBadge.text();
    }

    public boolean areAddedProductsInWishlist() {
        return this.wishlistBadge.isDisplayed() && this.wishlistBadge.exists();
    }
}
