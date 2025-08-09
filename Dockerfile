FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
COPY target/*.jar /opt/order-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar order-service.jar