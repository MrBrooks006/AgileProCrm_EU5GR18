package com.procrm.pages;

import com.procrm.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ActivityStreamPage extends BasePage {

    public ActivityStreamPage(){
        PageFactory.initElements(Driver.get(), this);
    }

}
