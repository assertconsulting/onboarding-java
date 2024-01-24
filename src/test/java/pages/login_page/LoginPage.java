package pages.login_page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.Behaviors;
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
    public void ValidateLoginScreen() {
        WebElement LogInButton = Behaviors.GetElement(Behaviors.GetElementBy.XPath, "//*[@id=\"root\"]/div/div/form/button");
        Assertions.assertNull(LogInButton);
        String texto = Behaviors.GetElementByXPath("//*[@id=\"root\"]/div/div/form/div[1]/span").getText();
        Assertions.assertSame("Email deve ser um email válido", texto);
    }
}
