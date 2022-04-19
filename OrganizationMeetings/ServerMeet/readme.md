# Сервис организации мероприятий 

Планирование мероприятия образовательного процесса

## Сценарий использования

![image](https://user-images.githubusercontent.com/49455695/163654401-6156490f-9c76-4a7e-8b23-be0145698afd.png)

## Пользовательские истории

Как Организатор я хочу изменить время/место/  моего мероприятия

Как Участник я хочу знать где/когда проводит такое-то мероприятие

Как Руководитель я создаю расписание мероприятий

## Модель данных

![image](https://user-images.githubusercontent.com/49455695/163654713-a3dca9d3-5b76-4fa6-8e26-c375f60b239e.png)

## API сервиса

get /meeting </br>
get /meeting/{id} </br>
post /meeting </br>
delete /meeting/{id} </br>

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

