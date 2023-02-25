FROM eclipse-temurin:17-jdk-alpine as jdk

WORKDIR /app

COPY mvnw ./
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src
EXPOSE 8080
#CMD ["./mvnw","spring-boot:run"]
RUN ./mvnw clean install


FROM eclipse-temurin:17-jre-jammy

WORKDIR /app
COPY --from=jdk /app/target/*.jar /app/*.jar

ENTRYPOINT["java","-jar","/app/*.jar"]


