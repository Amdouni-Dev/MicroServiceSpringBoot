FROM openjdk:17
EXPOSE 8089
ADD target/CandidateMS-0.0.1-SNAPSHOT.jar CandidateMS-docker.jar
ENTRYPOINT ["java","-jar","CandidateMS-docker.jar"]
