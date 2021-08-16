package com.procrm.step_definitions;

import com.procrm.pages.BasePage;
import com.procrm.pages.DrivePage;
import com.procrm.pages.HomePage;
import com.procrm.pages.LoginPage;
import com.procrm.utilities.ConfigurationReader;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DriveFunctionStepDefs {

    LoginPage loginPage=new LoginPage();

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equals("marketing")){
            username = ConfigurationReader.get("marketing_username");
            password = ConfigurationReader.get("marketing_password");
        }else if(userType.equals("helpdesk")){
            username = ConfigurationReader.get("help_desk_username");
            password = ConfigurationReader.get("help_desk_password");
        }else if(userType.equals("hr")){
            username = ConfigurationReader.get("hr_username");
            password = ConfigurationReader.get("hr_password");
        }
        //send username and password and login

        loginPage.userName.clear();
        loginPage.login(username,password);
    }



    @When("the user navigates to {string} menu")
    public void theUserNavigatesToDriveMenu(String tab) {

        new HomePage().navigateToSideMenu(tab);
    }

    @When("the user navigates to {string}")
    public void the_user_navigates_to(String tab) {
        new DrivePage().navigateDriveHeaderMenu(tab);

    }

    @Then("the title contains {string}")
    public void the_title_contains(String title) {

        String expectedTitle=title;

        String actualTitle=new DrivePage().pageTitle.getText();

        Assert.assertEquals(expectedTitle,actualTitle);

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);


    }

}
