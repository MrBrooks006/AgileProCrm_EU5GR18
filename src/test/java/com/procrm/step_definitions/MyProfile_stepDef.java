package com.procrm.step_definitions;

import com.procrm.pages.BasePage;
import com.procrm.pages.LoginPage;
import com.procrm.pages.MyProfile;
import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.ConfigurationReader;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyProfile_stepDef extends BasePage {

    @Given("user is logged in with {string} and {string}")
    public void user_is_logged_in_with_and(String username, String password) {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(username,password);
        String expectedUrl = "https://qa.agileprocrm.com/stream/?login=yes";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        BrowserUtils.waitForPageToLoad(1);
    }


    @When("user clicks on {string}")
    public void user_clicks_on(String string) {

        MyProfile myProfile = new MyProfile();
        switch (string){
            case"Edit Profile Setting":
                myProfile.goToProfileSettings();
                break;
            case"My Profile":
                myProfile.goToMyProfile();
                break;
            case"Log out":
                myProfile.logOut();
                break;
            case"Configure notifications":
                myProfile.goToConfigureNot();
                break;
        }



    }

    @Then("user should able to see Edit User Profile")
    public void user_should_able_to_see_Edit_User_Profile() {
        boolean flag ;

        String expectedTitle ="Edit User Profile";
        MyProfile myProfile = new MyProfile();

        BrowserUtils.waitFor(1);
        String actualTitle= myProfile.pageSubTitle.getText();


        if(actualTitle.contains(expectedTitle)){
            flag = true;
        }else{
            flag = false;
        }
        //checking if actual title contains expected title
        Assert.assertTrue(flag==true);
    }


    @Then("user should able to see Contact Information")
    public void user_should_able_to_see_Contact_Information() {

        MyProfile myProfile = new MyProfile();

        String expected = "Contact information";
        String actual = myProfile.contactInfo.getText();

        Assert.assertEquals(expected,actual);




    }


}
