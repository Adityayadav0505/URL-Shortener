FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src ./src

# Package the app
RUN mvn package -DskipTests

# Second stage: create final image
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/URL-Shortener-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
