FROM openjdk:11-jdk
EXPOSE 8081
VOLUME /tmp
ARG JAR_FILE=target/product-reader-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} product-reader.jar
ENTRYPOINT ["java","-jar","/product-reader.jar"]