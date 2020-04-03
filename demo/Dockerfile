FROM openjdk:12-jdk-alpine AS BUILD_IMAGE
WORKDIR /code/
COPY build.gradle settings.gradle gradlew /code/
COPY gradle /code/gradle
RUN ./gradlew build || return 0
COPY . .
RUN ./gradlew build

FROM openjdk:12-jdk-alpine

RUN apk add bash
WORKDIR /code/
COPY --from=BUILD_IMAGE /code/build/libs/demo.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]