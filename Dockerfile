FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/jordan1997/smartExtensionBackend.git

FROM gradle:4.2.1-jdk8-alpine as build
WORKDIR /app
COPY --from=clone /app/smartExtensionBackend /app
USER root
RUN chown -R gradle /app
USER gradle
RUN ./gradlew build

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/BackendJava-1.0-SNAPSHOT.jar /app
EXPOSE 8083
CMD ["/usr/bin/java", "-jar", "BackendJava-1.0-SNAPSHOT.jar"]
