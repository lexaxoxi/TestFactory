Fullstack web - application with CRUD operations 
for DataBase with 3 spieces of entityes


Add backend & frontend

Technologies:
* Java + Spring Boot;
* JavaScript + VueJs 3;
* БД H2 embedded
* тестировалось c помощью Postman


Запуск

## Запускаем бэк:

1. запускаем main-class TestFactoryApplication.java
2. переходим в БД http://localhost:8080/h2-console
3. вводим данные
    username: postgres
    password:
    jdbc url: jdbc:h2:mem:factoryDB
    driverClassName: org.h2.Driver

для наглядности, можно ввеcти sql запрос из файла data.sql(в основном sql ругается на иерархию отделов)


## Запускаем front:

в терминале переходим в *\vue-project>
пишем
npm install 
npm run dev

переходим на предложенную ссылку


# Что не реализовано:
1. Через приложение не добавляются сотрудники, в JSON уходят пустые поля
2. Не смог сделать редактирование
3. Хотел сделать более легкий сбор проекта и запуск: через 2 модуля и третьим родительским pom.xml запускать
     