package com.procrm.pages;

import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {


    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(xpath = "//span[contains(text(),'Configure notifications')]")
    public WebElement configNot;

    @FindBy(xpath = "//span[contains(text(),'Edit Profile Settings')]")
    public WebElement editProfileSet;

    @FindBy(id = "sitemap-menu")
    public List<WebElement> menu;

    @FindBy(id = "user-block")
    public WebElement showUserMenu;

    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(css = "[id=pagetitle]")
    public WebElement pageSubTitle;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    public WebElement logOutLink;

    @FindBy(xpath = "//span[contains(text(),'My Profile')]")
    public WebElement myProfile;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        BrowserUtils.waitForVisibility(pageSubTitle,3);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            BrowserUtils.waitFor(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void goToConfigureNot(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(configNot);


    }
    public String getUserName(){

        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void goToProfileSettings(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(editProfileSet);
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void goToMyProfile(){

        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myProfile, 5).click();

    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param
     * @param
     */
    public void navigateToSideMenu(String tab) {
        String tabLocator = "//span[contains(text(),'"+tab+"')][@data-role='item-text']";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).click(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }

    }

    public void navigateToTab(String tab){

        String tabLocator = "//a[@title='"+ tab +"']//span[@data-role='item-text']";
        Driver.get().findElement(By.xpath(tabLocator)).click();
    }

    public void navigateToTopMenu(String topMenu) {
        String topMenuLocator = "//div[@id='feed-add-post-form-tab']/span[@id='feed-add-post-form-tab-"+topMenu+"']";

        try {
            BrowserUtils.waitForClickablility(By.xpath(topMenuLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(topMenuLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).click(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(topMenuLocator), 5);
        }

    }





}