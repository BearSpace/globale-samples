package com.globale.automation.core;

import com.globale.automation.utils.WebDriverFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by Dima Masis
 * Date 08/02/2017
 */
public class WebDriverRunner {

    private static final ThreadLocal<WebDriver> WEB_DRIVER = new ThreadLocal<>();

    /*Is Test Base initiated*/
    protected static boolean isInitiated = false;

    protected static boolean beforeClass = true;


    @BeforeMethod
    public void initTestBase(ITestContext context, Method method) {
        if (!isInitiated) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.ANY);
            WEB_DRIVER.set(WebDriverFactory.getWebDriver(capabilities));
            isInitiated = true;
        }
    }

    @AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            WEB_DRIVER.remove();
        }
        beforeClass = false;
    }

    public static WebDriver getDriver() {
        return WEB_DRIVER.get();
    }
}
