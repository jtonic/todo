FROM azul/zulu-openjdk-alpine:11.0.4 as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN  ./mvnw package -DskipTests

FROM azul/zulu-openjdk-alpine:11.0.4-jre as prod
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency

RUN addgroup -S todo && adduser -S todo -G todo
USER todo

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","ro.jtonic.apps.todo.TodoApplication"]
