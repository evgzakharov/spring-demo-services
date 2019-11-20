FROM openjdk:12-alpine

COPY build/libs/service-user.jar /opt/service-user.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-user.jar" ]
