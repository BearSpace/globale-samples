package com.globale.automation.testcase;

import com.globale.automation.core.WebDriverRunner;
import com.globale.automation.pages.GlobaleHomePage;
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
                ex.printStackTrace();
            } finally {
                beforeClass = false;
            }
        }
    }

    @Test
    public void loginToWebClient() {
        Assert.assertNotNull(globaleHomePage, "Page loaded successfully.");
    }


    @Test
    public void verifyShippingPopup() {
        globaleHomePage.validateCountryDetails();
    }
}
