# Курсовой проект "Сервис перевода денег"
## Описание проекта
Разработано приложение - REST-сервис. Сервис прдоставляет интерфейс для перевода денег с одной карты на другую по заранее описанной спецификации. 
Заранее подготовленное веб-приложение (FRONT) подключается к разработанному сервису без доработок и использует его функционал для перевода денег.
## Запуск приложения
### Фронт
  1. ul Установить по вложеной инструкции UI для перевода денег https://github.com/serp-ya/card-transfer.
  1. ul Из архива cardtf_dockerfiles.rar в ЭТОМ репозитории извлечь файл Dockerfile и и поместить его в корень скачаного UI.
  1. ul Выполнить упаковку Ui в докер-контейнер с именем образа "frontend" без кавычек.

### Бэк
  1. ul Склонировать репозиторий https://github.com/AndreyE-lance/moneytf.git.
  1. ul Упаковать в докер-контейнер с именем образа "money_tf" без кавычек.
  1. ul Запустить UI командой *docker compose up -d frontend*
  1. ul Запустить сервис перевода денег командой *docker compose up -d money_tf*
  1. ul В браузере перейти по адресу http://localhost:3000/card-transfer;
## Использование приложения
Для испольлзования приложения необходимо ввести в соответствующие поля номер карты отправителя, дату истечения срока действия карты, 
CVV, а так же номер карты получателя и сумму для перевода. Далее - нажать кнопку отпраить. В результате вы получите сообщение 
об успешном переводе или ошибке перевода средств.
