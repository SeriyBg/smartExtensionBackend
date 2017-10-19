FROM alpine:3.6 as project
WORKDIR /app
COPY . /app/smartExtensionBackend

FROM gradle:4.2.1-jdk8-alpine as build
WORKDIR /app
COPY --from=project /app/smartExtensionBackend /app
USER root
RUN chown -R gradle /app
USER gradle
RUN ./gradlew build

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/BackendJava-1.0-SNAPSHOT.jar /app
EXPOSE 8083
CMD ["/usr/bin/java", "-jar", "BackendJava-1.0-SNAPSHOT.jar"]
