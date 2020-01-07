FROM openjdk:8
EXPOSE 8080
ADD target/image-store-service.jar image-store-service.jar
ENTRYPOINT ["java","-jar","/image-store-service.jar"]