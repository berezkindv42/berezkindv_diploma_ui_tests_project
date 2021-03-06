package com.berezkindv.pages;

import com.berezkindv.config.CredentialsConfig;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.berezkindv.data.TestData.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SendMailPage {

    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    private static final SelenideElement
            newMailButton = $("div[class='z0']").$(byText("Написать")),
            newMailFormCheck = $("div[class='AD']"),
            toFieldInput = $("textarea[name='to']"),
            subjectFieldInput = $("input[name='subjectbox']"),
            textboxInput = $("div[aria-label='Текст письма']"),
            sendMailButton = $("div[data-tooltip^='Отправить']"),
            sentMailButton = $("div[data-tooltip='Отправленные']"),
            sentMailCheck = $x("//span[@data-thread-id and text() ='" + mailSubject + "']");

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
        subjectFieldInput.setValue(mailSubject);
        return this;
    }

    @Step("Заполняем поле 'Текст письма'")
    public SendMailPage typeTextbox() {
        textboxInput.setValue(mailMessage);
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
    public void checkSentMail() {
        sentMailCheck.should(exist);
    }
}
