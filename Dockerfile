#Build
FROM maven:3.8.4-openjdk-8 as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#Package
FROM openjdk:8
COPY --from=build /home/app/target/teste-backend-1.0-SNAPSHOT.jar /home/app/teste-backend.jar

ENTRYPOINT [ "java", "-jar", "/home/app/teste-backend.jar" ]
