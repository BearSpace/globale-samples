package com.globale.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Dima Masis
 * Date 09/02/2017
 */
public class GlobaleHomePage extends BasePage {

    //private By shippingCountry = By.id("shippingSwitcherLink");
    private By shippingButt = By.cssSelector("#shippingSwitcherLink");

    private By contButton = By.xpath("//*[@id='globalePopupWrapper']//div[@id='globale_popup']//input");

    public GlobaleHomePage verifyWelcomeScreen() {
        waitForItemsAppearance(contButton);
        findElement(contButton).click();
        return this;
    }

    public boolean validateCountryDetails() {
        waitForItemsAppearance(shippingButt);
        WebElement element = findElement(shippingButt);
        element.click();
        System.out.println("done");
        return false;
    }


}
