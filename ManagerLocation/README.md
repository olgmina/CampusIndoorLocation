# Сервис уведомлений

Ответственность: создание, изменение,просмотр и удаление записи об аудиториях и прочих помещениях Университета

## Use-case Диаграммы:
 Сценарий 1
 
![wdsf drawio](https://user-images.githubusercontent.com/76588508/166666427-17bf360b-c7ff-49f4-aa54-59577beccaff.png)
 
 Сценарий 2
 
![wdsf drawio (1)](https://user-images.githubusercontent.com/76588508/166666396-36dea743-b621-4f8d-8c8f-2a6b2dd43d35.png)

## Пользовательские истории

Как организатор хочу занять аудиторию

Как администратор хочу создать/изменить/удалить действующую занятость

## Диаграмма размещения
![12](https://user-images.githubusercontent.com/76588508/164014089-a8d8159e-0c60-48fd-84ec-04c228aaba4b.jpg)

## Модель данных
![12 drawio](https://user-images.githubusercontent.com/76588508/164015862-cb18507f-6bab-400b-9838-691194f0cf9a.png)

## API сервиса

/api/managerlocation — список всех аудиторий

/api/managerlocation/{locationId} — конкретное аудитория

/api/managerlocation/add — добавление аудитории

/api/delete — удалить всё рассписание аудотрий

/api/delete/{locationId} - удалить конкретное рассписание аудитоии

/api/GetFreeLocation - получение свободных аудиторий
