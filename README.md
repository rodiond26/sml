### Запуск приложения в Docker

Требования:

- установлен git
- установлен docker

```shell
git clone https://github.com/rodiond26/sml.git
```

```shell
cd sml
```

```shell
docker-compose up -d --build
```

Swagger

- http://localhost:8080/sml/swagger-ui/index.html

Скачать актуальный swagger (yaml)

- http://localhost:8080/sml/v3/api-docs.yaml

Исходная версия БД загружается с помощью файлов:

- [001-schema.sql](./sql/001-schema.sql)
- [002-data.sql](./sql/002-data.sql)

---

### Локальный запуск приложения

Требования:

- установлен git
- установлен JDK11
- установле PostgreSQL 14

Отредактировать файлы:

- [application.yml](./src/main/resources/application.yml)

```yaml
spring:
  profiles:
    active: DEV,dev  # исправить профиль
#   active: PROD,prod
```

- [application-dev.yml](./src/main/resources/application-dev.yml)

```yaml
spring:
  datasource:
    driverClassName: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/postgres # исправить хост
    username: postgres # исправить логин
    password: 1qaz2wsx # исправить пароль
```

Развернуть исходную версию БД с помощью файлов:

- [001-schema.sql](./src/main/resources/sql/001-schema.sql)
- [002-data.sql](./src/main/resources/sql/002-data.sql)

---

### Задание

Критерий для кода Java:

1. работа с транзакциями и блокировками
2. использование ORM с работой с вложенными сущностями
3. Rest-клиент
4. работа с сокетами (TCP, UDP)
5. реактивный код (желательно с использованием Reactor)

Тестовое задание;

Реализовать REST АПИ для клиентского приложения, которое должно отображать страницу со списком студентов с
возможностями:

1. добавить нового студента в список;
2. удалить существующего студента;
3. отредактировать существующего студента;
4. внести изменения названий (поле text) в справочнике успеваемости. Исходные значения:
   [{id 2, text "неуд"}, {id 3, text "уд"}, {id 4, text "хор"}, {id 5, text "отл"}]

У студента есть поля:

- ФИО
- дата рождения
- успеваемость (опционально, значение из справочника)

Стек:
Java, Spring Framework, PostgreSQL, swagger

Сопутствующие требования:

1. инструкция по разворачиванию исходной версии СУБД;
2. автогенерация swagger-документации на основании исходного кода;
3. валидация
