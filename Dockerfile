# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the entire project (including pom.xml and source files) into the container
COPY . /app

# Build the project using Maven
RUN mvn clean install

# Copy the JAR file generated by Maven into the container
COPY target/expensetracker-0.0.1-SNAPSHOT.jar /app/expensetracker.jar

# Run the JAR file
CMD ["java", "-jar", "expensetracker.jar"]
