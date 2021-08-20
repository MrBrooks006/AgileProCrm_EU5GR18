package com.procrm.pages;

import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage{

    public CalendarPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "pagetitle")
    public WebElement subtitle;

    public void navigateCalendarHeaderMenu (String tab){
        String tabLocator = "//span[contains(text(),'"+tab+"')][@class='main-buttons-item-text-title']";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
    }
}