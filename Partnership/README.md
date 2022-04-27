# Сервис Партнёрства

Цель: просмотр мероприятий, требующих регистрации; 
Для Участника получение уведомления с просьбой об участии в мероприятии;
Будущему помощнику по профилям работ получение подтверждения и сообщение об этом Организатору для утверждения


## Необходимые компоненты

-Intelji idea

-Java

-База данных(PostgreSQL)

Установите и подключите базу данных к Intelji idea. После подключения и запуска приложения в базе данных автоматически создастся таблица.

## Сценарий использования №1
# ![сценапий.png](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/user_case.drawio%20(2).png?raw=true)

## Сценарий использования №2
# ![сценапий2.png](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/user_case_2.drawio%20(2).png?raw=true)


## Диаграмма размещения
# ![Untitled Diagram.drawio.png](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/Untitled%20Diagram.png?raw=true)

## Диаграмма класса БД
# ![бд.jpg](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/%D0%91%D0%94%20(2).jpg?raw=true)

## Результат

# ![titul.png](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/%D0%9F%D1%80%D0%B8%D0%BC%D0%B5%D1%80%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B.jpg?raw=true)

# ![titul2.png](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/%D0%9F%D1%80%D0%B8%D0%BC%D0%B5%D1%80%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B%201.jpg?raw=true)

# ![titul3.png](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/%D0%9F%D1%80%D0%B8%D0%BC%D0%B5%D1%80%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B%202.jpg?raw=true)

## Пользовательские истории

Как Участник я хочу просматривать мероприятия и иметь возможность зарегистрироваться на них. 

Как Будущий помощник я хочу иметь возможность зарегистрироваться с просьбой об участии в мероприятии



## Зависимости
# ![DC.jpg](https://github.com/olgmina/CampusIndoorLocation/blob/main/Partnership/SpringBootEnrolApplication.png?raw=true)



## API сервиса


api/index – выводит главную страницу с меню

api/table/{id} – выводит страницу с мероприятиями и фильтром

api/form_reg – выводит страницу с регистрацией на мероприятие


