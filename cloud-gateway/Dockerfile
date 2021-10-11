#Compile
FROM maven:3-jdk-11-slim AS cloud-gateway-test
MAINTAINER gangzar.agas
USER root
WORKDIR /app
ADD pom.xml /app/pom.xml
#RUN mvn verify clean
COPY . /app
RUN mvn -v
RUN mvn package



# Package Stage
FROM openzipkin:zipkin-slim
WORKDIR /app/deploy
COPY --from=cloud-gateway-test /app/target/*.jar /app/deploy/app-cloud-gateway.jar

#RUN chmod +x /app/deploy/app-orchestra.jar

ENTRYPOINT ["java","-jar","/app/deploy/app-cloud-gateway.jar"]