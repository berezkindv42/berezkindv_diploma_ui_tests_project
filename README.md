# Дипломный проект по UI тестированию для Gmail
<a target="_blank" href="https://mail.google.com/mail">Gmail</a>

## :pushpin: Содержание:

- [Технологии и инструменты](#технологии-и-инструменты)
- [Тест кейсы](#scroll-Тест-кейсы)
- [Сборка в Jenkins](#jenkins-job)
- [Запуск из терминала](#computer-запуск-тестов-из-терминала)
- [Allure отчет](#отчет-в-allure-report)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Отчет в Telegram](#уведомление-в-telegram-при-помощи-бота)
- [Видео примеры прохождения тестов](#примеры-видео-о-прохождении-тестов)

## :rocket:Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logos/Docker.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logos/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Allure_EE.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :scroll: Тест кейсы

- ✓ Автотест на соответствие заголовка страницы.
- ✓ Автотест входа в почту.
- ✓ Автотест отправки письма.
- ✓ Автотест лога консоли на наличие ошибок.
- ✓ Ручной тест сохранения в черновики (Добавлен в Allure TestOps).
- ✓ Ручной тест удаления письма (Добавлен в Allure TestOps).

## <img src="images/logos/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a>Jenkins job
### <a target="_blank" href="https://jenkins.autotests.cloud/job/berezkindv_diploma_ui_tests_project/">Сборка в Jenkins</a>

Для запуска сборки нужно нажат кнопку "Собрать с параметрами":
<p align="center">
<a href="https://jenkins.autotests.cloud/job/berezkindv_diploma_ui_tests_project/"><img src="images/screenshots/jenkins_job_run.jpg" alt="Jenkins"/></a>
</p>

Далее следует выбрать параметры сборки:
<p align="center">
<a href="https://jenkins.autotests.cloud/job/berezkindv_diploma_ui_tests_project/"><img src="images/screenshots/jenkins_job_parameters.jpg" alt="Jenkins"/></a>
</p>

По завершении сборки можно посмотреть Allure отчет или перейти к Allure TestOps:
<p align="center">
<a href="https://jenkins.autotests.cloud/job/berezkindv_diploma_ui_tests_project/"><img src="images/screenshots/jenkins_job_notifications.jpg" alt="Jenkins"/></a>
</p>



### Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 100.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)
- browserMobileView (отображение мобильной версии, для примера iPhone X)
- remoteDriverUrl (логин, пароль и адрес удаленного сервера selenoid)
- videoStorage (адрес, по которому можно получить видео)
- threads (количество потоков)

## :computer: Запуск тестов из терминала

Локальный запуск:
```bash
gradle clean test
```

Удаленный запуск:
```bash
clean
${TASK}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://${LOGIN}:${PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

## <img src="images/logos/Allure_Report.svg" width="25" height="25"  alt="Allure"/></a>Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/berezkindv_performance_lab_complete_project/22/allure/">Allure report</a>

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure_report_dashboard.png">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="images/screenshots/allure_report_tests.png">
</p>

### Гафики

<p align="center">
<img title="Allure Graphics" src="images/screenshots/allure_report_graphs.png">
</p>

## <img src="images/logos/Allure_EE.svg" width="25" height="25"  alt="Allure"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/10223">Allure TestOps</a>

### Дашборд

<p align="center">
<img title="Allure TestOps Dashboard" src="images/screenshots/testops_dashboard.png">
</p>

### Тест-кейсы (добавляем ручные тесты)

<p align="center">
<img title="Allure TestOps Tests" src="images/screenshots/testops_added_manual_tests.jpg">
</p>

## <img src="images/logos/Telegram.svg" width="25" height="25"  alt="Allure"/></a>Уведомление в Telegram при помощи бота
По завершении всех операций телеграм бот отправит отчет со статистикой:
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/telegram_bot.png">
</p>



### <img src="images/logos/Selenoid.svg" width="25" height="25"  alt="Allure"/></a>Примеры видео о прохождении тестов

<p align="center">
<img title="Selenoid Video" src="images/screenshots/video_logintest.gif" width="250" height="153"  alt="video"> <img title="Selenoid Video" src="images/screenshots/video_sendmailtest.gif" width="250" height="153"  alt="video">
</p>
