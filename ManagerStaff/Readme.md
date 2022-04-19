# Сервис управления персоналом

Ответственность: создание, изменение,просмотр и удаление записи о персонале

## Пользовательские истории

Как Организатор я хочу изменить время/место/оборудование _моего_ мероприятия

Как Персонал я хочу знать где/когда/кто проводится мероприятия, использующие оборудование

Как Руководитель я добавляю и удаляю запись о персонале
 ## Сценарий 1

![image](https://user-images.githubusercontent.com/82897496/164002388-e01a9611-b6db-4bb5-b760-af5170dd8af0.jpeg)


 ## Сценарий 2
![image](https://user-images.githubusercontent.com/82897496/164002416-61cb12b0-9089-4d57-b227-7bdd28549886.jpeg)


 ## Сценарий 3
![image](https://user-images.githubusercontent.com/82897496/164002432-7068d518-3fe0-4fe3-afe7-20c490114b7d.jpeg)



## Модель данных
![3 drawio](https://user-images.githubusercontent.com/82897496/163939607-78d28ede-680e-4d6d-95c2-03700f9df23e.png)

## Зависимости
![image](https://user-images.githubusercontent.com/82897496/163626377-7cd3255e-5b7e-4b8d-9a45-8152ad953572.png)

## API сервиса
/api/managerStaff — список всех сотрудников

/api/managerStaff/{StaffId} — Информация о конкретном сотруднике

/api/managerStaff/add — добавление сотрудника

/api/delete — удаление списка сотрудников
/api/managerstaff/{id} - удаление данных о сотруднике
