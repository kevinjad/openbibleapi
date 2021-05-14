FROM openjdk:11-jdk-slim
COPY build/libs/openbibleapi-0.0.1-SNAPSHOT.jar openbibleapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","openbibleapi-0.0.1-SNAPSHOT.jar"]