package com.compareify.compareify.utils;

import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for formatting URLs with optional path and query parameters.
 */
public class URLFormatter {

    private String url;
    private String path;
    private HashMap<String, String> queries;

    /**
     * Constructor for URLFormatter.
     * @param url The base URL.
     * @param path The path to append to the base URL (optional, can be null).
     * @param queries The query parameters as key-value pairs (optional, can be null).
     */
    public URLFormatter(String url, String path, HashMap<String, String> queries) {
        this.url = url;
        this.path = path;
        this.queries = queries;
    }

    /**
     * Builds the formatted URL.
     * @return The formatted URL as a String, or null if an error occurs.
     */
    public String build() {
        try {
            URIBuilder uriBuilder = new URIBuilder(url);

            if (path != null) {
                uriBuilder.setPath(path);
            }

            if (queries != null) {
                for (Map.Entry<String, String> entry : queries.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            }

            return uriBuilder.build().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Sets the base URL.
     * @param url The base URL.
     */
    public void setURL(String url) {
        this.url = url;
    }

    /**
     * Sets the path.
     * @param path The path to append to the base URL (optional, can be null).
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets the query parameters.
     * @param queries The query parameters as key-value pairs (optional, can be null).
     */
    public void setQueries(HashMap<String, String> queries) {
        this.queries = queries;
    }
}
