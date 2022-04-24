# Дипломный проект по автоматическому UI тестированию отправки почты в Gmail
<a target="_blank" href="https://mail.google.com/mail">Gmail</a>

## :pushpin: Содержание:

- [Технологии и инструменты](#rocket-технологии-и-инструменты)
- [Тест кейсы](#scroll-тест-кейсы)
- [Параметры запуска тестов из терминала](#computer-параметры-запуска-тестов-из-терминала)
- [Сборка в Jenkins](#jenkins-job)
- [Allure отчет](#отчет-в-allure-report)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Отчет в Telegram](#уведомление-в-telegram-при-помощи-бота)
- [Видео примеры прохождения тестов](#примеры-видео-о-прохождении-тестов)

## :rocket: Технологии и инструменты

<p align="center">
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://github.com/"><img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://www.docker.com/"><img src="images/logos/Docker.svg" width="50" height="50"  alt="Docker"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logos/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://qameta.io/"><img src="images/logos/Allure_EE.svg" width="50" height="50"  alt="Allure TestOps"/></a>
</p>

## :scroll: Тест кейсы

- ✓ Автотест на соответствие заголовка страницы.
- ✓ Автотест входа в почту.
- ✓ Автотест отправки письма.
- ✓ Автотест лога консоли на наличие ошибок.
- ✓ Ручной тест сохранения в черновики (Добавлен в Allure TestOps).
- ✓ Ручной тест удаления письма (Добавлен в Allure TestOps).

[К содержанию](#pushpin-содержание)

## :computer: Параметры запуска тестов из терминала

Локальный запуск тестов из терминала выглядит следующим образом: \
(для параметров browser, browserVersion и browserSize существуют значения по умолчанию, остальные параметры не обязательны)
```
gradle clean task \
-Dbrowser=browser \
-DbrowserVersion=browserVersion \
-DbrowserSize=browserSize \
-DbrowserMobileView=browserMobileView \
-DremoteDriverUrl=remoteDriverUrl \
-DvideoStorage=videoStorage
-Dthreads=threads
```
- ```task``` - в данном случае один - ui_tests \
- ```browser``` - задать браузер (по умолчанию chrome) \
- ```browserVersion``` - задать версию браузера (по умолчанию 100.0) \
- ```browserSize``` - задать разрешение браузера (по умолчанию 1920x1080) \
- ```browserMobileView``` - задать мобильный вид страницы, если требуется \
- ```remoteDriverUrl``` - url сервера удаленного запуска \
- ```videoStorage``` - url удаленного хранилища видео \
- ```threads``` - для запуска в несколько потоков, если требуется

Промер:
```bash
gradle clean ui_tests -Dbrowser=chrome -DbrowserVersion=100.0 -DbrowserSize=1920x1080
```

[К содержанию](#pushpin-содержание)

## <img src="images/logos/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a>Jenkins job
### <a target="_blank" href="https://jenkins.autotests.cloud/job/berezkindv_diploma_ui_tests_project/">Сборка в Jenkins</a>

####Параметры запуска в Jenkins:
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

- ```BRANCH``` - выбор ветки репозитория GitHub (по умолчанию main)
- ```TASK``` - выбор задачи (настройка build.gradle, по умолчанию ui_tests)
- ```BROWSER``` - выбор браузера (по умолчанию chrome)
- ```BROWSER_VERSION``` - задать версию браузера (по умолчанию 100.0)
- ```BROWSER_SIZE``` - задать разрешение браузера (по умолчанию 1920x1080)
- ```BROWSER_MOBILE``` - выбор девайса для имитации мобильного вида страницы (необязательный параметр)
- ```USER``` - логин удаленного сервера selenoid
- ```PASSWORD``` - пароль удаленного сервера selenoid
- ```REMOTE_DRIVER_URL``` - url удаленного сервера selenoid
- ```THREADS``` - Количество потоков

####Инструкция по запуску сборки в Jenkins:

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


[К содержанию](#pushpin-содержание)

## <img src="images/logos/Allure_Report.svg" width="25" height="25"  alt="Allure"/></a>Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/berezkindv_diploma_ui_tests_project/10/allure/">Allure report</a>

По завершении сборки можно обратиться к Allure отчету. \
В который входит:
- Протоколирование степов
- Графики прохождения тестов
- Таймлайн
- Различная сортировка тестов по статусу
- И многое другое

Также к каждому тесту прилагаются аттачменты содержащие скриншоты, xml с деревом документа, лог консоли и видео прохождения теста.

#### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure_report_dashboard.png">
</p>

#### Тесты

<p align="center">
<img title="Allure Tests" src="images/screenshots/allure_report_tests.png">
</p>

#### Графики

<p align="center">
<img title="Allure Graphics" src="images/screenshots/allure_report_graphs.png">
</p>

[К содержанию](#pushpin-содержание)

## <img src="images/logos/Allure_EE.svg" width="25" height="25"  alt="Allure"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/12018">Allure TestOps</a>

Так же можно обратиться к Allure TestOps для дальнейшей автоматизации проекта.

#### Дашборд

<p align="center">
<img title="Allure TestOps Dashboard" src="images/screenshots/testops_dashboard.png">
</p>

#### Тест-кейсы (добавляем ручные тесты)

<p align="center">
<img title="Allure TestOps Tests" src="images/screenshots/testops_added_manual_tests.jpg">
</p>

[К содержанию](#pushpin-содержание)

## <img src="images/logos/Telegram.svg" width="25" height="25"  alt="Allure"/></a>Уведомление в Telegram при помощи бота
По завершении всех операций телеграм бот отправит отчет со статистикой:
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/telegram_bot.png">
</p>

[К содержанию](#pushpin-содержание)

### <img src="images/logos/Selenoid.svg" width="25" height="25"  alt="Allure"/></a>Примеры видео о прохождении тестов

<p align="center">
<img title="Selenoid Video" src="images/screenshots/video_logintest.gif" width="250" height="153"  alt="video"> <img title="Selenoid Video" src="images/screenshots/video_sendmailtest.gif" width="250" height="153"  alt="video">
</p>

[К содержанию](#pushpin-содержание)