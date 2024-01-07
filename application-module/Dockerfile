FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="application-module"
LABEL org.opencontainers.image.version="1.0.0"

ENV VERSION="1.0.0"
ENV SERVER_PORT=8080
EXPOSE 8080

COPY ./target/application-module-${VERSION}.jar /opt/application-module/application-module.jar

CMD ["java", "-jar", "/opt/application-module/application-module.jar"]