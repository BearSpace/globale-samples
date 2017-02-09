package com.globale.automation.utils;

import javaslang.control.Try;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.globale.automation.utils.NetworkUtils.getIp;
import static java.lang.String.format;

/**
 * Created by Dima Masis
 * Date 09/02/2017
 */
public class WebDriverFactory {

    private static final String HUB_URL = "http://%s:%d/wd/hub";
    private static final long IMPLICIT_TIMEOUT = 3;
    private static final int DEFAULT_HUB_PORT = 4444;

    public static WebDriver getWebDriver(final Capabilities capabilities, final int hubPort) {
        return Try.of(() -> new RemoteWebDriver(new URL(format(HUB_URL, getIp(), hubPort)), capabilities))
                .onSuccess(driver -> driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS))
                .andThen(driver -> driver.manage().window().maximize())
                .andThen(driver -> driver.setLogLevel(Level.ALL))
                .andThen(driver -> driver.manage().deleteAllCookies())
                .orElseThrow((ex) -> new IllegalArgumentException("Failed to create Web Driver", ex));
    }

    public static WebDriver getWebDriver(final Capabilities capabilities) {
        return getWebDriver(capabilities, Optional.ofNullable(System.getProperty("hubPort"))
                .map(Integer::valueOf)
                .orElse(DEFAULT_HUB_PORT));

    }
}
