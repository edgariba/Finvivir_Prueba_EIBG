# Examen Técnico Finvivir

## Instrucciones DOCKER MYSQL

### Descargamos una imagen
Lo primero que hay que hacer es descargar el contenedor de Mysql con el siguiente comando (dejar el comando como se escribio).

docker run -d -p 33060:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret mysql

### Pasos para acceder al contenedor MYSQL

docker exec -it mysql-db mysql -uroot -p

* La base de datos creada se llama: weatherFinvivir
* La tabla creada se llamada: t_weather