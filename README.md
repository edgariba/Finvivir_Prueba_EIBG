# Examen Técnico Finvivir Edgar Ivan Barrera Guerrero

## Requerimientos

* Docker

## 1.- Crear Network

* docker network create examen-mysql

## 2.- Instrucciones DOCKER MYSQL

* docker container run --name mysqldb --network examen-mysql -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=weatherFinvivir -d -p 3306:3306 mysql:8

Consultar los LOGS del container Mysql y verificar que arranco exitosamente y continuar con el siguiente paso

## 3.- Construir y ejecutar imagen de proyecto Spring boot
* Clonar repositorio con GIT
* Descomprimir la carpeta "compilado" adjunta en el root del proyecto
* Para levantar el contenedor dirigirse por consola a la carpeta "compilado"

Ejecutar los siguientes comandos
* docker image build -t pruebaeibg .
* docker container run --network examen-mysql --name pruebaeibg-container -p 8080:8080 -d pruebaeibg

Consultar los LOGS del container SpringBoot y verificar que arranco exitosamente y probar los endpoints con postman.

## Proyecto Spring boot

* clonar el proyecto con git
* Generar nuevo compilado jar: mvn clean package
* Dirigirse por consola al root del proyecto donde este el DockerFile

Ejecutar los siguientes comandos
* docker image build -t pruebaeibg .
* docker container run --network examen-mysql --name pruebaeibg-container -p 8080:8080 -d pruebaeibg


Consultar los LOGS del container SpringBoot y verificar que arranco exitosamente y probar los endpoints con postman.

### Pasos para acceder al contenedor MYSQL

* docker exec -it mysqldb mysql -uroot -p

* La base de datos creada se llama: weatherFinvivir
* La tabla creada se llamada: t_weather