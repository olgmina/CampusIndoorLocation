# Сервис управления персоналом

Ответственность: создание, изменение,просмотр и удаление записи о персонале

## Пользовательские истории

Как Организатор я хочу изменить время/место/оборудование _моего_ мероприятия

Как Персонал я хочу знать где/когда/кто проводится мероприятия, использующие оборудование

Как Руководитель я добавляю и удаляю запись о персонале
 ## Сценарий 1
![Organize](https://user-images.githubusercontent.com/82897496/164001718-a13a1a81-ed5f-4359-b753-2ff3855778d1.jpeg)


 ## Сценарий 2
 ![director](https://user-images.githubusercontent.com/82897496/164001514-e9c0951a-e005-41c5-9dcf-70f3cd40d0a6.jpeg)

 ## Сценарий 3
 ![Staff](https://user-images.githubusercontent.com/82897496/164001530-a8fbde2d-666d-444d-a7a4-061684c38c4d.jpeg)


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
