package com.berezkindv.pages;

import com.berezkindv.config.CredentialsConfig;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    private static final SelenideElement
            loginButton = $(".header").$(byText("Войти")),
//            loginFormCheck = $("div#view_container").$(byText("Забыли адрес электронной почты?")),
            loginFormCheck = $("div#view_container").$(byText("E-Mail-Adresse vergessen?")),
            emailInput = $("#identifierId"),
//            emailInputNextButton = $("#identifierNext").$(byText("Далее")),
            emailInputNextButton = $("#identifierNext").$(byText("Weiter")),
//            passwordFormCheck = $("div#view_container").$(byText("Забыли пароль?")),
            passwordFormCheck = $("div#view_container").$(byText("Passwort anzeigen")),
            passwordInput = $("input[type='password']"),
//            passwordInputNextButton = $("#passwordNext").$(byText("Далее")),
            passwordInputNextButton = $("#passwordNext").$(byText("Weiter")),
            loggedIcon = $("img[class='gb_Aa gbii']"),
            loggedTooltip = $x("//div[text() = 'John Smith']");
// дублированные строки для локального запуска

    @Step("Открываем страницу 'https://www.google.com/intl/ru/gmail/about/'")
    public LoginPage openPage() {
        open("/intl/ru/gmail/about/?hl=ru");
        return this;
    }

    @Step("Нажимаем кнопку 'Войти'")
    public LoginPage pushLoginButton() {
        loginButton.click();
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
    public void loggedCheck() {
        loggedIcon.hover();
        loggedTooltip.should(exist);
    }
}
