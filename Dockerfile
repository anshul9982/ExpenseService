# Dockerfiles/expenseservice.Dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY ../jars/expenseservice.jar app.jar
EXPOSE 9900
CMD ["java", "-jar", "app.jar"]