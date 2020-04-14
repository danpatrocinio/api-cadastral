FROM openjdk:8-jdk-alpine
RUN addgroup -S apicadastral && adduser -S apicadastral -G apicadastral
USER apicadastral:apicadastral
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-cadastral.jar
ENTRYPOINT ["java","-jar","/api-cadastral.jar"]