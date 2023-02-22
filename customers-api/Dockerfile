FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customersapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/customersapi-0.0.1-SNAPSHOT.jar"]