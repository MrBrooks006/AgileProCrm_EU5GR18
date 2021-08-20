package com.procrm.pages;

import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

    @FindBy(id="TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_search_container")
    public WebElement square;


    @FindBy(xpath = "(//div[@class='main-ui-item-icon main-ui-square-delete'])[1]")
    public WebElement cleanSubmit;


    public TaskPage() {
        PageFactory.initElements(Driver.get(), this);
    }


//    public WebElement verifySquareButtons (String buttonTitle){
//
//        String buttonTitleLocator = "//div[@class='main-ui-filter-search main-ui-filter-theme-default']//div[contains(text(),'"+buttonTitle+"')]";
//        try {
//            BrowserUtils.waitForClickablility(By.xpath(buttonTitleLocator), 5);
//            WebElement tabElement = Driver.get().findElement(By.xpath(buttonTitleLocator));
//            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
//        } catch (Exception e) {
//            BrowserUtils.clickWithWait(By.xpath(buttonTitleLocator), 5);
//        }
//        return Driver.get().findElement(By.xpath(buttonTitleLocator));
//    }



    public void navigateTaskHeaderMenu (String tab){
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