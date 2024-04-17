FROM openjdk:latest
COPY ./target/classes/cw /tmp/cw
WORKDIR /tmp
ENTRYPOINT ["java", "cw.group8.App"]

FROM openjdk:latest
COPY ./target/Group8.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group8.jar", "db:3306", "10000"]