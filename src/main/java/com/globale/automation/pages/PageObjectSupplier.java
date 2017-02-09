package com.globale.automation.pages;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import javaslang.control.Try;

import static com.globale.automation.core.WebDriverRunner.getDriver;

/**
 * Created by Dima Masis
 * Date 09/02/2017
 */
public final class PageObjectSupplier {

    public static <T> T initPage(Class<T> pageObject) {
        return ConstructorAccess.get(pageObject).newInstance();
    }

    public static GlobaleHomePage loadSiteUrl(final String url) {
        Try.run(() -> getDriver().navigate().to(url))
                .orElseThrow((ex) -> new IllegalArgumentException("Unable to navigate to specified URL", ex));
        return initPage(GlobaleHomePage.class);
    }


}
