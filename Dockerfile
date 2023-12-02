FROM maven:latest AS build

WORKDIR /app

COPY pom.xml .
COPY src src

RUN mvn package

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /app/target/rental-system.jar rental-system.jar

ENTRYPOINT ["java", "-jar", "rental-system.jar"]
