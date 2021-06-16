FROM openjdk:14-ea-12-jdk-alpine
EXPOSE 5500
ADD target/moneytf-0.0.1-SNAPSHOT.jar moneytf.jar
ENTRYPOINT ["java","-jar","/moneytf.jar"]