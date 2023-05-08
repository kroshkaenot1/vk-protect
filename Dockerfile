FROM openjdk:19
WORKDIR /app
COPY ./target/*.jar vk-protect-application.jar

ENTRYPOINT ["java","-jar","/app/vk-protect-application.jar"]
