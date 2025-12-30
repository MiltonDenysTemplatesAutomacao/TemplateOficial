package md.automation.web.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import md.automation.web.logic.LoginLogic;

public class LoginSteps {
    private final LoginLogic loginLogic = new LoginLogic();

    @Given("que o usuário acessa a página de login")
    public void acessarPaginaLogin() {
        loginLogic.accessLoginPage();
    }

    @When("ele realiza login com usuário e senha válidos")
    public void realizarLoginValido() {
        loginLogic.performValidLogin();
    }

    @Then("o sistema deve exibir a página inicial")
    public void validarPaginaInicial() {
        loginLogic.validateHomePage();
    }
}
