package com.globale.automation.testcase;

import com.globale.automation.core.WebDriverRunner;
import org.testng.annotations.Test;

import static com.globale.automation.pages.PageObjectSupplier.*;

/**
 * Created by Dima Masis
 * Date 08/02/2017
 */
public class AnnaWebSiteTest extends WebDriverRunner {

    @Test
    public void searchForAutomationInGoogle() {


        loadSiteUrl("https://google.com/ncr");


        System.out.println("hello");
    }

}
