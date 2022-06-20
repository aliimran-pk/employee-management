FROM openjdk:11
COPY ./target/employee-management-0.0.1-SNAPSHOT.jar employee-management-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","employee-management-0.0.1-SNAPSHOT.jar"]