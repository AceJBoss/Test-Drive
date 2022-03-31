FROM openjdk:8
EXPOSE 8083
ADD target/employee-vehicle.jar employee-vehicle.jar
ENTRYPOINT ["java", "-jar", "/employee-vehicle.jar"]