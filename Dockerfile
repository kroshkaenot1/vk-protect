FROM adoptopenjdk/openjdk19:alpine-jre
WORKDIR /app
COPY ./target/*.jar vk-protect-application.jar
ENTRYPOINT ["java","-jar","/vk-protect-application.jar"]
