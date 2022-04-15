# Присутствие на мероприятии

_Ответственность: явка присутствия на мероприятии._


## Сценарии использования

![usecase1](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/Presence-Controller.png)

![usecase2](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/Presence-Visitor.png)

## Пользовательские истории

Как Контролер я хочу знать количество участников, посетивших мероприятие.

Как Посетитель я хочу зафиксировать свое присутствие на мероприятии.

## Модель данных

![data-model-diagram](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/Presence-model.png)

## API сервиса

/api/presence/send — фиксация присутствия

/api/getNameTopic — получение по топику списка с количеством участников
