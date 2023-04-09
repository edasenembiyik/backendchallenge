FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
ADD build/libs/backendchallenge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]