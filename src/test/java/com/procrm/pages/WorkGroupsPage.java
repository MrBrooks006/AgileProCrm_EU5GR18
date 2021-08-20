package com.procrm.pages;

import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkGroupsPage extends BasePage{

    public WorkGroupsPage(){
        PageFactory.initElements(Driver.get(), this);
    }



    public WebElement groupElement(String groupType){
        String groupLocator = "(//span/span/a[.='" + groupType + "'])[1]";
        return Driver.get().findElement(By.xpath(groupLocator));
    }

    @FindBy(css = ".profile-menu-type-name-item")
    public WebElement workgroup;

    @FindBy(css = ".socialnetwork-group-join-request-sent")
    public WebElement privateWorkgroupCheck;

    @FindBy(css = ".popup-window-close-icon")
    public WebElement popupCloseIcon;

    @FindBy(css = "a.profile-menu-links-item")
    public List<WebElement> topmenuLinks;

    @FindBy(xpath = "//span[contains(@id,'bx-sonet-groups-favorites')]")
    public List<WebElement> favorites;

    @FindBy(xpath = "(//span[contains(@id,'bx-sonet-groups-favorites')])[1]")
    public WebElement favorite1;

    public WebElement joinElement(String groupType) {
        String joinLocator = "//a[.='" + groupType + "']/../../..//span[contains(text(), 'Join')]";
        BrowserUtils.waitFor(2);
        return Driver.get().findElement(By.xpath(joinLocator));
    }

    public WebElement requestSentElement(String groupType){
        String requestLocator =  "//a[.='" + groupType + "']/../../..//span[contains(text(), 'Request has been sent')]";
        WebElement requestElement = Driver.get().findElement(By.xpath(requestLocator));
        BrowserUtils.waitForVisibility(requestElement,4);
        return requestElement;
    }

    public void navigateToGroup(String groupType){
        String groupLocator = "//div/span/span/span/a[.='"+groupType+"']";
        Driver.get().findElement(By.xpath(groupLocator)).click();
    }

    public WebElement locateFavorite(String groupType){

        //a[contains(text(), 'New product development')]/../../span[contains(@id,'bx-sonet-groups-favorites')]


        String favoriteLocator = "//a[contains(text(),'" + groupType + "')]/../../span[contains(@id,'bx-sonet-groups-favorites')]";

        WebElement element = Driver.get().findElement(By.xpath(favoriteLocator));
        BrowserUtils.waitForClickablility(element,3);
        return element;

    }




}