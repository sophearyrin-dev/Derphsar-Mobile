From openjdk:11
ADD target/derphsar.jar derphsar.jar
ENTRYPOINT ["java","-jar","derphsar.jar"]
