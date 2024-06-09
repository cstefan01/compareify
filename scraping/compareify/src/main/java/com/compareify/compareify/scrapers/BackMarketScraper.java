package com.compareify.compareify.scrapers;

import com.compareify.compareify.utils.URLFormatter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackMarketScraper extends Scraper {

    public BackMarketScraper(String targetUrl, String targetPath, int itemsPerPage) {
        super(targetUrl, targetPath, itemsPerPage);
    }

    @Override
    public Vector<HashMap<String, Object>> scrape(String product) {

        String targetUrl = super.getTargetUrl();
        String targetPath = super.getTargetPath();

        HashMap<String, String> queries = new HashMap<>();
        queries.put("q", product);

        URLFormatter urlFormatter = new URLFormatter(targetUrl, targetPath, queries);

        String formattedTargetUrl = urlFormatter.build();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("user-agent=[No commercial use] Computer Science Student - Web Scraping Coursework Task");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(formattedTargetUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".productCard")));

            for (WebElement targetProduct : products) {

                HashMap<String, Object> scrappedProduct = new HashMap<>();

                String productTitle = targetProduct.findElement(By.cssSelector("h2")).getText();
                String productSubTitle = targetProduct.findElement(By.cssSelector("span:nth-of-type(1)")).getText();
                String productPrice = targetProduct.findElement(By.cssSelector("span[data-qa=\"productCardPrice\"]")).getText();
                String productUrl = super.getTargetUrl() + targetProduct.findElement(By.cssSelector("a")).getAttribute("href");
                String productImageUrl = super.getTargetUrl() + targetProduct.findElement(By.cssSelector("img")).getAttribute("src");
                String productDescription = productTitle + productSubTitle;
                String productBrand = super.extractProductBrand(productTitle);

                System.out.println(productTitle);
                System.out.println(productSubTitle);
                System.out.println(productPrice);
                System.out.println(productUrl);
                System.out.println(productImageUrl);
                System.out.println(productDescription);
                System.out.println(productBrand);
                
                if (!productSubTitle.isEmpty() && !productPrice.isEmpty() && !productUrl.isEmpty() && !productImageUrl.isEmpty() && !productDescription.isEmpty()) {

                    Pattern capacityPattern = Pattern.compile("\\b\\(?(\\d+(?:/\\d+)*)\\s*GB\\)?\\b", Pattern.CASE_INSENSITIVE);
                    Pattern colorPattern = Pattern.compile("\\b(?:black|silver|graphite|gold|white|blue|violet|red|pink|orange|yellow|green|purple|brown|cyan|magenta|midnight|starlight|pacific blue|sierra blue|space gray)(?:/(?:black|silver|graphite|gold|white|blue|violet|red|pink|orange|yellow|green|purple|brown|cyan|magenta|midnight|starlight|pacific blue|sierra blue|space gray))*\\b", Pattern.CASE_INSENSITIVE);
                    Pattern modelPattern = Pattern.compile("\\b(?:Galaxy S\\d+\\+?|iPhone \\d+\\s?(Pro Max|Pro|Mini)?|Pixel \\d+|OnePlus \\d+|Mi \\d+|P\\d+|Find X\\d+|X\\d+|Xperia \\d+|Moto G|V\\d+|U\\d+|ROG Phone|Nokia \\d+\\.\\d|Legion Phone)\\b", Pattern.CASE_INSENSITIVE);
                    Pattern pricePattern = Pattern.compile("[+-]?\\d+(\\.\\d+)?");

                    Matcher capacityMatcher = capacityPattern.matcher(productSubTitle);
                    Matcher colorMatcher = colorPattern.matcher(productSubTitle);
                    Matcher modelMatcher = modelPattern.matcher(productTitle);
                    Matcher priceMatcher = pricePattern.matcher(productPrice);

                    if (capacityMatcher.find() && colorMatcher.find() && modelMatcher.find() && priceMatcher.find()) {
                        String productCapacity = capacityMatcher.group();
                        String productColor = colorMatcher.group();
                        String productModel = modelMatcher.group();

                        productPrice = priceMatcher.group();

                        scrappedProduct.put("brand", productBrand);
                        scrappedProduct.put("model", productModel);
                        scrappedProduct.put("color", productColor);
                        scrappedProduct.put("capacity", productCapacity);
                        scrappedProduct.put("description", productDescription);
                        scrappedProduct.put("url", productUrl);
                        scrappedProduct.put("image_url", productImageUrl);
                        scrappedProduct.put("price", productPrice);

                        super.addScrappedProduct(scrappedProduct);

                    }

                }

            }

            return super.getScrappedProducts();

        } finally {
            driver.quit();

        }

    }

}
