FROM java:8

MAINTAINER hicjcn hicjcn@gmail.com

VOLUME /app

ADD ./target/file-service-0.0.1-SNAPSHOT.jar app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 80

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "--spring.profiles.active=pro"]
