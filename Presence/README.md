# Присутствие на мероприятии

_Ответственность: явка присутствия на мероприятии._

(Посетитель авторизован, находится на странице мероприятия и хочет поставить явку. Контролер с помощью фильтра узнает количество участников.)

## Сценарии использования

### Сценарий 1

![usecase1](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/Presence-Controller.png)

### Сценарий 2

![usecase2](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/Visitor.png)

## Пользовательские истории

Как Контролер я хочу знать количество участников, посетивших мероприятие.

Как Посетитель я хочу зафиксировать свое присутствие на мероприятии и оставить отзыв.

## Модель данных

### ERD-диаграмма

![data-model-diagram](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/model.png)

### Диаграмма классов для сценария 1

![diagram-class_controller](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/diag_class_controller.png)

### Диаграмма классов для сценария 2

![diagram-class_visitor](https://github.com/olgmina/CampusIndoorLocation/raw/main/Presence/diagrams/diag_class_visitor.png)

## API сервиса

/api/presence/send — фиксация присутствия

/api/getNameTopic — получение по топику списка с количеством участников
