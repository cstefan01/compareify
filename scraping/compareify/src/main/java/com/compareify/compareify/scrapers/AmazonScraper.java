package com.compareify.compareify.scrapers;

import com.compareify.compareify.utils.URLFormatter;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonScraper extends Scraper{
    public AmazonScraper(String targetUrl, String targetPath, int itemsPerPage) {
        super(targetUrl, targetPath, itemsPerPage);
    }
    
    
    @Override 
    public Vector<HashMap<String, Object>> scrape(String product) {
        int itemsPerPage = super.getItemsPerPage();
        String targetUrl = super.getTargetUrl();
        String targetPath = super.getTargetPath();

        HashMap<String, String> queries = new HashMap<>();
        
        queries.put("k", product);
        
        URLFormatter urlFormatter = new URLFormatter(targetUrl, targetPath, queries);

        String formattedTargetUrl = urlFormatter.build();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("user-agent=[No commercial use] Computer Science Student - Web Scraping Coursework Task");

        WebDriver driver = new ChromeDriver(options);

        try {
            
            System.out.println(formattedTargetUrl);

            driver.get(formattedTargetUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("a-section")));
//            
//            System.out.println(products);

//            for (WebElement target_product : products) {
//
//                HashMap<String, Object> scrappedProduct = new HashMap<>();
//
//                String productTitle = target_product.findElement(By.cssSelector(".s-item__info a .s-item__title span")).getText();
//                String productPrice = target_product.findElement(By.cssSelector(".s-item__info .s-item__details .s-item__detail .s-item__price")).getText();
//                String productUrl = target_product.findElement(By.cssSelector(".s-item__info a")).getAttribute("href");
//                String productImageUrl = target_product.findElement(By.cssSelector(".s-item__image a .s-item__image-wrapper img")).getAttribute("src");
//                
//                if (!productTitle.isEmpty() && !productPrice.isEmpty() && !productUrl.isEmpty() && !productImageUrl.isEmpty()) {
//                    
//                    HashMap<String, String> matchedAttributes = super.extractProductAttributes(productTitle);
//
//                    if (matchedAttributes != null) {
//                        scrappedProduct.put("brand", matchedAttributes.get("brand"));
//                        scrappedProduct.put("model", matchedAttributes.get("model"));
//                        scrappedProduct.put("color", matchedAttributes.get("color"));
//                        scrappedProduct.put("capacity", matchedAttributes.get("capacity"));
//                        scrappedProduct.put("description", productTitle);
//                        scrappedProduct.put("url", productUrl);
//                        scrappedProduct.put("image_url", productImageUrl);
//                        scrappedProduct.put("price", productPrice);
//                        
//                        System.out.println(scrappedProduct);
//
//                        super.addScrappedProduct(scrappedProduct);
//                    }
//
//                }
//            }

            return super.getScrappedProducts();

        } finally {
            driver.quit();
            
        }

        
    }
}
