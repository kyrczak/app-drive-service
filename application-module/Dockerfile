FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title = "application-module"
LABEL org.opencontainers.image.authors="Patryk Korczak"
LABEL org.opencontainers.image.source="https://github.com/kyrczak/architektury_uslug_internetowych"
LABEL org.opencontainers.image.description="Application module"
LABEL org.opencontainers.image.version="1.0.0"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"
ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:spring-boot-starter-application
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASEPLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_ENABLED=true

ENV DISK_MODULE_URL=http://localhost:8081

EXPOSE 8080

COPY ./target/application-module-${VERSION}.jar /opt/application-module/application-module.jar

CMD ["java", "-jar", "/opt/application-module/application-module.jar"]