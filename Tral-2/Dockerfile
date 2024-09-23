FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/Tral-2-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
