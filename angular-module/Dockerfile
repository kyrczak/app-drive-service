FROM nginx:1.23.3

LABEL org.opencontainers.image.title = "angular-module"
LABEL org.opencontainers.image.authors="Patryk Korczak"
LABEL org.opencontainers.image.source="https://github.com/kyrczak/architektury_uslug_internetowych"
LABEL org.opencontainers.image.description="Angular module"
LABEL org.opencontainers.image.version="1.0.0"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV API_URL http://localhost:8080/api
EXPOSE 80

ADD dist/angular-module /usr/share/nginx/html
ADD docker/etc/nginx/templates/ /etc/nginx/templates/