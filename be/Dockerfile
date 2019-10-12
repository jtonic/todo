#FROM amazoncorretto:11
# use zulu jr3 version because is based on alpine (smaller image size) and is LTS
FROM azul/zulu-openjdk-alpine:11.0.4-jre
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","ro.jtonic.apps.todo.TodoApplication"]
