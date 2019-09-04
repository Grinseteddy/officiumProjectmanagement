FROM openjdk:latest
COPY ./target/projectmangement-0.0.3.jar /usr/src/projectmangement-0.0.3.jar
EXPOSE 5001
CMD java -jar /usr/src/projectmangement-0.0.3.jar