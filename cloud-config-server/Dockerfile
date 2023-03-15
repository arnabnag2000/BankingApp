FROM openjdk:17.0.3
EXPOSE 9296
ADD target/cloud-config-server-0.0.1-SNAPSHOT.jar cloud-config-server-0.0.1-SNAPSHOT.jar
ADD entrypoint.sh entrypoint.sh
ENTRYPOINT ["java","-jar","/cloud-config-server-0.0.1-SNAPSHOT.jar"]
