FROM openjdk:17-jdk-slim
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY . .
RUN ./mvnw clean package
CMD ["java", "-jar", "target/Tral-2-0.0.1-SNAPSHOT.jar"]
