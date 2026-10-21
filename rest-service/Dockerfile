# Step 1: Explicitly pin the exact Maven 4 and JDK 27 version tag to bypass caching
FROM maven:4.0.0-rc-7-eclipse-temurin-26 AS build
WORKDIR /app

# Copy the entire project codebase over
COPY rest-service/pom.xml ./
COPY rest-service/src ./src

# Force a clean production package build while skipping unit tests
RUN mvn clean package -DskipTests

# Step 2: Use the exact clean Java 27 runtime container to execute the code
FROM eclipse-temurin:26-jre
WORKDIR /app

# Since it's a multi-module setup, copy the built jar from the auth-service target folder
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
