
# Сервер-запрос
Цель: поиск информации о мероприятии по заданным параметрам.

В него входят:

-Поиск по локации;

-Поиск по названию мероприятия;

-Поиск по организатору;

-Поиск по времени;

-Поиск по дню недели.

## Необходимые компоненты

-Intelji idea

-Java

-База данных(MySQL)

Установите и подключите базу данных к Intelji idea. После подключения и запуска приложения в базе данных автоматически создастся таблица.

## Сценарий использования
# ![сценапий.png](https://github.com/Lyana2021/CampusIndoorLocation/blob/main/Planer/%D1%81%D1%86%D0%B5%D0%BD%D0%B0%D0%BF%D0%B8%D0%B9.png)


## Диаграмма размещения
# ![Untitled Diagram.drawio.png](https://github.com/Lyana2021/CampusIndoorLocation/blob/main/Planer/Untitled%20Diagram.drawio.png)


## Диаграмма класса БД
# ![бд.jpg](https://github.com/Lyana2021/CampusIndoorLocation/blob/main/Planer/titul.png)

## Результат
# ![titul.png](https://github.com/Lyana2021/CampusIndoorLocation/blob/main/Planer/titul.png)

# ![titul2.png](https://github.com/Lyana2021/CampusIndoorLocation/blob/main/Planer/titul2.png)

## Пользовательские истории

Как Организатор я хочу, чтобы участники были уведомлены о событииях, которые будут или уже идут

Как Участник  я хочу знать где/когда/кто проводится определенное мероприятие

Как Руководитель я хочу, чтобы участники были уведомлены о событииях, которые будут или уже идут

## Зависимости
# ![DC.jpg](https://github.com/Lyana2021/CampusIndoorLocation/blob/main/Planer/DC.jpg)



## API сервиса

api/location/{Id} -выводит страницу с запросом на локацию

api/dayOfWeek/{Id} -выводит страницу с запросом на день недели

api/Org/{Id}-выводит  страницу с запросом на ФИО организатора

api/name/{Id} -выводит страницу с запросом на название мероприятия/учебного предмета

api/time/{Id} -выводит страницу с запросом на время



