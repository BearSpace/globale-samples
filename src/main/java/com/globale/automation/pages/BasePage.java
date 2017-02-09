package com.globale.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.globale.automation.core.WebDriverRunner.getDriver;

/**
 * Created by Dima Masis
 * Date 09/02/2017
 */
public class BasePage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private static final long VISIBILITY_TIMEOUT = 10;

    public BasePage() {
        this.driver = getDriver();

        if (driver != null) {
            webDriverWait = new WebDriverWait(driver, VISIBILITY_TIMEOUT);
        }
    }

    public WebElement findElement(final By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(final By locator) {
        return driver.findElements(locator);
    }

    public void switchIframe(final String iframe) {
        driver.switchTo().frame(iframe);
    }

    public void setText(final By locator, CharSequence text) {
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    public String getValue(final By locator) {
        return findElement(locator).getAttribute("value");
    }

    public String getValueByAttribute(final By locator, String attr) {
        return findElement(locator).getAttribute(attr);
    }

    public int waitForItemsAppearance(final By locator) {
        final AtomicInteger size = new AtomicInteger(0);
        webDriverWait.until((WebDriver driver) -> {
            final int collectionSize = findElements(locator).size();
            if (collectionSize > 0) {
                size.set(collectionSize);
            }
            return collectionSize > 0;
        });
        return size.get();
    }

}
