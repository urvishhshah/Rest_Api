
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM alpine:latest

CMD ["/bin/sh"]

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/your-app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
