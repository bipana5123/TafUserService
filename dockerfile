# Use an OpenJDK 17 image as the base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY build/libs/TafUserService-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on (optional but recommended)
EXPOSE 8080

# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]