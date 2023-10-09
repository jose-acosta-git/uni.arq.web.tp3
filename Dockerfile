# Use the official OpenJDK image as the base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at the specified location
COPY target/integrador3-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]
