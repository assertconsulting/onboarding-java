package step_definitions.login_steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.home_page.HomePage;
import pages.login_page.LoginPage;
import support.WebDriverConfigurations;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @BeforeAll
    public static void before_all(){
        WebDriverConfigurations.ConfigureChromeWebDriver();
    }

    @AfterAll
    public static void after_all() throws InterruptedException {
        WebDriverConfigurations.TerminateDriver();
    }

    @Given("que eu esteja na página de login")
    public void que_eu_esteja_na_página_de_login() {
        loginPage.GoToMainPage();
    }

    @When("eu inserir credenciais válidas")
    public void eu_inserir_credenciais_válidas() {
        loginPage.EnterEmail("automation@automation.com");
        loginPage.EnterPassword("12345");
    }

    @When("clico no botão entrar")
    public void clico_no_botão_entrar() {
        loginPage.ClickEnterButton();
    }

    @When("eu inserir senha inválida e login válido")
    public void eu_inserir_senha_inválida_e_login_válido() {
        loginPage.EnterEmail("automation@automation.com");
        loginPage.EnterPassword("12346");
    }

    @Then("não devo ser redirecionado para a tela inicial")
    public void não_devo_ser_redirecionado_para_a_tela_inicial() {
        loginPage.ValidateLoginScreen();
    }

    @Then("devo ser redirecionado para a tela inicial")
    public void devo_ser_redirecionado_para_a_tela_inicial() {
        homePage.ValidateHomeScreen();

    }
}
