package pages.login_page;

import org.junit.jupiter.api.Assertions;
import support.Behaviors;
import support.FrameworkLogger;
import support.WebDriverConfigurations;

public class LoginPage {
    public void GoToMainPage(){
        WebDriverConfigurations.driver.navigate().to("https://front.serverest.dev/login");
    }

    public void EnterEmail(String email) {
        Behaviors.InputTextById(email, "email");
    }

    public void EnterPassword(String password) {
        Behaviors.InputTextByXpath(password, "//*[@id=\"password\"]");
        // Behaviors.InputTextById(password, "password");
    }

    public void ClickEnterButton() {
        Behaviors.ClickElementByXpath("//*[@id=\"root\"]/div/div/form/button");
    }

    public void LoginWithValidCredentials(){
        GoToMainPage();
        EnterEmail("automation@automation.com");
        EnterPassword("12345");
        ClickEnterButton();
    }
    public void ValidateLoginWarning() {
        String texto = Behaviors.GetElementByXPath("//*[@id=\"root\"]/div/div/form/div[1]/span").getText();

        Assertions.assertSame("Email deve ser um email válido", texto);
    }

    public void ValidateMessageWrongCredentials(String expected_message) {
        String warning_message = Behaviors.GetElementByXPath("//*[@id=\"root\"]/div/div/form/div[1]/span").getText();

        Assertions.assertEquals(expected_message, warning_message);

        FrameworkLogger.LogStringAssertions(expected_message,warning_message);
    }

}
