package md.automation.web.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import md.automation.web.logic.LoginLogic;

public class LoginSteps {
    private final LoginLogic loginLogic = new LoginLogic();

    @Given("user accesses the login page")
    public void userAccessesLoginPage() {
        loginLogic.accessLoginPage();
    }

    @When("user logs in with valid username and password")
    public void userLogsIn() {
        loginLogic.performValidLogin();
    }

    @Then("the system should display the home page")
    public void systemDisplaysHomePage() {
        loginLogic.validateHomePage();
    }


}
