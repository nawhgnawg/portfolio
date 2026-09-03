FROM gradle:8.10-jdk17 AS build

WORKDIR /workspace
COPY portfolio-api /workspace/portfolio-api
WORKDIR /workspace/portfolio-api
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /workspace/portfolio-api/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
