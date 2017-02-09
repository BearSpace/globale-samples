package com.globale.automation.testcase;

import com.globale.automation.core.WebDriverRunner;
import com.globale.automation.pages.GlobaleHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.globale.automation.pages.PageObjectSupplier.loadSiteUrl;
import static java.lang.String.format;

/**
 * Created by Dima Masis
 * Date 08/02/2017
 */
public class AnnaWebSiteTest extends WebDriverRunner {

    private static final Logger log = LoggerFactory.getLogger(AnnaWebSiteTest.class);

    private static final String URL = "anna.bglobale.de";

    private static final String USERNAME = "globale";
    private static final String PASSWORD = "globalelocal";

    private GlobaleHomePage globaleHomePage;

    @BeforeMethod
    public void init() {
        if (beforeClass) {
            try {
                globaleHomePage = loadSiteUrl(format("http://%s:%s@%s", USERNAME, PASSWORD, URL)).verifyWelcomeScreen();
            } catch (Exception ex) {
                log.error("Failed to load URL.");
                Assert.fail("Failed ");
            } finally {
                beforeClass = false;
            }
        }
    }

    @Test(priority = 1)
    public void loginToWebClient() {
        Assert.assertNotNull(globaleHomePage, "Page loaded successfully.");
    }

    @Test(priority = 2)
    public void verifyShippingPopup() throws InterruptedException {
        Thread.sleep(4000);
        boolean validateCountryDetails = globaleHomePage.validateCountryDetails();
        Assert.assertTrue(validateCountryDetails, "Failed.");
    }
}
