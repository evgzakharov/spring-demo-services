FROM frolvlad/alpine-oraclejre8:8.192.12-slim

COPY build/libs/service-auth.jar /opt/service-auth.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-auth.jar" ]
