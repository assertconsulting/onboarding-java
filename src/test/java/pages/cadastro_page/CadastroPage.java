package pages.cadastro_page;

import org.junit.jupiter.api.Assertions;
import support.Behaviors;
import support.FrameworkLogger;
import support.WebDriverConfigurations;

public class CadastroPage {
    public void GoToCadastroPage(){
        WebDriverConfigurations.driver.navigate().to("https://front.serverest.dev/cadastrarusuarios");
}

    public void GotoTelaInicialPage() {
        WebDriverConfigurations.driver.navigate().to("https://front.serverest.dev/home");
    }

    public void EnterName(String name) {
        Behaviors.InputTextByXpath(name, "//*[@id=\"nome\"]");
    }

    public void EnterEmail(String email) {
        Behaviors.InputTextByXpath(email, "//*[@id=\"email\"]");
    }

    public void EnterPassword(String password) {
        Behaviors.InputTextByXpath(password, "//*[@id=\"password\"]");
    }

    public void ClickCadastrarButton() {
        Behaviors.ClickElementByXpath("//*[@id=\"root\"]/div/div/form/div[5]/button");
    }

    public void ClickXButton() {
        Behaviors.ClickElementByXpath("//*[@id=\"root\"]/div/div/form/div[1]/button/span");
    }

    public void ValidateDuplicatedCredential(String expected_message){
        String warning_message = String.valueOf(Behaviors.GetElementByXPath("//*[@id=\"root\"]/div/div/form/div[1]/span"));

        Assertions.assertEquals(expected_message, warning_message);

        FrameworkLogger.LogStringAssertions(expected_message, warning_message);
    }

    public void ValidateBlancCredentials(String expected_message_blanc) {
        String warning_message_blanc = String.valueOf(Behaviors.GetElementByXPath("//*[@id=\"root\"]/div/div/form/div[2]"));
    }

}
