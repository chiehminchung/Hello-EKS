FROM openjdk:17
EXPOSE 8080
ADD target/HelloEks-0.0.1-SNAPSHOT.jar hello.jar
ENTRYPOINT ["java", "-jar", "hello.jar"]