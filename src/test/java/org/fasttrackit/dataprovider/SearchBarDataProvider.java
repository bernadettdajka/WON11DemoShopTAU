package org.fasttrackit.dataprovider;

import org.fasttrackit.Product;
import org.testng.annotations.DataProvider;

public class SearchBarDataProvider {
    @DataProvider(name = "searchBarDataProvider")

    public Object[][] feedSearchBarDataProvider() {
    KeyWords keyWords1 = new KeyWords("Awesome ", "Metal");
    KeyWords keyWords2 = new KeyWords("Incredible ", "Concrete");
    KeyWords keyWords3 = new KeyWords("Awesome ", "Granit");
    KeyWords keyWords4 = new KeyWords("Awesome ", "Soft");
    KeyWords keyWords5 = new KeyWords("Gorgeous ", "Soft");
    KeyWords keyWords6 = new KeyWords("Licensed ", "Steel");
    KeyWords keyWords7 = new KeyWords("Practical ", "Metal");
    KeyWords keyWords8 = new KeyWords("Refined ", "Frozen");
    return new Object[][]{
            {keyWords1},
            {keyWords2},
            {keyWords3},
            {keyWords4},
            {keyWords5},
            {keyWords6},
            {keyWords7},
            {keyWords8}
    };
}
}
