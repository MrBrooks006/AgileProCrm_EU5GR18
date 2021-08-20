package com.procrm.step_definitions;

import com.procrm.pages.DrivePage;
import com.procrm.pages.HomePage;
import com.procrm.pages.LoginPage;
import com.procrm.pages.TaskPage;
import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.ConfigurationReader;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TasksFunctionStepDefs {

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
    public void theUserNavigatesToTaskMenu(String tab) {

        new HomePage().navigateToSideMenu(tab);
    }

    @When("the user navigates to {string}")
    public void the_user_navigates_to(String tab) {
        new TaskPage().navigateTaskHeaderMenu(tab);

        BrowserUtils.waitFor(1);

    }


    @Then("the page contains {string}")
    public void the_page_contains(String squareButton) {

        String expectedSquareButtonTitle=squareButton;
        String actualSquareButtonTitle= new TaskPage().square.getText();


        Assert.assertTrue(expectedSquareButtonTitle, actualSquareButtonTitle.contains(expectedSquareButtonTitle));

        System.out.println("expectedSquareButtonTitle = " + expectedSquareButtonTitle);
        System.out.println("actualSquareButtonTitle = " + actualSquareButtonTitle);

    }

    @When("the search submit box is clean")
    public void the_search_submit_box_is_clean() {

        new TaskPage().cleanSubmit.click();

    }



}