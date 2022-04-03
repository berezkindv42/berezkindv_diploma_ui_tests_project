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
            loginFormCheck = $("#view_container").$(byText("Забыли адрес электронной почты?")),
            emailInput = $("#identifierId"),
            emailInputNextButton = $("#identifierNext").$(byText("Далее")),
            passwordFormCheck = $("#view_container").$(byText("Забыли пароль?")),
            passwordInput = $("input[type='password']"),
            passwordInputNextButton = $("#passwordNext").$(byText("Далее")),
            loggedIcon = $("img[class='gb_Aa gbii']"),
//            loggedTooltip = $("body > div:nth-child(30)");
            loggedTooltip = $x("//div[text() = 'John Smith']");

    // body > div.gb_Qe
    // body > div.gb_Qe > div > div:nth-child(3)
    // /html/body/div[17]/div/div[2]

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
//        loggedTooltip.shouldHave(text("John Smith"));
        loggedTooltip.should(exist);
        return this;
    }

    public LoginPage sleep(int value) {
        Selenide.sleep(value);
        return this;
    }


}
