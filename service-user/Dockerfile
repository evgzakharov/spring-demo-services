FROM frolvlad/alpine-oraclejre8:8.192.12-slim

COPY build/libs/service-user.jar /opt/service-user.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-user.jar" ]
