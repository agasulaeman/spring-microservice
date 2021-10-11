#Compile
FROM maven:3-jdk-11-slim AS test
MAINTAINER dian.setiyadi
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
COPY --from=test /app/target/*.jar /app/deploy/app-orchestra.jar

#RUN chmod +x /app/deploy/app-orchestra.jar

ENTRYPOINT ["java","-jar","/app/deploy/app-orchestra.jar"]


