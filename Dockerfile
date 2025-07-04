FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application's JAR file into the container
# Replace 'your-application.jar' with the actual name of your built JAR file
COPY target/bus.jar bus.jar

# Expose the port your Spring Boot application listens on (default is 8080)
EXPOSE 8084

# Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "bus.jar"]