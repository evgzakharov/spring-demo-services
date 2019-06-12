FROM frolvlad/alpine-oraclejre8:8.192.12-slim

COPY build/libs/service-card.jar /opt/service-card.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-card.jar" ]
