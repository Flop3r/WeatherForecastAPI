FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/weatherforecast-api-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]