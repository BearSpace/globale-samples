package com.globale.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Dima Masis
 * Date 09/02/2017
 */
public class GlobaleHomePage extends BasePage {

    private By shippingButt = By.xpath("//*[@id='shippingSwitcherLink']");
    private By contButton = By.xpath("//*[@id='globalePopupWrapper']//div[@id='globale_popup']//input");

    public GlobaleHomePage verifyWelcomeScreen() {
        waitForItemsAppearance(contButton);
        findElement(contButton).click();
        return this;
    }

    public boolean validateCountryDetails() {
        if (waitForItemsAppearance(shippingButt) == 1) {
            WebElement element = findElement(shippingButt);
            if (element.isEnabled()) {
                element.click();
                return true;
            }

        }
        return false;
    }

}
