FROM openjdk:12-alpine

COPY build/libs/service-auth.jar /opt/service-auth.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-auth.jar" ]
