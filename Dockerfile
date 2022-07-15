FROM openjdk:11
EXPOSE 8082
ADD target/DemoEurekaClient2.jar DemoEurekaClient2.jar
ENTRYPOINT ["java","-jar","/DemoEurekaClient2.jar"]