# Stage 1: Build the application
FROM maven:3.6.3-jdk-11 as builder

WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:resolve

COPY src src
RUN mvn -B package

# Stage 2: Run the application
FROM openjdk:11.0.7-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
