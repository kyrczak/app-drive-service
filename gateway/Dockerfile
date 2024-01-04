FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title = "gateway-module"
LABEL org.opencontainers.image.authors="Patryk Korczak"
LABEL org.opencontainers.image.source="https://github.com/kyrczak/architektury_uslug_internetowych"
LABEL org.opencontainers.image.description="Gateway module"
LABEL org.opencontainers.image.version="1.0.0"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:spring-boot-starter-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASEPLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_ENABLED=true

ENV GATEWAY_MODULE_HOST=localhost:8080
ENV DISK_MODULE_URL=http://localhost:8081
ENV APPLICATION_MODULE_URL=http://localhost:8082

EXPOSE 8080

COPY ./target/gateway-${VERSION}.jar /opt/gateway-module/gateway-module.jar

CMD ["java", "-jar", "/opt/gateway-module/gateway-module.jar"]