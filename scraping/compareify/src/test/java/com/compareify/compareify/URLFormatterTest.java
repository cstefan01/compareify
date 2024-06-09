package com.compareify.compareify;

import com.compareify.compareify.utils.URLFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class URLFormatterTest {

    private URLFormatter urlFormatter;

    @BeforeEach
    void setUp() {
        urlFormatter = new URLFormatter("https://www.ebay.com", null, null);
    }

    @Test
    void testBuildWithNoPathAndQueries() {
        assertEquals("https://www.ebay.com", urlFormatter.build(), "Should build URL without path and queries");
    }

    @Test
    void testBuildWithPath() {
        String path = "/sch/i.html/";
        urlFormatter.setPath(path);
        assertEquals("https://www.ebay.com/sch/i.html/", urlFormatter.build(), "Should build URL with path");
    }

    @Test
    void testBuildWithQueries() {
        HashMap<String, String> queries = new HashMap<>();
        queries.put("_nkw", "iphone 15");
        queries.put("_from", "R40");
        queries.put("_sacat", "0");
        queries.put("_ipg", "120");
        urlFormatter.setQueries(queries);

        assertEquals("https://www.ebay.com?_from=R40&_nkw=iphone+15&_sacat=0&_ipg=120", urlFormatter.build(), "Should build URL with queries");
    }

    void testBuildWithPathAndQueries() {
        String path = "/sch/i.html/";

        HashMap<String, String> queries = new HashMap<>();
        queries.put("_nkw", "iphone 15");
        queries.put("_from", "R40");
        queries.put("_sacat", "0");
        queries.put("_ipg", "120");

        urlFormatter.setQueries(queries);
        urlFormatter.setPath(path);

        System.out.println(urlFormatter.build());
        assertEquals("https://www.ebay.com/sch/i.html/?_from=R40&_nkw=iphone+15&_sacat=0&_ipg=120", urlFormatter.build(), "Should build URL with queries");
    }

//    @Test
//    void testBuildWithInvalidURL() {
//        urlFormatter.setURL("invalid://url");
//        assertNull(urlFormatter.build(), "Should return null for invalid URL");
//    }
}
