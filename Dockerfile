FROM eclipse-temurin:17-jdk-alpine as jdk

WORKDIR /app

COPY mvnw ./
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src
EXPOSE 8080
#CMD ["./mvnw","spring-boot:run"]
RUN ./mvnw clean install

COPY target*.jar app.jar


FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=jdk /app/app.jar .

ENTRYPOINT["java","-jar","app.jar"]


