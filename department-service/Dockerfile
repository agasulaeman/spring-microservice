#Compile
FROM maven:3-jdk-11-slim AS department-service
MAINTAINER gangzar.agas
USER root
WORKDIR /app
ADD pom.xml /app/pom.xml
#RUN mvn verify clean
COPY . /app
RUN mvn -v
RUN mvn package



# Package Stage
FROM openjdk:latest
WORKDIR /app/deploy
COPY --from=department-service /app/target/*.jar /app/deploy/app-test-agas.jar

#RUN chmod +x /app/deploy/app-orchestra.jar

ENTRYPOINT ["java","-jar","/app/deploy/app-test-agas.jar"]


