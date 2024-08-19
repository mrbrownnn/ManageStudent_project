#
# Build stage
#
# Use the official Maven/Java 17 image
FROM maven:3.8.3-openjdk-17 AS build
LABEL authors="Ace Nghiem"
COPY ./src /home/booking/src
COPY pom.xml /home/booking
RUN mvn -f /home/booking/pom.xml clean package
#Specify that expose server port
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/booking/target/booking.jar"]