# Сервис локаций

Ответственность: создание, изменение,просмотр и удаление записи об аудиториях и прочих помещениях Университета

## Сценарий использования

![image](https://user-images.githubusercontent.com/49455695/163052384-5c24193e-b9ce-46af-a84e-52163810835b.png)

## Пользовательские истории

Как Организатор я хочу изменить место _моего_ мероприятия

Как Участник я хочу знать когда проводится такое-то мероприятия использующие оборудование

Как Руководитель я оцениваю загруженность помещений по времени

## Модель данных
![image](https://user-images.githubusercontent.com/49455695/163654049-a248b3ff-5173-4a20-9988-e1b80c7395ad.png)


## API сервиса

get /api/location </br>
get /api/location/{id}</br>
delete /api/location/{id}</br>
post /api/location</br>
``` json
    "id": 1,
    "name": "Актовый зал",
    "description": "актовый",
    "equipmentList": [
      {
        "id": 1,
        "name": "Компьюетер",
        "description": "Хорошое состояние",
        "conditions": "Чёрный"
      },
      {
        "id": 2,
        "name": "Монитор",
        "description": null,
        "conditions": "Белый"
      }
    ],
    "locationTime": {
      "id": 1,
      "timeStart": "2022-04-15 03:57:38",
      "timeEnd": "2022-04-16 03:57:40"
    }
  
```
