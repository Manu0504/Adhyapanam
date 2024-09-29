FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY ./Tral-2/pom.xml ./
COPY ./Tral-2/src ./src
RUN mvn clean package
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/your-artifact-name.jar ./your-artifact-name.jar
CMD ["java", "-jar", "your-artifact-name.jar"]
