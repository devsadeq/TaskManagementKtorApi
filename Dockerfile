FROM openjdk:11 as builder

COPY . .

RUN ./gradlew buildFatJar

FROM openjdk:11

COPY --from=builder /build/libs/play_mongo.jar ./play_mongo.jar

CMD ["java", "-jar", "play_mongo.jar"]