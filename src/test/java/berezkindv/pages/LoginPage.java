package berezkindv.pages;

import berezkindv.config.CredentialsConfig;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static berezkindv.data.TestData.gmailPage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    private static final SelenideElement loginButton = $(".header").$(byText("Войти")),
            languageChooseButton = $("#lang-chooser"),
            languageSelect = $("div[data-value='ru']"),
            loginFormCheck = $("div[id='view_container']").$(byText("Забыли адрес электронной почты?")),
            emailInput = $("#identifierId"),
            emailInputNextButton = $("#identifierNext").$(byText("Далее")),
            passwordFormCheck = $("div[id='view_container']").$(byText("Забыли пароль?")),
            passwordInput = $("input[type='password']"),
            passwordInputNextButton = $("#passwordNext").$(byText("Далее")),
            loggedIcon = $("img[class='gb_Aa gbii']"),
            loggedTooltip = $x("//div[text() = 'John Smith']");


    @Step("Открываем страницу 'https://www.google.com/intl/ru/gmail/about/'")
    public LoginPage openPage() {
        open(gmailPage);
        return this;
    }

    @Step("Нажимаем кнопку 'Войти'")
    public LoginPage pushLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Нажимаем кнопку выбора языка")
    public LoginPage pushLanguageChooseButton() {
        languageChooseButton.click();
        return this;
    }

    @Step("Нажимаем кнопку выбора языка")
    public LoginPage selectRuLanguage() {
        languageSelect.scrollIntoView(false).click();
        return this;
    }

    @Step("Проверяем открытие формы ввода электронной почты")
    public LoginPage checkLoginForm() {
        loginFormCheck.should(exist);
        return this;
    }

    @Step("Заполняем поле 'Телефон или адрес эл. почты'")
    public LoginPage typeEmail() {
        emailInput.setValue(config.userEmail());
        return this;
    }

    @Step("Нажимаем кнопку 'Далее' в форме ввода электронной почты")
    public LoginPage pushEmailNextButton() {
        emailInputNextButton.click();
        return this;
    }

    @Step("Проверяем открытие формы ввода пароля")
    public LoginPage checkPasswordForm() {
        passwordFormCheck.should(exist);
        return this;
    }

    @Step("Заполняем поле 'Password")
    public LoginPage typePassword() {
        passwordInput.setValue(config.userPassword());
        return this;
    }

    @Step("Нажимаем кнопку 'Далее' в форме ввода пароля")
    public LoginPage pushPasswordNextButton() {
        passwordInputNextButton.click();
        return this;
    }

    @Step("Проверяем логин")
    public LoginPage loggedCheck() {
        loggedIcon.hover();
        loggedTooltip.should(exist);
        return this;
    }

    public LoginPage sleep(int value) {
        Selenide.sleep(value);
        return this;
    }


}
