package com.procrm.step_definitions;

import com.procrm.pages.ActivityStreamPage;
import com.procrm.pages.LoginPage;
import com.procrm.pages.WorkGroupsPage;
import com.procrm.utilities.BrowserUtils;
import com.procrm.utilities.ConfigurationReader;
import com.procrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WorkgroupStepDefs {

    @Given("the user is on the login page")
    public void the_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @Given("the {string} enters the valid credentials and logs in")
    public void the_enters_the_valid_credentials_and_logs_in(String userType) {

        String userName = "";
        String password = "";

        switch (userType) {

            case "hr":
                userName = ConfigurationReader.get("hr_username");
                password = ConfigurationReader.get("hr_password");
                break;
            case "marketing":
                userName = ConfigurationReader.get("marketing_username");
                password = ConfigurationReader.get("marketing_password");
                break;
            case "helpdesk":
                userName = ConfigurationReader.get("helpdesk_username");
                password = ConfigurationReader.get("helpdesk_password");
                break;
            default:
                System.out.println("invalid user type");
        }

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

    }

    @When("the user navigates to {string} tab")
    public void the_navigates_to_tab(String tab) {
        ActivityStreamPage activityStreamPage = new ActivityStreamPage();
        activityStreamPage.navigateToTab(tab);
    }


    int expectedTopMenuItemNum;
    String workgroup = "";


    @When("the user joins the {string} group")
    public void the_user_joins_the_group(String groupType) {
        WorkGroupsPage workGroupsPage = new WorkGroupsPage();
        BrowserUtils.waitFor(1);
        workGroupsPage.navigateToGroup(groupType);
        BrowserUtils.waitFor(4);
        expectedTopMenuItemNum = workGroupsPage.topmenuLinks.size() + 1;
        workgroup = BrowserUtils.waitForVisibility(workGroupsPage.workgroup, 6).getText();
        Driver.get().navigate().back();
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(workGroupsPage.joinElement(groupType),6).click();

    }


    @Then("the user verifies she or he joint for {string}")
    public void the_user_sees_the_request_message_for(String groupType) {
        String actualPrivateMessage="";
        WorkGroupsPage workGroupsPage = new WorkGroupsPage();
        BrowserUtils.waitFor(2);
        workGroupsPage.navigateToGroup(groupType);
        BrowserUtils.waitFor(2);
        if (workgroup.equals("private workgroup (visible)")) {
            BrowserUtils.waitForVisibility(workGroupsPage.popupCloseIcon, 6).click();
            actualPrivateMessage = workGroupsPage.privateWorkgroupCheck.getText();
        }

        BrowserUtils.waitForPageToLoad(4);
        String expectedPrivate = "You have already sent a request to join this workgroup.";
        int actualTopMenuItemNum = workGroupsPage.topmenuLinks.size();

        System.out.println("workgroup = " + workgroup);
        System.out.println("actualTopMenuItemNum = " + actualTopMenuItemNum);
        System.out.println("expectedTopMenuItemNum = " + expectedTopMenuItemNum);
        System.out.println("expectedPrivate = " + expectedPrivate);
        System.out.println("actualPrivateMessage = " + actualPrivateMessage);

        if (workgroup.equals("private workgroup (visible)")) {
            Assert.assertEquals(expectedPrivate,actualPrivateMessage);
        } else {
            Assert.assertEquals(expectedTopMenuItemNum, actualTopMenuItemNum);
        }


    }


    @And("the user adds the {string} to favorites")
    public void theUserAddsTheGrouptypeToFavorites(String grouptype) {
        WorkGroupsPage workGroupsPage = new WorkGroupsPage();
        BrowserUtils.waitFor(1);
        boolean titleStatus = workGroupsPage.locateFavorite(grouptype).getAttribute("title").equals("Remove from favorites");
        BrowserUtils.waitFor(1);
        if (titleStatus) {
            workGroupsPage.locateFavorite(grouptype).click();
            BrowserUtils.waitFor(1);
        }

        BrowserUtils.waitFor(1);
        workGroupsPage.locateFavorite(grouptype).click();
    }


    @Then("the user verifies that the {string} added to favorites")
    public void theUserVerifiesThatTheGroupAddedToFavorites(String grouptype) {
        WorkGroupsPage workGroupsPage = new WorkGroupsPage();
        String actualAttribute = workGroupsPage.locateFavorite(grouptype).getAttribute("title");
        Assert.assertEquals("Remove from favorites", actualAttribute);

    }
}