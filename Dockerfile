# Use the official OpenJDK image as a parent image
FROM openjdk:21-rc-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Package the application using Maven
RUN ./mvnw package -DskipTests

# Expose the port the app runs on
EXPOSE 8100

# Run the jar file
CMD ["java", "-jar", "currency-conversion-service-0.0.1-SNAPSHOT.jar"]