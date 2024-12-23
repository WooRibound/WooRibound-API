FROM --platform=linux/amd64 amazoncorretto:17-alpine
WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", \
    "-verbose:gc", \
    "-jar", \
    "-Dspring.profiles.active=prod", \
    "app.jar"]