package step_definitions.cadastro_steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.PendingException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.cadastro_page.CadastroPage;
import pages.login_page.LoginPage;
import support.WebDriverConfigurations;

public class CadastroSteps {

    @BeforeAll
    public static void before_all(){
        WebDriverConfigurations.ConfigureChromeWebDriver();
    }

    CadastroPage cadastroPage = new CadastroPage();

    @AfterAll
    public static void after_all() throws InterruptedException {
        WebDriverConfigurations.TerminateDriver();
    }

    @Dado("estar na página de cadastro de usuários")
    public void estar_na_página_de_cadastro_de_usuarios() {
        cadastroPage.GoToCadastroPage();
    }

    @Quando("inserir todas as credenciais válidas")
    public void inserir_todas_as_credenciais_válidas() {
        cadastroPage.EnterName("Automation");
        cadastroPage.EnterEmail("automation@automation.com");
        cadastroPage.EnterPassword("12345");
    }

    @E("clicar no botão cadastrar")
        public void clicar_no_botão_cadastrar(){
        cadastroPage.ClickCadastrarButton();
    }

    @Então("deve ser redirecionado para a tela inicial")
    public void deve_ser_redirecionado_para_a_tela_inicial() {
        cadastroPage.GotoTelaInicialPage();
    }

    @E("inserir um email já cadastrado")
    public void inserir_um_email_já_cadastrado() {
        cadastroPage.ClickCadastrarButton();
    }

    @Então("deve mostrar a mensagem de erro Este email já está sendo usado")
    public void deve_mostrar_a_mensagem_de_erro() {
        cadastroPage.ClickXButton();
    }

    @Quando("deixar as credenciais em branco")
    public void deixar_as_credenciais_em_branco() {
        cadastroPage.ClickCadastrarButton();
    }

    @Então("deve ver a mensagem de erro {string}")
    public void deve_ver_a_mensagem_de_erro_de_campos_obrigatórios(String expected_message_blanc) {
    cadastroPage.ValidateBlancCredentials(expected_message_blanc);

    }

}
