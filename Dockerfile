FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application's JAR file into the container
# Replace 'your-application.jar' with the actual name of your built JAR fileCOPY build/libs/bus.jar bus.jar
COPY build/libs/bus.jar bus.jar

# Expose the port your Spring Boot application listens on (default is 8080)
EXPOSE 8084

ENV JAVA_OPTS="-Xms1g -Xmx1g"

# Define the command to run the Spring Boot application
#ENTRYPOINT ["java","$JAVA_OPTS", "-jar", "/app/bus.jar"]  // exception when heap increased by env variable
ENTRYPOINT java $JAVA_OPTS -jar /app/bus.jar