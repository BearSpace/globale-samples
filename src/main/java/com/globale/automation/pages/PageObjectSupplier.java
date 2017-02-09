package com.globale.automation.pages;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import javaslang.control.Try;

import static com.globale.automation.core.WebDriverRunner.getDriver;

/**
 * Created by Dima Masis
 * Date 09/02/2017
 */
public final class PageObjectSupplier {

    public static <T> T loadPage(Class<T> pageObject) {
        return ConstructorAccess.get(pageObject).newInstance();
    }

    public static GlobaleHomePage loadSiteUrl(final String url) {
        Try.run(() -> getDriver().navigate().to(url))
                .orElseThrow((ex) -> new IllegalArgumentException("Can't navigate to specified URL", ex));
        return loadPage(GlobaleHomePage.class);
    }

    private PageObjectSupplier() {
        throw new UnsupportedOperationException("Illegal access to private constructor");
    }

}
