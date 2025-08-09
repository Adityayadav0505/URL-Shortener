# Use OpenJDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in container
WORKDIR /app

# Copy Maven wrapper & pom.xml first (to cache dependencies)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cached for faster builds)
RUN ./mvnw dependency:go-offline

# Copy the rest of the project
COPY src ./src

# Package the application
RUN ./mvnw package -DskipTests

# Run the jar file
CMD ["java", "-jar", "target/URL-Shortener-0.0.1-SNAPSHOT.jar"]
