package step_definitions.login_steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
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

    @Dado("estar na página de login")
    public void estar_na_página_de_login() {
        loginPage.GoToMainPage();
    }

    @Quando("inserir credenciais válidas, clicar no botão entrar")
    public void inserir_credenciais_válidas_clicar_no_botão_entrar()  {
        loginPage.EnterEmail("automation@automation.com");
        loginPage.EnterPassword("12345");
        loginPage.ClickEnterButton();
    }

    @Quando("inserir login válido e senha inválida, clicar no botão entrar")
    public void inserir_login_válido_e_senha_inválida_clicar_no_botão_entrar() {
        loginPage.EnterEmail("automation@automation.com");
        loginPage.EnterPassword("12346");
        loginPage.ClickEnterButton();
    }

    @Quando("inserir login inválido e senha válida, clicar no botão entrar")
    public void inserir_login_inválido_e_senha_válida_clicar_no_botão_entrar() {
        loginPage.EnterEmail("automation@automation.co");
        loginPage.EnterPassword("12345");
        loginPage.ClickEnterButton();
    }

    @Quando("inserir login inválido e senha inválida, clicar no botão entrar")
    public void inserir_login_inválido_e_senha_inválida_clicar_no_botão_entrar() {
        loginPage.EnterEmail("automation@automation.");
        loginPage.EnterPassword("5699aS1!%¨^");
        loginPage.ClickEnterButton();
    }

    @Quando("inserir e-mail vazio e campo senha preenchido, clicar no botão entrar")
    public void inserir_e_mail_vazio_e_campo_senha_preenchido_clicar_no_botão_entrar() {
        loginPage.EnterEmail("");
        loginPage.EnterPassword("12345");
        loginPage.ClickEnterButton();
    }

    @Quando("inserir e-mail e campo senha vazio, clicar no botão entrar")
    public void inserir_e_mail_e_campo_senha_vazio_clicar_no_botão_entrar() {
        loginPage.EnterEmail("automation@automation.com");
        loginPage.EnterPassword("");
        loginPage.ClickEnterButton();
    }

    @Quando("campo e-mail vazio e campo senha vazio, clicar no botão entrar")
    public void campo_e_mail_vazio_e_campo_senha_vazio_clicar_no_botão_entrar() {
        loginPage.EnterEmail("");
        loginPage.EnterPassword("");
        loginPage.ClickEnterButton();
    }

    @Entao("deve ser redirecionado para a tela inicial")
    public void deve_ser_redirecionado_para_a_tela_inicial() { homePage.ValidateHomeScreen();
    }

    @Entao("não deve ser redirecionado para a tela inicial, deve mostrar a mensagem {string}")
    public void não_deve_ser_redirecionado_para_a_tela_inicial_deve_mostrar_a_mensagem(String expected_message) {
        loginPage.ValidateMessageWrongCredentials(expected_message);
    }

    @Entao("não deve ser redirecionado para a tela inicial, deve mostrar a mensagem {string} e {string}")
    public void não_deve_ser_redirecionado_para_a_tela_inicial_deve_mostrar_a_mensagem_e(String string, String string2) {

    }
}
