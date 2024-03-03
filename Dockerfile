FROM openjdk:latest
COPY ./target/classes/com /tmp/com
WORKDIR /tmp
ENTRYPOINT ["java", "cw.group8.App"]

FROM openjdk:latest
COPY ./target/Group8-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group8-0.1.0.1-jar-with-dependencies.jar"]