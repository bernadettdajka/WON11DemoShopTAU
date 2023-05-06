package org.fasttrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DemoShopPage extends Page{
    private Header header;
    private Footer footer;

    private final SelenideElement searchBar = $("#input-search");

    private final SelenideElement searchButton =$(".col-md-auto .btn-light");
    private final ElementsCollection distinctProducts = $$(".row a");

    public DemoShopPage() {
        this.header = new Header();
        this.footer = new Footer();
    }

    public Footer getFooter() {
        return footer;
    }

    public Header getHeader() {
        return header;
    }

    public void fillSearchBar(String keyword1, String keyword2) {
        this.searchBar.sendKeys(keyword1 + keyword2);
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }

    public int getDistinctProductSize() {
        return this.distinctProducts.size();
    }
}
