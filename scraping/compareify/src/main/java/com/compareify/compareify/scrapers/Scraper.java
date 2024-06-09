package com.compareify.compareify.scrapers;

import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract class representing a web scraper.
 */
public abstract class Scraper {

    /** The target URL to scrape data from. */
    private String targetUrl;

    /** The target path within the URL. */
    private String targetPath;

    /** The number of items to scrape per page. */
    private int itemsPerPage;

    /** A vector to store the scraped products. */
    private Vector<HashMap<String, Object>> scrappedProducts;

    /**
     * Constructs a Scraper with the specified URL, path, and items per page.
     *
     * @param targetUrl The target URL.
     * @param targetPath The target path within the URL.
     * @param itemsPerPage The number of items to scrape per page.
     */
    public Scraper(String targetUrl, String targetPath, int itemsPerPage) {
        this.targetUrl = targetUrl;
        this.targetPath = targetPath;
        this.itemsPerPage = itemsPerPage;
        this.scrappedProducts = new Vector<>();
    }

    /**
     * Abstract method to scrape data based on the provided product.
     *
     * @param product The product to scrape data for.
     * @return A vector of scraped products.
     */
    public abstract Vector<HashMap<String, Object>> scrape(String product);

    /**
     * Extracts product attributes from a given product title.
     *
     * @param productTitle The product title to extract attributes from.
     * @return A hashmap containing product attributes or null if attributes are not found.
     */
    public HashMap<String, String> extractProductAttributes(String productTitle) {

        Pattern capacityPattern = Pattern.compile("\\b\\(?(\\d+(?:/\\d+)*)\\s*GB\\)?\\b", Pattern.CASE_INSENSITIVE);
        Pattern colorPattern = Pattern.compile("\\b(?:black|silver|graphite|gold|white|blue|violet|red|pink|orange|yellow|green|purple|brown|cyan|magenta|midnight|starlight|pacific blue|sierra blue|space gray)(?:/(?:black|silver|graphite|gold|white|blue|violet|red|pink|orange|yellow|green|purple|brown|cyan|magenta|midnight|starlight|pacific blue|sierra blue|space gray))*\\b", Pattern.CASE_INSENSITIVE);
        Pattern brandPattern = Pattern.compile("\\b(?:Apple|Samsung|Google|OnePlus|Xiaomi|Huawei|Oppo|Vivo|Sony|Motorola|LG|HTC|Asus|Nokia|Lenovo)\\b", Pattern.CASE_INSENSITIVE);
        Pattern modelPattern = Pattern.compile("\\b(?:Galaxy S\\d+\\+?|iPhone \\d+\\s?(Pro Max|Pro|Mini)?|Pixel \\d+|OnePlus \\d+|Mi \\d+|P\\d+|Find X\\d+|X\\d+|Xperia \\d+|Moto G|V\\d+|U\\d+|ROG Phone|Nokia \\d+\\.\\d|Legion Phone)\\b", Pattern.CASE_INSENSITIVE);

        HashMap<String, String> attributes = new HashMap<>();

        Matcher capacityMatcher = capacityPattern.matcher(productTitle);
        Matcher colorMatcher = colorPattern.matcher(productTitle);
        Matcher brandMatcher = brandPattern.matcher(productTitle);
        Matcher modelMatcher = modelPattern.matcher(productTitle);

        if (capacityMatcher.find() && colorMatcher.find() && modelMatcher.find()) {
            attributes.put("capacity", capacityMatcher.group());
            attributes.put("color", colorMatcher.group());
            
            if (brandMatcher.find()){
                attributes.put("brand", brandMatcher.group());
            }else{
                String brand = this.extractProductBrand(productTitle);;
                attributes.put("brand", brand);   
            }
            
            attributes.put("model", modelMatcher.group());
            
            return attributes;
        }
        
        return null;
    }
    
    public String extractProductBrand(String productTitle) {
        if (productTitle == null || productTitle.isEmpty()) {
            return "unknown";
        }
        
        productTitle = productTitle.toLowerCase();
        
        if (productTitle.contains("iphone")) {
            return "Apple";
        } else if (productTitle.contains("galaxy") || productTitle.contains("note") || productTitle.contains("s ")) {
            return "Samsung";
        } else if (productTitle.contains("pixel")) {
            return "Google";
        } else if (productTitle.contains("mi") || productTitle.contains("redmi") || productTitle.contains("poco")) {
            return "Xiaomi";
        } else if (productTitle.contains("oneplus")) {
            return "OnePlus";
        } else if (productTitle.contains("huawei") || productTitle.contains("p ")) {
            return "Huawei";
        } else if (productTitle.contains("nokia")) {
            return "Nokia";
        } else {
            return "Unknown";
        }
        
    }

    /**
     * Adds a product to the scrapped products vector.
     *
     * @param product The product to add.
     */
    protected void addScrappedProduct(HashMap<String, Object> product) {
        scrappedProducts.add(product);
    }

    /**
     * Gets the scrapped products.
     *
     * @return A vector of scrapped products.
     */
    protected Vector<HashMap<String, Object>> getScrappedProducts() {
        return scrappedProducts;
    }

    /**
     * Gets the target URL.
     *
     * @return The target URL.
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * Gets the target path within the URL.
     *
     * @return The target path.
     */
    public String getTargetPath() {
        return targetPath;
    }

    /**
     * Gets the number of items to scrape per page.
     *
     * @return The number of items to scrape per page.
     */
    public int getItemsPerPage() {
        return itemsPerPage;
    }

}
