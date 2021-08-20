package com.procrm.step_definitions;

import com.procrm.pages.CalendarPage;
import com.procrm.pages.DashboardPage;
import com.procrm.pages.HomePage;
import com.procrm.pages.LoginPage;
import com.procrm.utilities.ConfigurationReader;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalendarStepDef {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    CalendarPage calendarPage = new CalendarPage();

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        Driver.get().get(ConfigurationReader.get("url"));

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


        loginPage.userName.clear();
        loginPage.login(username,password);
    }

    @When("the user navigates to {string} menu")
    public void the_user_navigates_to_menu(String tab) {
        new HomePage().navigateToSideMenu(tab);
    }

    @When("the user navigates to {string}")
    public void theUserNavigatesTo(String tab) {
        new CalendarPage().navigateCalendarHeaderMenu(tab);
    }


    @Then("the title contains {string}")
    public void the_title_contains(String subtitle) {

        String expectedSubtitle=subtitle;

        String actualTitle = new CalendarPage().subtitle.getText();

        Assert.assertEquals(expectedSubtitle, actualTitle);
    }


}