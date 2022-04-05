package berezkindv.pages;

import berezkindv.config.CredentialsConfig;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static berezkindv.data.TestData.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SendMailPage {

    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);


    private static final SelenideElement
            gmailAppButton = $("a[href='https://mail.google.com/mail/?tab=km']").parent(),
            loginButton = $(".header").$(byText("Войти")),
            newMailButton = $("div[class='z0']").$(byText("Написать")),
            newMailFormCheck = $("div[class='AD']"),
            toFieldInput = $("textarea[name='to']"),
            subjectFieldInput = $("input[name='subjectbox']"),
            textboxInput = $("div[aria-label='Текст письма']"),
            sendMailButton = $("div[data-tooltip^='Отправить']"),
            sentMailButton = $("div[data-tooltip='Отправленные']"),
            sentMailCheck = $x("//span[@data-thread-id and text() ='" + testMailSubject + "']");


    @Step("Открываем почту")
    public SendMailPage openMailPage() {
        open(gmailPage);
        return this;
    }

    @Step("Нажимаем кнопку 'Войти'")
    public SendMailPage pushLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Нажимаем кнопку 'Написать'")
    public SendMailPage pushNewMailButton() {
        newMailButton.click();
        return this;
    }

    @Step("Проверяем открытие формы нового письма")
    public SendMailPage checkNewMailForm() {
        newMailFormCheck.shouldHave(text("Новое сообщение"));
        return this;
    }

    @Step("Заполняем полу 'Кому'")
    public SendMailPage typeToField() {
        toFieldInput.setValue(config.toEmail());
        return this;
    }

    @Step("Заполняем поле 'Тема'")
    public SendMailPage typeSubjectField() {
        subjectFieldInput.setValue(testMailSubject);
        return this;
    }

    @Step("Заполняем поле 'Текст письма'")
    public SendMailPage typeTextbox() {
        textboxInput.setValue(testMailMessage);
        return this;
    }

    @Step("Нажимаем кнопку 'Отправить'")
    public SendMailPage pushSendMailButton() {
        sendMailButton.click();
        return this;
    }

    @Step("Переходим в 'Отправленные'")
    public SendMailPage goToSentMailTab() {
        sentMailButton.click();
        return this;
    }

    @Step("Проверяем, что письмо отправлено")
    public SendMailPage checkSentMail() {
        sentMailCheck.should(exist);
        return this;
    }

    @Step("Нажимаем кнопку приложения 'Gmail'")
    public SendMailPage pushGmailAppButton() {
        gmailAppButton.click();
        return this;
    }

    @Step("Переходим во фрейм приложений")
    public SendMailPage switchFrame() {
        Selenide.switchTo().frame("iframe[src='https://ogs.google.com/u/0/widget/app?origin=https%3A%2F%2Fmyaccount.google.com&cn=app&pid=269&spid=192&hl=ru']");
        return this;
    }

    @Step("Открываем новую вкладку")
    public SendMailPage switchTab() {
        Selenide.switchTo().window(1);
        return this;
    }

    public SendMailPage sleep(int value) {
        Selenide.sleep(value);
        return this;
    }

}
