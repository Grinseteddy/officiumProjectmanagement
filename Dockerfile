FROM openjdk:latest
COPY ./target/projectmanagement-0.0.3.jar /usr/src/projectmanagement-0.0.3.jar
EXPOSE 5000
CMD java -jar /usr/src/taskmanagement-0.0.3.jar