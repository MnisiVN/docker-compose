# Use a base image with Java (JRE)
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/docker-compose-0.0.1-SNAPSHOT.jar /app/docker-compose.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "docker-compose.jar"]