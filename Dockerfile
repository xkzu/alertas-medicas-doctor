FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/*.jar app.jar
COPY wallet /wallet
ENV TNS_ADMIN=/wallet
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]