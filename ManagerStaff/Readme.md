# Сервис управления персоналом

Ответственность: создание, изменение,просмотр и удаление записи о персонале

## Пользовательские истории

Как Организатор я хочу изменить время/место/оборудование _моего_ мероприятия

Как Персонал я хочу знать где/когда/кто проводится мероприятия, использующие оборудование

Как Руководитель я добавляю и удаляю запись о персонале
 ## Сценарий 1
![Organize jpeg drawio](https://user-images.githubusercontent.com/82897496/164017164-06ff8835-749e-405e-b429-e7c4cc0539c7.png)
## Сценарий 2
![Staff drawio](https://user-images.githubusercontent.com/82897496/164059669-5f5d9b55-7a2d-43d5-af1f-5e944c92d5ed.png)


## Модель данных
![3 drawio](https://user-images.githubusercontent.com/82897496/163939607-78d28ede-680e-4d6d-95c2-03700f9df23e.png)
## Диаграмма размещения
![диаграмма размещения](https://user-images.githubusercontent.com/82897496/164014823-29b00e63-c4b9-4cbe-94da-100e7a111c3b.jpg)

## Зависимости
![pom](https://user-images.githubusercontent.com/82897496/164015499-0fdac1d9-c626-487e-a303-78c039aed5ce.png)

## API сервиса
/api/managerStaff — список всех сотрудников
/api/managerStaff/{StaffId} — Информация о конкретном сотруднике
/api/managerStaff/add — добавление сотрудника
/api/delete — удаление списка сотрудников
/api/managerstaff/{id} - удаление данных о сотруднике
