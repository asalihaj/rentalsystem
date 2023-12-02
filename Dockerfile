# Use an official Maven image as the build stage
FROM maven:3.8-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project file to the working directory
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline

# Copy the entire project to the working directory
COPY . .

# Build the Maven project
RUN mvn package

# Use an official OpenJDK image as the runtime stage
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Expose the port
EXPOSE 8080

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /app/target/rental-system.jar rental-system.jar

# Set the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]
