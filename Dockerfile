# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target folder to the container's working directory
COPY target/expensetracker-0.0.1-SNAPSHOT.jar /app/expensetracker.jar

# Run the JAR file
CMD ["java", "-jar", "expensetracker.jar"]
