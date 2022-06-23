# Examen Técnico Finvivir Edgar Ivan Barrera Guerrero

## Requerimientos

* Docker

Para docker
* 1- crear el network
* 2- levantar el contenedor de Mysql
* 3- Segundo: levantar el contenedor de SpringBoot

## Crear Network

* docker network create examen-mysql

## Instrucciones DOCKER MYSQL

* docker container run --name mysqldb --network examen-mysql -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=weatherFinvivir -d -p 3306:3306 mysql:8

Verificar que Mysql arranco exitosamente y continuar con el siguiente paso


## Instrucciones DOCKER PROYECTO SPRING BOOT

* Dirigirse por consola al root del proyecto donde este el DockerFile
* mvn clean package
* docker image build -t pruebaeibg .
* docker container run --network examen-mysql --name pruebaeibg-container -p 8080:8080 -d pruebaeibg

Verificar que SpringBoot arranco exitosamente y probar los endpoints con postman.

### Pasos para acceder al contenedor MYSQL

* docker exec -it mysqldb mysql -uroot -p

* La base de datos creada se llama: weatherFinvivir
* La tabla creada se llamada: t_weather