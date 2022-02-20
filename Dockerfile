FROM java:8-jdk-alpine
MAINTAINER Zeynel Acar
EXPOSE 8080
ADD ./target/project-0.0.1-SNAPSHOT.jar project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","project-0.0.1-SNAPSHOT.jar"]
