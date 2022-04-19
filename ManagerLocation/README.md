# Сервис уведомлений

Ответственность: создание, изменение,просмотр и удаление записи об аудиториях и прочих помещениях Университета

## Use-case Диаграммы:
 Сценарий 1
![1 drawio (4)](https://user-images.githubusercontent.com/76588508/164013816-5432b81e-4842-400f-8d97-c7a2209574b5.png)
 
 Сценарий 2
![1 drawio (5)](https://user-images.githubusercontent.com/76588508/164013845-412559eb-e1e0-464d-afed-53cb415e3377.png)

## Пользовательские истории

Как организатор хочу занять аудиторию

Как администратор хочу создать/изменить/удалить действующую занятость

## Диаграмма размещения
![12](https://user-images.githubusercontent.com/76588508/164014089-a8d8159e-0c60-48fd-84ec-04c228aaba4b.jpg)

## Модель данных
![12 drawio](https://user-images.githubusercontent.com/76588508/164015862-cb18507f-6bab-400b-9838-691194f0cf9a.png)

## Диграмма зависимостей
![9d39e576-44a8-498d-919f-1b672180564f](https://user-images.githubusercontent.com/76588508/164016691-2ee558fb-86e0-4ee7-9b01-4a33387e7ff9.jpg)

## API сервиса

/api/managerlocation — список всех аудиторий

/api/managerlocation/{locationId} — конкретное аудитория

/api/managerlocation/add — добавление аудитории

/api/delete — удалить всё рассписание аудотрий

/api/delete/{locationId} - удалить конкретное рассписание аудитоии
