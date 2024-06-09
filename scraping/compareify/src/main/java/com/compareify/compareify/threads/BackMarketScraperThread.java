package com.compareify.compareify.threads;

import com.compareify.compareify.models.Comparison;
import com.compareify.compareify.models.Phone;
import com.compareify.compareify.models.PhoneModel;
import com.compareify.compareify.scrapers.BackMarketScraper;
import com.compareify.compareify.utils.HibernateUtil;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Vector;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BackMarketScraperThread implements Runnable {

    private String target_url;
    private String target_path;
    private int items_per_page;
    private String[] targeted_products;

    public BackMarketScraperThread() {
    }

    public BackMarketScraperThread(String target_url, String target_path, int items_per_page, String[] targeted_products) {
        this.target_url = target_url;
        this.target_path = target_path;
        this.items_per_page = items_per_page;
        this.targeted_products = targeted_products;
    }

    @Override
    public void run() {
        Vector<HashMap<String, Object>> scraped_products;

        BackMarketScraper backMarketScraper = new BackMarketScraper(target_url, target_path, items_per_page);

        for (String targetedProduct : targeted_products) {
            scraped_products = backMarketScraper.scrape(targetedProduct);

            Session session = HibernateUtil.getSessionFactory().openSession();

            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                for (HashMap<String, Object> product : scraped_products) {

                    PhoneModel phoneModel = new PhoneModel();
                    phoneModel.setModel(product.get("model").toString());
                    phoneModel.setBrand(product.get("brand").toString().toUpperCase());
                    phoneModel.setDescription(product.get("description").toString());
                    phoneModel.setImageUrl(product.get("image_url").toString());

                    Phone phone = new Phone();
                    phone.setColor(product.get("color").toString().toUpperCase());
                    phone.setCapacity(product.get("capacity").toString());
                    phone.setPhoneModel(phoneModel);

                    Comparison comparison = new Comparison();

                    comparison.setPhone(phone);

                    NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

                    Number price = numberFormat.parse(product.get("price").toString());

                    double productPrice = price.doubleValue();

                    comparison.setPrice(productPrice);

                    comparison.setUrl(product.get("url").toString());

                    comparison.setThirdParty("back market");

                    session.persist(phoneModel);
                    session.persist(phone);
                    session.persist(comparison);
                }

                transaction.commit();

            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }

        }

    }

}
