FROM openjdk:12-alpine

COPY build/libs/service-payment.jar /opt/service-payment.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-payment.jar" ]
