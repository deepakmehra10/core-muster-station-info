FROM openjdk:8-jre-alpine

RUN apk add --update \
    bash \
    tcpdump \
    && rm -rf /var/cache/apk/*

RUN echo "Adding entryPoint.sh"
ADD ./maven/entryPoint.sh /entryPoint.sh

RUN echo "Copying app.jar"
COPY ./maven/*.jar app.jar

ENTRYPOINT ["/entryPoint.sh"]