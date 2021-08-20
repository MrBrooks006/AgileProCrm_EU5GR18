package com.procrm.step_definitions;

import com.procrm.pages.LoginPage;
import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.ConfigurationReader;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class LoginStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.userName.clear();
    }

    @When("the user enters valid {string} and {string}")
    public void the_user_enters_valid_and_or(String username, String password) {
        BrowserUtils.waitForPageToLoad(3);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @Then("the user should log in into the home page")
    public void the_user_should_log_in_into_the_home_page() {
        String expectedUrl="https://qa.agileprocrm.com/stream/?login=yes";
        String actualUrl=Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("the user enters invalid {string} and {string}")
    public void the_user_enters_invalid_and_or(String username, String password) {
        BrowserUtils.waitForPageToLoad(3);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Then("system should show the error message")
    public void system_should_show_the_error_message() {
        String expectedError = "Incorrect login or password";

        BrowserUtils.waitForVisibility(Driver.get().findElement(By.className("errortext")),5);

        Assert.assertEquals(expectedError, Driver.get().findElement(By.className("errortext")).getText());
    }

    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        String expectedTitle = "Authorization";
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

}