FROM openjdk:19
WORKDIR /app
COPY ./target/*.jar vk-protect-application.jar

CMD ["sh","-c","sleep 15 && java -jar /app/vk-protect-application.jar"]
