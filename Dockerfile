FROM eclipse-temurin:17-jdk-alpine as jdk
VOLUME /tmp
WORKDIR /app

COPY mvnw ./
COPY .mvn/ .mvn
COPY pom.xml ./
COPY src ./src
EXPOSE 8080
#CMD ["./mvnw","spring-boot:run"]
RUN ./mvnw package

COPY target*.jar app.jar


FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
WORKDIR /app
COPY --from=jdk /app/app.jar .

ENTRYPOINT["java","-jar","app.jar"]


