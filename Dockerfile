FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

COPY mvnw ./
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src
#
#CMD ["./mvnw","spring-boot:run"]
CMD ["mvn","package"]


FROM eclipse-temurin:17-jdk-alpine AS runner
#
WORKDIR /app
EXPOSE 8080
COPY target/user-mangement-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]

CMD java - jar user-mangement-0.0.1-SNAPSHOT.jar






