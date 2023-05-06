package org.fasttrackit.dataprovider;

import org.fasttrackit.Product;
import org.testng.annotations.DataProvider;

public class ProductDataProvider {
    @DataProvider(name = "productsDataProvider")
    public Object[][] feedProductDataProvider() {
        Product product = new Product("7", "Practical Metal Mouse", "9.99");
        Product product1 = new Product("7", "Practical Metal Mouse", "9.99");
        Product product2 = new Product("7", "Practical Metal Mouse", "9.99");
        Product product3 = new Product("7", "Practical Metal Mouse", "9.99");
        Product product4 = new Product("7", "Practical Metal Mouse", "9.99");
        Product product5 = new Product("7", "Practical Metal Mouse", "9.99");
        Product product6 = new Product("7", "Practical Metal Mouse", "9.99");
        Product product7 = new Product("7", "Practical Metal Mouse", "9.99");
        return new Object[][]{
                {product},
                {product1},
                {product2},
                {product3},
                {product4},
                {product5},
                {product6},
                {product7}
        };
    }
}
