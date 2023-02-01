FROM maven:3.8.7-eclipse-temurin-17
COPY target/miportfolio-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]