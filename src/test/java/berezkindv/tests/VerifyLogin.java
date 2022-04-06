package berezkindv.tests;

import berezkindv.config.CredentialsConfig;
import berezkindv.pages.LoginPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class VerifyLogin extends TestBase {

    LoginPage loginPage = new LoginPage();
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    // Andere Option wählen

    @Test
    @Tag("verify")
    public void verifyLoginTest() {

        open("https://accounts.google.com/ServiceLogin?hl=ru");
        $("#identifierId").setValue(config.userEmail());
        $("#identifierNext").$(byText("Далее")).click();
        $("input[type='password']").setValue(config.userPassword());
        $("#passwordNext").$(byText("Далее")).click();
        $x("//div[text() = 'Другой способ']").click();
        loginPage
                .loggedCheck();
    }
}
