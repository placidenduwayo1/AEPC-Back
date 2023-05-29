FROM maven:3.8.3-openjdk-17-slim AS builder
EXPOSE 8280
ARG JAR_FILE=target/microservices-config-service.jar
ADD ${JAR_FILE} microservices-config-service.jar
RUN java -Djarmode=layertools -jar microservices-config-service.jar extract

FROM maven:3.8.3-openjdk-17-slim
ENTRYPOINT ["java", "-Dspring.profiles.active=develop", "org.springframework.boot.loader.JarLauncher"]
COPY --from=builder dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder application/ ./
