FROM openjdk:11.0.1-jdk

RUN mkdir -p /opt/example /opt/scripts

WORKDIR /opt/example

ADD docker/entrypoint.sh /opt/scripts

ADD build.gradle /opt/example/
ADD settings.gradle /opt/example/
ADD gradlew /opt/example/
ADD gradle/ /opt/example/gradle/

RUN chmod a+x -Rv /opt/scripts/* /opt/example/gradlew

RUN ./gradlew wrapper --distribution-type all --gradle-version 4.10.2

ENTRYPOINT ["/opt/scripts/entrypoint.sh"]

ADD src/ /opt/example/src
