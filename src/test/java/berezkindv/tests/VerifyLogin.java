package berezkindv.tests;

import berezkindv.pages.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

public class VerifyLogin extends TestBase {

    LoginPage loginPage = new LoginPage();

    // Andere Option wählen

    @Test
    @Tag("verify")
    public void verifyLoginTest() {
        loginPage
                .openAccountPage()
                .typeEmail()
                .pushEmailNextButton()
                .typePassword()
                .pushPasswordNextButton();
        $x("//div[text() = 'Andere Option wählen']").click();
        loginPage.loggedCheck();
    }
}
