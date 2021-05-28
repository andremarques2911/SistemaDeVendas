#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/sistemavendas-0.0.1-SNAPSHOT.jar /usr/local/lib/sistemavendas.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/sistemavendas.jar"]

# Build Image:
# docker build -t sistemavendas .

# Run Image:
# docker run -p 8080:8080 --rm -it sistemavendas:latest


#FROM maven:3.5-jdk-8 AS build
#COPY src /usr/src/app/src
#COPY pom.xml /usr/src/app
#RUN mvn -f /usr/src/app/pom.xml clean package

#FROM gcr.io/distroless/java
#COPY --from=build /usr/src/app/target/helloworld-1.0.0-SNAPSHOT.jar /usr/app/helloworld-1.0.0-SNAPSHOT.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/app/helloworld-1.0.0-SNAPSHOT.jar"]