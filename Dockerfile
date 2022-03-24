FROM openjdk:8
EXPOSE 8080
ADD target/test-drive.jar test-drive.jar
ENTRYPOINT ["java","-jar","/test-drive.jar"]