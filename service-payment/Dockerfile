FROM frolvlad/alpine-oraclejre8:8.192.12-slim

COPY build/libs/service-payment.jar /opt/service-payment.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-payment.jar" ]
