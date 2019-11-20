FROM openjdk:8-alpine3.9

COPY build/libs/service-payment.jar /opt/service-payment.jar

EXPOSE 8080

CMD [ "java", "-jar", "/opt/service-payment.jar" ]
