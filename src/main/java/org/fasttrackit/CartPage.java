package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage extends Page {
    private final String Currency = "$";
    private List<Product> productsInCart = new ArrayList<>();
    private String cartName = "Rami";
    private final ElementsCollection distinctProducts = $$(".row a");
    private final SelenideElement cartTotalAmount = $(".amount-total .amount");

    public int getNumberOfDistinctProducts(){
        return distinctProducts.size();
    }
    public int getTotalProductsInCart() {
        int totalProducts = 0;
        for (SelenideElement product : distinctProducts) {
            SelenideElement row = product.parent().parent();
            SelenideElement div = row.$("div");
            String numberOfProductsFromType = div.text();
            totalProducts += Integer.parseInt(numberOfProductsFromType);
        }
        return totalProducts;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public double getTotalCartCostBasedOnProducts() {
        double totalCartCost = 0.0;
        for (SelenideElement product : distinctProducts) {
            SelenideElement row = product.parent().parent();

            String productPrice = row.$(".col-md-auto", 1).text().replace(Currency, "");
            double pricePerProduct = Double.parseDouble(productPrice);

            String numberOfProductsFromType = row.$("div").text().replace(Currency, "");
            double productsFromType = Double.parseDouble(numberOfProductsFromType);

            totalCartCost += (productsFromType * pricePerProduct);
        }
        NumberFormat Format = new DecimalFormat("#0.00");
        return Double.parseDouble(Format.format(totalCartCost));
    }

    public double getCartTotalAmount() {
        String totalWithoutCurrency = cartTotalAmount.text().replace(Currency, "");
        return Double.parseDouble(totalWithoutCurrency);
    }
}
