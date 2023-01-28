FROM openjdk:10-jre-slim

WORKDIR /app
COPY ./target/miportfolio-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "miportfolio-0.0.1-SNAPSHOT.jar"]