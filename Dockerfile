# Use an official Maven image as the build stage
FROM maven:3.8-jdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files (if available)
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn

# Copy the project files
COPY pom.xml .
COPY src src

# Build the application using Maven
RUN ./mvnw package

# Use the official OpenJDK image as the runtime stage
FROM openjdk:17-jdk-slim

# Expose the application's port
EXPOSE 8080

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /app/target/rental-system.jar rental-system.jar

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "rental-system.jar"]
