FROM openjdk:8-alpine3.9

COPY build/libs/service-user.jar /opt/service-user.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-user.jar" ]
