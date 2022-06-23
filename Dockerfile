FROM openjdk:8
COPY ./target/pruebaeibg-0.0.1-SNAPSHOT.jar pruebaeibg-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","pruebaeibg-0.0.1-SNAPSHOT.jar"]