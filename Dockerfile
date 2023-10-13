FROM openjdk:17
EXPOSE 8020
ADD target/Eureka-0.0.1-SNAPSHOT.jar EurekaMS-docker.jar
ENTRYPOINT ["java","-jar","EurekaMS-docker.jar"]
