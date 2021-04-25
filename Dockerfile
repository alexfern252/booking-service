FROM openjdk:8-jdk-alpine
MAINTAINER Alexandre Fernandes
COPY target/*.jar $APP_HOME/application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
