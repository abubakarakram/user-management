FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
VOLUME /app-vol
EXPOSE 8080
ADD target/user-mangement-0.0.1-SNAPSHOT.jar user-management.jar


ENTRYPOINT ["java", "-jar", "/user-management.jar"]

#RUN ./mvnw install





#COPY mvnw ./
#COPY .mvn/ .mvn
#COPY pom.xml ./
#COPY src ./src
#CMD ["./mvnw","package"]
#
#ENTRYPOINT ["./mvnw","spring-boot:run"]


#CMD java - jar target/user-mangement-0.0.1-SNAPSHOT.jar
#FROM eclipse-temurin:17-jdk-alpine AS runner
#WORKDIR /app
#
#
#COPY --from=builder target/user-mangement-0.0.1-SNAPSHOT.jar /app.jar
##CMD ["java", "-jar", "/app.jar"]
#
#CMD java - jar user-mangement-0.0.1-SNAPSHOT.jar






