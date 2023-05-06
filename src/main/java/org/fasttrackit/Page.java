package org.fasttrackit;

import static com.codeborne.selenide.Selenide.*;

public class Page {
    public Page() {
        System.out.println("Opened a new page. ");
    }
    public void OpenDemoShopApp(){
        String demoShopUrl = "https://fasttrackit-test.netlify.app/#/";
        System.out.println("Opening: " + demoShopUrl);
        open(demoShopUrl);
        sleep(5 * 1000);
    }
    public void refresh(){
        System.out.println("Refreshing the page.");
    }
}
