From public.ecr.aws/docker/library/openjdk:latest
copy ./target/employee-management-0.0.1-SNAPSHOT.jar employee-management-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","employee-management-0.0.1-SNAPSHOT.jar"]
