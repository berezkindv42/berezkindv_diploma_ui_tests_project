package com.berezkindv.tests;

import com.berezkindv.helpers.DriverUtils;
import com.berezkindv.pages.LoginPage;
import com.berezkindv.pages.SendMailPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GmailTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    SendMailPage sendMailPage = new SendMailPage();

    @Test
    @Tag("ui")
    @Owner("berezkindv")
    @Description("Gmail login test")
    @DisplayName("Тест входа в gmail")
    void loginTest() {
        loginPage
                .openPage()
                .pushLoginButton()
                .checkLoginForm()
                .typeEmail()
                .pushEmailNextButton()
                .checkPasswordForm()
                .typePassword()
                .pushPasswordNextButton()
                .loggedCheck();

    }

    @Test
    @Tag("ui")
    @Owner("berezkindv")
    @Description("Send mail test")
    @DisplayName("Тест отправки почты")
    void sendMailTest() {
        loginPage
                .openPage()
                .pushLoginButton()
                .typeEmail()
                .pushEmailNextButton()
                .typePassword()
                .pushPasswordNextButton();
        sendMailPage
                .pushNewMailButton()
                .checkNewMailForm()
                .typeToField()
                .typeSubjectField()
                .typeTextbox()
                .pushSendMailButton()
                .goToSentMailTab()
                .checkSentMail();
    }

    @Test
    @Tag("ui")
    @Owner("berezkindv")
    @Description("Page title should have header text")
    @DisplayName("Проверка соответствия заголовка вкладки")
    void titleTest() {
        step("Открываем страницу 'https://www.google.com/intl/ru/gmail/about/'", () ->
                open("https://www.google.com/intl/ru/gmail/about/"));

        step("Заголовок вкладки должен содержать текст: 'Электронная почта Gmail: надежно, конфиденциально, бесплатно | Google Workspace'", () -> {
            String expectedTitle = "Электронная почта Gmail: надежно, конфиденциально, бесплатно | Google Workspace";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Tag("ui")
    @Owner("berezkindv")
    @Description("Page console log should not have errors")
    @DisplayName("Проверка лога консоли на отсутствие ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем страницу 'https://www.google.com/intl/ru/gmail/about/'", () ->
                open("https://www.google.com/intl/ru/gmail/about/"));

        step("Лог консоли не должен содержать текст: 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Tag("ui")
    @Owner("berezkindv")
    @Description("Page console log should not have errors, negative test")
    @DisplayName("Проверка лога консоли на отсутствие ошибок, негативный тест")
    void negativeConsoleShouldNotHaveErrorsTest() {
        step("Открываем страницу 'https://www.google.com/intl/ru/gmail/about/'", () ->
                open("https://www.google.com/intl/ru/gmail/about/"));

        step("Лог консоли не должен содержать текст: 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).contains(errorText);
        });
    }
}