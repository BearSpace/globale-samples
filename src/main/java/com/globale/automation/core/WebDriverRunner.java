package com.globale.automation.core;

import com.globale.automation.utils.WebDriverFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by Dima Masis
 * Date 08/02/2017
 */
public class WebDriverRunner {

    private static final ThreadLocal<WebDriver> WEB_DRIVER = new ThreadLocal<>();

    @BeforeMethod
    public void initTestBase(ITestContext context, Method method) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANY);
        WEB_DRIVER.set(WebDriverFactory.getWebDriver(capabilities));
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            WEB_DRIVER.remove();
        }
    }

    public static WebDriver getDriver() {
        return WEB_DRIVER.get();
    }
}
