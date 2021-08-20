package com.procrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class MyProfile extends BasePage{

    @FindBy(css = "[class=profile-menu-name]")
    public WebElement myProfileName;

    @FindBy(xpath = "//td[contains(text(),'Contact information')]")
    public WebElement contactInfo;

}