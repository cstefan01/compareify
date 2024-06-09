package com.compareify.compareify;

import com.compareify.compareify.threads.EbayScraperThread;
import com.compareify.compareify.threads.BackMarketScraperThread;

public class Compareify {

    public static void main(String[] args) {

        String ebayTargetUrl = "https://www.ebay.com";
        String ebayTargetPath = "/sch/i.html";

        String backMarketTargetUrl = "https://www.backmarket.co.uk";
        String backMarketTargetPath = "/en-gb/search";

        String amazonTargetUrl = "https://www.amazon.co.uk";
        String amazonTargetPath = "/s";

        int itemsPerPage = 120;

        String[] targetedProducts = {"iphone 8", "iphone 12",
            "samsung galaxy s22 ultra",
            "samsung s20"};

        Thread backMarketScraperThread = new Thread(new BackMarketScraperThread(backMarketTargetUrl, backMarketTargetPath, itemsPerPage, targetedProducts));
//        Thread ebayScraperThread = new Thread(new EbayScraperThread(ebayTargetUrl, ebayTargetPath, itemsPerPage, targetedProducts));

//        ebayScraperThread.start();
        backMarketScraperThread.start();

    }

}
