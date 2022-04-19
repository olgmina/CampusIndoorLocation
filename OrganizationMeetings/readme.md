# Сервис организации мероприятия

_Ответственность:_ создание, изменение,просмотр и удаление записи о создаваемых Организатором мероприятиях.

Создание подразумевает опредление времени, места и заказ обрудования.


## Сценарий использования

![image](https://user-images.githubusercontent.com/49455695/163052384-5c24193e-b9ce-46af-a84e-52163810835b.png)

## Пользовательские истории

Как Организатор я хочу создать свое мероприятие

Как Участник я хочу получить информацию о мероприятии Организатора

Как Руководитель я хочу знать о всех мероприятиях Организатора, которое запланированы и проведены

## Модель данных
![image](https://user-images.githubusercontent.com/49455695/163654049-a248b3ff-5173-4a20-9988-e1b80c7395ad.png)

## Диаграмма классов
![image](https://user-images.githubusercontent.com/49455695/163878500-3affab79-a5d5-4306-9208-ccc8f8a85b9e.png)

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

# Сервис организации мероприятий 

Планирование мероприятия образовательного процесса

## Сценарий использования

![image](https://user-images.githubusercontent.com/49455695/163654401-6156490f-9c76-4a7e-8b23-be0145698afd.png)

## Пользовательские истории

Как Организатор я хочу изменить время/место/  моего мероприятия

Как Участник я хочу знать где/когда проводит такое-то мероприятие

Как Руководитель я создаю расписание мероприятий

## Модель данных

![image](https://user-images.githubusercontent.com/49455695/163876855-f4c57e8c-9529-40db-b4be-4549c29c0ac1.png)

## API сервиса

get /meeting </br>
get /meeting/{id} </br>
post /meeting </br>
delete /meeting/{id} </br>

## Диаграмма вариантов использования
![image](https://user-images.githubusercontent.com/49455695/163876490-ec827402-00e5-4ab3-9570-6abae252d61b.png)

## Диаграмма классов
![image](https://user-images.githubusercontent.com/49455695/163875682-4a08186f-846f-482e-82bf-86aa52c14fc1.png)

## kafka docker

1)Запустить файл docker-compose.yml для создания сервера kafka

```yml
---
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.0.1
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  broker:
    image: confluentinc/cp-kafka:7.0.1
    container_name: broker
    ports:
    # To learn about configuring Kafka for access across networks see
    # https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
```

2) В powershell </br>
   docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic purchases --from-beginning</br> (Команда получения сообщений из топика) </br>

