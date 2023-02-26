FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

COPY mvnw ./
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src
EXPOSE 8080
#CMD ["./mvnw","package"]
#
ENTRYPOINT ["./mvnw","spring-boot:run"]


#CMD java - jar target/user-mangement-0.0.1-SNAPSHOT.jar
#FROM eclipse-temurin:17-jdk-alpine AS runner
#WORKDIR /app
#
#
#COPY --from=builder target/user-mangement-0.0.1-SNAPSHOT.jar /app.jar
##CMD ["java", "-jar", "/app.jar"]
#
#CMD java - jar user-mangement-0.0.1-SNAPSHOT.jar






